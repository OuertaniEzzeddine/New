package com.example.demo.AboutEvent.Service;

import com.example.demo.AboutEvent.Models.*;
import com.example.demo.AboutEvent.Repository.FactureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Service
public class FactureServiceImpl implements FactureService{
    private static final Logger logger = LogManager.getLogger(FactureServiceImpl.class);
    public final FactureRepository factureRepository;
    public FactureServiceImpl(FactureRepository factureRepository)
    {this.factureRepository=factureRepository;}




    @Override
    public Facture createFacture(Facture f) {
        logger.info("Creating facture:{}",f);
        factureRepository.save(f);
        return f;
    }

    @Override
    public Facture updateFacture(Integer id, Facture f) {
        logger.info("Updating facture with id  {}", id);
        if (factureRepository.existsById(id)) {
            f.setIdFacture(id);
            return factureRepository.save(f);
        }
        logger.warn("Facture with id {} doesn't exist",id);
        return null; // Or throw an exception
    }

    @Override
    public void deleteFacture(Integer id) {
        logger.info("Deleting facture with id {}",id);
        factureRepository.deleteById(id);

    }

    @Override
    public List<Facture> getAllFactures() {
        logger.info("Getting all factures: ");
        return factureRepository.findAll();
    }

    @Override
    public Facture getFactureById(Integer id) {

        logger.info("getting facture with id {}",id);
        Optional<Facture> optionalFacture = factureRepository.findById(id);
        Facture f = optionalFacture.orElse(null);
        if (f==null) {
            logger.warn("Facture with id {} does not exist",id);
            return f;
        } return f;

    }


}
