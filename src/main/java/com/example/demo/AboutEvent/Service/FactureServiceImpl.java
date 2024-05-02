package com.example.demo.AboutEvent.Service;

import com.example.demo.AboutEvent.Models.*;
import com.example.demo.AboutEvent.Repository.FactureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FactureServiceImpl implements FactureService {

    public final FactureRepository factureRepository;

    public FactureServiceImpl(FactureRepository factureRepository) {
        this.factureRepository = factureRepository;
    }

    @Override
    public Facture createFacture(Facture facture) {
        if (facture == null) {
            throw new IllegalArgumentException("Facture cannot be null");
        }
        factureRepository.save(facture);
        return facture;
    }

    @Override
    public Facture updateFacture(Integer id, Facture facture) {
        if (!factureRepository.existsById(id)) {
            throw new IllegalArgumentException("Facture with id " + id + " not found for update");
        }
        facture.setIdFacture(id);
        return factureRepository.save(facture);
    }

    @Override
    public void deleteFacture(Integer id) {
        if (!factureRepository.existsById(id)) {
            throw new IllegalArgumentException("Facture with id " + id + " not found for deletion");
        }
        factureRepository.deleteById(id);
    }

    @Override
    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }

    @Override
    public Facture getFactureById(Integer id) {
        Optional<Facture> optionalFacture = factureRepository.findById(id);
        return optionalFacture.orElse(null);
    }
}
