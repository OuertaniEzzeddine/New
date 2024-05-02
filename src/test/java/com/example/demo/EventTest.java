package com.example.demo;
import com.example.demo.AboutEvent.Models.Event;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EventTest {

    @Test
    public void testEqualsAndHashCode() {
        Event event1 = new Event();
        event1.setIdEvent(1L);
        event1.setNom("Event 1");
        event1.setDate("2024-04-17");
        event1.setLieu("Location 1");
        event1.setTheme("Theme 1");
        event1.setNombrePersonne(100);

        Event event2 = new Event();
        event2.setIdEvent(1L);
        event2.setNom("Event 1");
        event2.setDate("2024-04-17");
        event2.setLieu("Location 1");
        event2.setTheme("Theme 1");
        event2.setNombrePersonne(100);

        assertEquals(event1, event2); // Test equals method
        assertEquals(event1.hashCode(), event2.hashCode()); // Test hashCode method
    }

    @Test
    public void testNotEquals() {
        Event event1 = new Event();
        event1.setIdEvent(1L);
        event1.setNom("Event 1");
        event1.setDate("2024-04-17");
        event1.setLieu("Location 1");
        event1.setTheme("Theme 1");
        event1.setNombrePersonne(100);

        Event event2 = new Event();
        event2.setIdEvent(2L);
        event2.setNom("Event 2");
        event2.setDate("2024-04-18");
        event2.setLieu("Location 2");
        event2.setTheme("Theme 2");
        event2.setNombrePersonne(200);

        assertNotEquals(event1, event2); // Test equals method with different objects
        assertNotEquals(event1.hashCode(), event2.hashCode()); // Test hashCode method with different objects
    }

    @Test
    public void testListEqualsAndHashCode() {
        Event event1 = new Event();
        event1.setIdEvent(1L);
        event1.setNom("Event 1");
        event1.setDate("2024-04-17");
        event1.setLieu("Location 1");
        event1.setTheme("Theme 1");
        event1.setNombrePersonne(100);

        Event event2 = new Event();
        event2.setIdEvent(1L);
        event2.setNom("Event 1");
        event2.setDate("2024-04-17");
        event2.setLieu("Location 1");
        event2.setTheme("Theme 1");
        event2.setNombrePersonne(100);

        List<Event> eventList1 = new ArrayList<>();
        eventList1.add(event1);

        List<Event> eventList2 = new ArrayList<>();
        eventList2.add(event2);

        assertEquals(eventList1, eventList2); // Test list equality
        assertEquals(eventList1.hashCode(), eventList2.hashCode()); // Test list hashCode
    }

    @Test
    public void testListNotEquals() {
        Event event1 = new Event();
        event1.setIdEvent(1L);
        event1.setNom("Event 1");
        event1.setDate("2024-04-17");
        event1.setLieu("Location 1");
        event1.setTheme("Theme 1");
        event1.setNombrePersonne(100);

        Event event2 = new Event();
        event2.setIdEvent(2L);
        event2.setNom("Event 2");
        event2.setDate("2024-04-18");
        event2.setLieu("Location 2");
        event2.setTheme("Theme 2");
        event2.setNombrePersonne(200);

        List<Event> eventList1 = new ArrayList<>();
        eventList1.add(event1);

        List<Event> eventList2 = new ArrayList<>();
        eventList2.add(event2);

        assertNotEquals(eventList1, eventList2); // Test list equality with different objects
        assertNotEquals(eventList1.hashCode(), eventList2.hashCode()); // Test list hashCode with different objects
    }
}

