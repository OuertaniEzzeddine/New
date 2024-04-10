package com.example.demo.AboutEvent.Service;

import com.example.demo.AboutEvent.Models.*;

import java.util.List;

public interface EventService {
    List<Event> getALLEvents();
    Event getEventbyId(long id);
    Event createEvent(Event e);
    Event updateEvent(long id ,Event e);
    void deleteEvent(long id);
    List<Facture> generateALLFacture(long id);
    List<Sponsor> generateSponosors(long id);
    List<Budget> generateBudgets(long id);
    double generateBudgetotal(long id);
    List<Depense> generateDepenses(long id);
    double generateDepenseTotal(long id);
    double remainingBudget(long id);

}
