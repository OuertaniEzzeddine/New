package com.example.demo.AboutEvent.Contoller;

import com.example.demo.AboutEvent.Models.Rapport;
import com.example.demo.AboutEvent.Service.RapportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/rapports")
public class RapportController {

    private final RapportService rapportService;

    @Autowired
    public RapportController(RapportService rapportService) {
        this.rapportService = rapportService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rapport> getRapportById(@PathVariable Integer id) {
        Rapport rapport = rapportService.getRapporttbyId(id);
        return rapport != null ? ResponseEntity.ok(rapport) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Rapport> createRapport(@RequestBody Rapport rapport) {
        Rapport createdRapport = rapportService.createRapport(rapport);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRapport);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rapport> updateRapport(@PathVariable Integer id, @RequestBody Rapport rapport) {
        Rapport updatedRapport = rapportService.updateRapport(id, rapport);
        return updatedRapport != null ? ResponseEntity.ok(updatedRapport) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRapport(@PathVariable Integer id) {
        rapportService.deleteRapport(id);
        return ResponseEntity.noContent().build();
    }
}
