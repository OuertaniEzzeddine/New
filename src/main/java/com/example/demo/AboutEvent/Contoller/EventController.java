package com.example.demo.AboutEvent.Contoller;

import com.example.demo.AboutEvent.DTO.BudgetDTO;
import com.example.demo.AboutEvent.DTO.DepenseDTO;
import com.example.demo.AboutEvent.DTO.EventDTO;
import com.example.demo.AboutEvent.DTO.FactureDTO;
import com.example.demo.AboutEvent.DTO.RapportDTO;
import com.example.demo.AboutEvent.DTO.RevenuDTO;
import com.example.demo.AboutEvent.DTO.SponsorDTO;
import com.example.demo.AboutEvent.Models.Event;
import com.example.demo.AboutEvent.Service.EventService;

import lombok.Setter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Setter
@RestController
@RequestMapping("/auth/events")
public class EventController {
    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    @PostMapping
    public ResponseEntity<EventDTO> createEvent(@RequestBody EventDTO event) {
        EventDTO createdEvent = eventService.createEvent(event);
        return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Event>> getALLEvents() {
        List<Event> events = eventService.getALLEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }


    //getting event by id
    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Event event = eventService.getEventbyId(id);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    //Get all factures for event
    @GetMapping("/{id}/factures") 
    public ResponseEntity<List<FactureDTO>> getAllFacturesForEvent(@PathVariable Long id) {
        List<FactureDTO> factures = eventService.generateALLFacture(id);
        if (factures == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(factures, HttpStatus.OK);
    }

    //Get all Budgets for an event
    @GetMapping("/{id}/budgets") 
    public ResponseEntity<List<BudgetDTO>> getAllBudgetsForEvent(@PathVariable Long id) {
        List<BudgetDTO> budgets = eventService.generateBudgets(id);
        if (budgets == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<BudgetDTO>>(budgets, HttpStatus.OK);
    }

    // Get all Depenses for an event
    @GetMapping("/{id}/depenses") 
    public ResponseEntity<List<DepenseDTO>> getAllDepensesForEvent(@PathVariable Long id) {
        List<DepenseDTO> depenses = eventService.generateDepenses(id);
        if (depenses == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(depenses, HttpStatus.OK);
    }
    // Get all Revenus for an event
    @GetMapping("/{id}/revenus") 
    public ResponseEntity<List<RevenuDTO>> getAllRevenusForEvent(@PathVariable Long id) {
        List<RevenuDTO> revenus = eventService.generateRevenus(id);
        if (revenus == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(revenus, HttpStatus.OK);
    }
        // Get all Sponsors for an event
    @GetMapping("/{id}/sponsors") 
    public ResponseEntity<List<SponsorDTO>> getAllSponsorsForEvent(@PathVariable Long id) {
        List<SponsorDTO> sponsors = eventService.generateSponsors(id);
        if (sponsors == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(sponsors, HttpStatus.OK);
    }

    //get rapport
    @GetMapping("/{id}/rapport")
    public ResponseEntity<RapportDTO> getRapportForEvent(@PathVariable Long id) {
        RapportDTO rapport = eventService.generateRapport(id);
        if (rapport == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rapport, HttpStatus.OK);
    }



}
