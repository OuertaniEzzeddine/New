package com.example.demo.Users.Repository;

import com.example.demo.Users.Models.Admin;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    // Additional custom queries can be defined here if needed
}
