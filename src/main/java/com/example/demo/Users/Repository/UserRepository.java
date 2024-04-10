package com.example.demo.Users.Repository;

import com.example.demo.Users.Models.User;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Additional custom queries can be defined here if needed
}