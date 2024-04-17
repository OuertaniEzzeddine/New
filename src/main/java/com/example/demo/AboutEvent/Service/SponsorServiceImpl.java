package com.example.demo.AboutEvent.Service;

import com.example.demo.AboutEvent.Models.*;
import com.example.demo.AboutEvent.Repository.SponsorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class SponsorServiceImpl implements SponsorService {
    public final SponsorRepository sponsorRepository;
    public SponsorServiceImpl(SponsorRepository sponsorRepository)
    {this.sponsorRepository=sponsorRepository;}

    @Override
    public Sponsor getSponsortbyId(Integer id) {
        Optional<Sponsor> optionalSponsor = sponsorRepository.findById(id);
        return optionalSponsor.orElse(null);
    }

    @Override
    public Sponsor createSponsor(Sponsor s) {
        sponsorRepository.save(s);
        return s;
    }

    @Override
    public Sponsor updateSponsor(Integer id, Sponsor s) {
        if (sponsorRepository.existsById(id)) {
            s.setId(id);
            return sponsorRepository.save(s);
        }
        return null; // Or throw an exception
    }

    @Override
    public void deleteSponsor(Integer id) {
        sponsorRepository.deleteById(id);

    }
}
