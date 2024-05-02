package com.example.demo.AboutEvent.Service;

import com.example.demo.AboutEvent.Models.*;
import com.example.demo.AboutEvent.Repository.RapportRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class RapportServiceImpl implements RapportService {
    private static final Logger logger = LogManager.getLogger(RapportServiceImpl.class);


    public final RapportRepository rapportRepository;
    public RapportServiceImpl(RapportRepository rapportRepository)
    {this.rapportRepository = rapportRepository;}

    @Override
    public Rapport getRapporttbyId(Integer id) {
        logger.info("Getting rapport with id {}", id);
        Optional<Rapport> optionalRapport = rapportRepository.findById(id);
        Rapport r = optionalRapport.orElse(null);
        if (r==null) {
            logger.warn("Rapport with id {} does not exist", id);
            return r;
        } return r;
    }

    @Override
    public Rapport createRapport(Rapport b) {
        logger.info("Creating Rapport {}",b);
        rapportRepository.save(b);
        return b;
    }

    @Override
    public Rapport updateRapport(Integer id, Rapport r) {
        logger.info("Updating rapport with id {}",id);
        if (rapportRepository.existsById(id)) {
            r.setIdRapport(id);
            return rapportRepository.save(r);
        }
        logger.warn("Rapport with id {} not found",id);
        return null; 
    }

    @Override
    public void deleteRapport(Integer id) {
        logger.info("Deleting rapport with id {}", id);
        rapportRepository.deleteById(id);

    }
}
