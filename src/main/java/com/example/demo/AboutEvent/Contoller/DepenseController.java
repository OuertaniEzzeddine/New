
package com.example.demo.AboutEvent.Contoller;

import com.example.demo.AboutEvent.Models.Depense;
import com.example.demo.AboutEvent.Service.DepenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/depenses")
public class DepenseController {

    private final DepenseService depenseService;

    @Autowired
    public DepenseController(DepenseService depenseService) {
        this.depenseService = depenseService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Depense> getDepenseById(@PathVariable Integer id) {
        Depense depense = depenseService.getDepensetbyId(id);
        return depense != null ? ResponseEntity.ok(depense) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Depense> createDepense(@RequestBody Depense depense) {
        Depense createdDepense = depenseService.createDepense(depense);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDepense);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Depense> updateDepense(@PathVariable Integer id, @RequestBody Depense depense) {
        Depense updatedDepense = depenseService.updateDepense(id, depense);
        return updatedDepense != null ? ResponseEntity.ok(updatedDepense) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepense(@PathVariable Integer id) {
        depenseService.deleteDepense(id);
        return ResponseEntity.noContent().build();
    }
}
