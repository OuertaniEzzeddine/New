package com.example.demo.AboutEvent.Service;

import com.example.demo.AboutEvent.Models.*;
import com.example.demo.AboutEvent.Repository.DepenseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepenseServiceImpl implements DepenseService {

    public final DepenseRepository depenseRepository;

    public DepenseServiceImpl(DepenseRepository depenseRepository) {
        this.depenseRepository = depenseRepository;
    }

    @Override
    public Depense getDepensetbyId(Integer id) {
        Optional<Depense> optionalDepense = depenseRepository.findById(id);
        return optionalDepense.orElse(null);
    }

    @Override
    public Depense createDepense(Depense depense) {
        if (depense == null) {
            throw new IllegalArgumentException("Depense cannot be null");
        }
        depenseRepository.save(depense);
        return depense;
    }

    @Override
    public Depense updateDepense(Integer id, Depense depense) {
        if (!depenseRepository.existsById(id)) {
            throw new IllegalArgumentException("Depense with id " + id + " not found for update");
        }
        depense.setIdDepense(id);
        return depenseRepository.save(depense);
    }

    @Override
    public void deleteDepense(Integer id) {
        if (!depenseRepository.existsById(id)) {
            throw new IllegalArgumentException("Depense with id " + id + " not found for deletion");
        }
        depenseRepository.deleteById(id);
    }
}
