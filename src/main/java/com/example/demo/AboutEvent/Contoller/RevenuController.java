package com.example.demo.AboutEvent.Contoller;

import com.example.demo.AboutEvent.Models.Revenu;
import com.example.demo.AboutEvent.Service.RevenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/revenus")
public class RevenuController {

    private final RevenuService revenuService;

    @Autowired
    public RevenuController(RevenuService revenuService) {
        this.revenuService = revenuService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Revenu> getRevenuById(@PathVariable Integer id) {
        Revenu revenu = revenuService.getRevenutbyId(id);
        return revenu != null ? ResponseEntity.ok(revenu) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Revenu> createRevenu(@RequestBody Revenu revenu) {
        Revenu createdRevenu = revenuService.createRevenu(revenu);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRevenu);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Revenu> updateRevenu(@PathVariable Integer id, @RequestBody Revenu revenu) {
        Revenu updatedRevenu = revenuService.updateRevenu(id, revenu);
        return updatedRevenu != null ? ResponseEntity.ok(updatedRevenu) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRevenu(@PathVariable Integer id) {
        revenuService.deleteRevenu(id);
        return ResponseEntity.noContent().build();
    }
}
