package com.example.demo.AboutEvent.Contoller;

import com.example.demo.AboutEvent.DTO.EventDTO;
import com.example.demo.AboutEvent.DTO.FactureDTO;
import com.example.demo.AboutEvent.Models.Event;
import com.example.demo.AboutEvent.Service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/events")
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
    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Event event = eventService.getEventbyId(id);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @GetMapping("/{id}/factures") // New endpoint to get all factures for an event
    public ResponseEntity<List<FactureDTO>> getAllFacturesForEvent(@PathVariable Long id) {
        List<FactureDTO> factures = eventService.generateALLFacture(id);
        if (factures == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(factures, HttpStatus.OK);
    }
}
