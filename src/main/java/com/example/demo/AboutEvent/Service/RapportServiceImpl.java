package com.example.demo.AboutEvent.Service;

import com.example.demo.AboutEvent.Models.*;
import com.example.demo.AboutEvent.Repository.RapportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class RapportServiceImpl implements RapportService {
    public final RapportRepository rapportRepository;
    public RapportServiceImpl(RapportRepository rapportRepository)
    {this.rapportRepository = rapportRepository;}

    @Override
    public Rapport getRapporttbyId(Integer id) {
        Optional<Rapport> optionalRapport = rapportRepository.findById(id);
        return optionalRapport.orElse(null);
    }

    @Override
    public Rapport createRapport(Rapport b) {
        rapportRepository.save(b);
        return b;
    }

    @Override
    public Rapport updateRapport(Integer id, Rapport r) {
        if (rapportRepository.existsById(id)) {
            r.setIdRapport(id);
            return rapportRepository.save(r);
        }
        return null; // Or throw an exception
    }

    @Override
    public void deleteRapport(Integer id) {
        rapportRepository.deleteById(id);

    }
}
