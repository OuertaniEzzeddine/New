package com.example.demo.AboutEvent.Contoller;

import com.example.demo.AboutEvent.Models.Sponsor;
import com.example.demo.AboutEvent.Service.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sponsors")
public class SponsorController {

    private final SponsorService sponsorService;

    @Autowired
    public SponsorController(SponsorService sponsorService) {
        this.sponsorService = sponsorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sponsor> getSponsorById(@PathVariable Integer id) {
        Sponsor sponsor = sponsorService.getSponsortbyId(id);
        return sponsor != null ? ResponseEntity.ok(sponsor) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Sponsor> createSponsor(@RequestBody Sponsor sponsor) {
        Sponsor createdSponsor = sponsorService.createSponsor(sponsor);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSponsor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sponsor> updateSponsor(@PathVariable Integer id, @RequestBody Sponsor sponsor) {
        Sponsor updatedSponsor = sponsorService.updateSponsor(id, sponsor);
        return updatedSponsor != null ? ResponseEntity.ok(updatedSponsor) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSponsor(@PathVariable Integer id) {
        sponsorService.deleteSponsor(id);
        return ResponseEntity.noContent().build();
    }
}
