package com.example.demo.AboutEvent.Service;

import com.example.demo.AboutEvent.Models.*;
import com.example.demo.AboutEvent.Repository.RapportRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RapportServiceImpl implements RapportService {

    public final RapportRepository rapportRepository;

    public RapportServiceImpl(RapportRepository rapportRepository) {
        this.rapportRepository = rapportRepository;
    }

    @Override
    public Rapport getRapporttbyId(Integer id) {
        Optional<Rapport> optionalRapport = rapportRepository.findById(id);
        return optionalRapport.orElse(null);
    }

    @Override
    public Rapport createRapport(Rapport rapport) {
        if (rapport == null) {
            throw new IllegalArgumentException("Rapport cannot be null");
        }
        rapportRepository.save(rapport);
        return rapport;
    }

    @Override
    public Rapport updateRapport(Integer id, Rapport rapport) {
        if (!rapportRepository.existsById(id)) {
            throw new IllegalArgumentException("Rapport with id " + id + " not found for update");
        }
        rapport.setIdRapport(id);
        return rapportRepository.save(rapport);
    }

    @Override
    public void deleteRapport(Integer id) {
        if (!rapportRepository.existsById(id)) {
            throw new IllegalArgumentException("Rapport with id " + id + " not found for deletion");
        }
        rapportRepository.deleteById(id);
    }
}
