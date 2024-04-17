package com.example.demo.AboutEvent.Contoller;

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
}
