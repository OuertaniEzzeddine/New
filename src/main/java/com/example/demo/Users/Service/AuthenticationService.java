package com.example.demo.Users.Service;

import com.example.demo.Users.Controller.AuthenticationRequest;
import com.example.demo.Users.Controller.AuthenticationResponse;
import com.example.demo.Users.Controller.RegistrationRequest;
import com.example.demo.Users.Models.Token;
import com.example.demo.Users.Models.User;
import com.example.demo.Users.Repository.RoleRepository;
import com.example.demo.Users.Repository.TokenRepository;
import com.example.demo.Users.Repository.UserRepository;
import com.example.demo.Users.Templates.EmailTemplateName;
import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final EmailService emailService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    private String activationUrl = "http://localhost:4200/activate-account";
    public void register(RegistrationRequest request) throws IllegalAccessException, MessagingException {
        var userRole = roleRepository.findByName("USER")
                .orElseThrow(()-> new IllegalAccessException("Role USER was not initialized"));

        var user = User.builder()
                .username(request.getUsername())
                .firstName(request.getFirstname())
                .lastName(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .accountLocked(false)
                .enabled(false)
                .roles(List.of(userRole))
                .build();

        userRepository.save(user);
        sendValidationEmail(user);

    }

    private void sendValidationEmail(User user) throws MessagingException {
        var newToken = generateAndSaveActivationToken(user);

        emailService.sendEmail(
                user.getEmail(),
                user.fullName(),
                EmailTemplateName.ACTIVATE_ACCOUNT,
                activationUrl,
                newToken,
                "Account activation"
        );
    }

    private String generateAndSaveActivationToken(User user) {
        String generatedToken = generateActivationCode(6);
        var token = Token.builder()
                .token(generatedToken)
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(15))
                .userr(user)
                .build();
        tokenRepository.save(token);
        return generatedToken;

    }

    private String generateActivationCode(int length) {
        String characters = "0123456789";
        StringBuilder codeBuilder = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0;i<length; i++) {
            int randomIndex = secureRandom.nextInt(characters.length());
            codeBuilder.append(characters.charAt(randomIndex));
        }
        return codeBuilder.toString();

}

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var claims = new HashMap<String, Object>();
        var user= ((User)auth.getPrincipal());
        claims.put("fullname",user.fullName());
        var jwtToken =jwtService.generateToken(claims,user);
        return AuthenticationResponse.builder()
                .token(jwtToken).build();



    }

    public void activateAccount(String token) throws MessagingException {
        Token savedToken = tokenRepository.findBytoken(token)
                .orElseThrow( () -> new RuntimeException("Invalid token"));
        if (LocalDateTime.now().isAfter(savedToken.getExpiresAt())){
            sendValidationEmail(savedToken.getUserr());
            throw new RuntimeException("Activation token has expired.A new token has been sent to this same email@");
        }
        var user= userRepository.findById(savedToken.getUserr().getId())
                .orElseThrow(() ->new UsernameNotFoundException("User not found"));
        user.setEnabled(true);
        userRepository.save(user);
        savedToken.setValidatedAt(LocalDateTime.now());
        tokenRepository.save(savedToken);}




}
