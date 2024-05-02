package com.example.demo.Users.Service;



import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


@Service
public class JwtService {


    private long jwtExpiration=5121;

    private String secretKey = Base64.getEncoder().encodeToString(Keys.secretKeyFor(SignatureAlgorithm.HS256).getEncoded());;



    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }

    String generateToken(Map<String, Object> extraClaims, UserDetails userDetails)
    {

        return buildToken(extraClaims,userDetails,jwtExpiration);
    }

    private String buildToken(
            Map<String, Object> extraClaims
            , UserDetails userDetails
            , long jwtExpiration) {
        var authorities = userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .claim("authorities",authorities)
                .signWith(getSignINkey())
                .compact()
                ;}
    private Key getSignINkey() {
        byte[] Keybytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(Keybytes);
        }
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims,T> claimResolver) {
        final Claims claims =extractALLclaims(token) ;
        return claimResolver.apply(claims);
    }

    private Claims extractALLclaims(String token) {
        return Jwts
                .parserBuilder().setSigningKey(getSignINkey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                ;
    }

    public boolean isTokenvalid(String token,UserDetails userDetails) {
        final String username= extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));


    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }
}

