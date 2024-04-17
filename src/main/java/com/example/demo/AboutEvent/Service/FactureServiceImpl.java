package com.example.demo.AboutEvent.Service;

import com.example.demo.AboutEvent.Models.*;
import com.example.demo.AboutEvent.Repository.FactureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class FactureServiceImpl implements FactureService{
    public final FactureRepository factureRepository;
    public FactureServiceImpl(FactureRepository factureRepository)
    {this.factureRepository=factureRepository;}
    @Override
    public Facture getFacturetbyId(Integer id) {
        Optional<Facture> optionalFacture = factureRepository.findById(id);
        return optionalFacture.orElse(null);
    }

    @Override
    public Facture createFacture(Facture f) {
        factureRepository.save(f);
        return f;
    }

    @Override
    public Facture updateFacture(Integer id, Facture f) {
        if (factureRepository.existsById(id)) {
            f.setIdFacture(id);
            return factureRepository.save(f);
        }
        return null; // Or throw an exception
    }

    @Override
    public void deleteFacture(Integer id) {
        factureRepository.deleteById(id);

    }
}
