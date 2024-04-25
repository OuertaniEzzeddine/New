package com.example.demo.AboutEvent.Repository;

import com.example.demo.AboutEvent.Models.*;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface FactureRepository extends JpaRepository<Facture, Integer> {

    

}