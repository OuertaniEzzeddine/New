package com.example.demo.AboutEvent.Service;

import com.example.demo.AboutEvent.Models.*;
import com.example.demo.AboutEvent.Repository.SponsorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Service
public class SponsorServiceImpl implements SponsorService {
    private static final Logger logger = LogManager.getLogger(SponsorServiceImpl.class);

    public final SponsorRepository sponsorRepository;
    public SponsorServiceImpl(SponsorRepository sponsorRepository)
    {this.sponsorRepository=sponsorRepository;}

    @Override
    public Sponsor getSponsortbyId(Integer id) {
        logger.info("Getting Sponsor with id {}",id);
        Optional<Sponsor> optionalSponsor = sponsorRepository.findById(id);
        Sponsor s= optionalSponsor.orElse(null);
        if (s==null) {
            logger.warn("Sponsor with id {} not found", id);
            return s;
        }return s;
    }

    @Override
    public Sponsor createSponsor(Sponsor s) {
        logger.info("Creating Sponsor:");
        sponsorRepository.save(s);
        return s;
    }

    @Override
    public Sponsor updateSponsor(Integer id, Sponsor s) {
        logger.info("Updating Sponsor with id {}",id);
        if (sponsorRepository.existsById(id)) {
            s.setId(id);
            return sponsorRepository.save(s);
        }logger.warn("Sponsor with id {} not found", id);
        return null;
    }

    @Override
    public void deleteSponsor(Integer id) {
        logger.info("Deleting sponsor with id {}", id);
        sponsorRepository.deleteById(id);

    }
}
