package com.example.demo.AboutEvent.Service;


import com.example.demo.AboutEvent.Models.*;
import com.example.demo.AboutEvent.Repository.DepenseRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class DepenseServiceImpl implements DepenseService {
    public final DepenseRepository depenseRepository;
    public DepenseServiceImpl (DepenseRepository depenseRepository)
    {this.depenseRepository=depenseRepository;}

    @Override
    public Depense getDepensetbyId(Integer id) {
        Optional<Depense> optionalDepense = depenseRepository.findById(id);
        return optionalDepense.orElse(null);
    }

    @Override
    public Depense createDepense(Depense D) {
        depenseRepository.save(D);
        return D;
    }

    @Override
    public Depense updateDepense(Integer id, Depense b) {
        if (depenseRepository.existsById(id)) {
            b.setIdDepense(id);
            return depenseRepository.save(b);
        }
        return null; // Or throw an exception
    }

    @Override
    public void deleteDepense(Integer id) {
        depenseRepository.existsById(id);

    }
}
