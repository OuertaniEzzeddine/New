package com.example.demo.AboutEvent.Service;

import com.example.demo.AboutEvent.Models.*;


public interface SponsorService {
    Sponsor getSponsortbyId(Integer id);
    Sponsor createSponsor(Sponsor s);
    Sponsor updateSponsor(Integer id , Sponsor s);
    void deleteSponsor(Integer id);
}
