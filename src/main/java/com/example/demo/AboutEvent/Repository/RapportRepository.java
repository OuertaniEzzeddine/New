package com.example.demo.AboutEvent.Repository;

import com.example.demo.AboutEvent.Models.*;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface RapportRepository extends JpaRepository<Rapport, Integer> {
    // Additional custom queries can be defined here if needed
}