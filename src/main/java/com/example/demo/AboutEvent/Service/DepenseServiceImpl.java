package com.example.demo.AboutEvent.Service;


import com.example.demo.AboutEvent.Models.*;
import com.example.demo.AboutEvent.Repository.DepenseRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Service
public class DepenseServiceImpl implements DepenseService {
    private static final Logger logger = LogManager.getLogger(DepenseServiceImpl.class);

    public final DepenseRepository depenseRepository;
    public DepenseServiceImpl (DepenseRepository depenseRepository)
    {this.depenseRepository=depenseRepository;}

    @Override
    public Depense getDepensetbyId(Integer id) {
        logger.info("Getting depense by id: {}", id);
        Optional<Depense> optionalDepense = depenseRepository.findById(id);
        Depense d = optionalDepense.orElse(null);
        if (d==null) {
            logger.warn("Depense with id {} not found", id);
        } return d;
    }

    @Override
    public Depense createDepense(Depense D) {
        logger.info("Creating depense: {}", D);
        depenseRepository.save(D);
        return D;
    }

    @Override
    public Depense updateDepense(Integer id, Depense b) {
        logger.info("Updating depense with id {}", id);
        if (depenseRepository.existsById(id)) {
            b.setIdDepense(id);
            return depenseRepository.save(b);
        } else {
            logger.warn("Budget with id {} not found for update", id);
            return null; 
        }
    }

    @Override
    public void deleteDepense(Integer id) {
        logger.info("Deleting depense with id: {}", id);
        depenseRepository.deleteById(id);

    }
}
