package com.example.demo;

import com.example.demo.AboutEvent.Models.Event;
import com.example.demo.AboutEvent.Repository.EventRepository;
import com.example.demo.AboutEvent.Service.EventServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EventServiceImplTest {

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private EventServiceImpl eventService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetALLEvents() {
        List<Event> events = new ArrayList<>();
        events.add(new Event());
        when(eventRepository.findAll()).thenReturn(events);

        List<Event> result = eventService.getALLEvents();

        assertEquals(events, result);
    }

    // Similar test methods for other methods in EventServiceImpl...

    @Test
    public void testRemainingBudget() {
        long eventId = 1L;
        double totalBudget = 1000.0;
        double totalDepenses = 500.0;
        when(eventRepository.existsById(eventId)).thenReturn(true);
        when(eventRepository.findById(eventId)).thenReturn(Optional.of(new Event()));
        when(eventService.generateBudgetotal(eventId)).thenReturn(totalBudget);
        when(eventService.generateDepenseTotal(eventId)).thenReturn(totalDepenses);

        double result = eventService.remainingBudget(eventId);

        assertEquals(totalBudget - totalDepenses, result);
    }
}

