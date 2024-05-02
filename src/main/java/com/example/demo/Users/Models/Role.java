package com.example.demo.Users.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Role {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private String name;

    @ManyToMany (mappedBy = "roles")
    @JsonIgnore
    private List<User> userz;
}
