package com.example.demo.AboutEvent.Service;

import com.example.demo.AboutEvent.Models.*;
import com.example.demo.AboutEvent.Repository.SponsorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SponsorServiceImpl implements SponsorService {

    public final SponsorRepository sponsorRepository;

    public SponsorServiceImpl(SponsorRepository sponsorRepository) {
        this.sponsorRepository = sponsorRepository;
    }

    @Override
    public Sponsor getSponsortbyId(Integer id) {
        Optional<Sponsor> optionalSponsor = sponsorRepository.findById(id);
        return optionalSponsor.orElse(null);
    }

    @Override
    public Sponsor createSponsor(Sponsor sponsor) {
        if (sponsor == null) {
            throw new IllegalArgumentException("Sponsor cannot be null");
        }
        sponsorRepository.save(sponsor);
        return sponsor;
    }

    @Override
    public Sponsor updateSponsor(Integer id, Sponsor sponsor) {
        if (!sponsorRepository.existsById(id)) {
            throw new IllegalArgumentException("Sponsor with id " + id + " not found for update");
        }
        sponsor.setId(id);
        return sponsorRepository.save(sponsor);
    }

    @Override
    public void deleteSponsor(Integer id) {
        if (!sponsorRepository.existsById(id)) {
            throw new IllegalArgumentException("Sponsor with id " + id + " not found for deletion");
        }
        sponsorRepository.deleteById(id);
    }
}
