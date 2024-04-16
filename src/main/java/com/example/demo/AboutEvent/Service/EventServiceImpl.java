package com.example.demo.AboutEvent.Service;

import com.example.demo.AboutEvent.Models.*;
import com.example.demo.AboutEvent.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service ("eventServicev1")
public class EventServiceImpl implements EventService{

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    @Override
    public List<Event> getALLEvents() {
        return eventRepository.findAll();
    }


    @Override
    public Event getEventbyId(long id) {
        Optional<Event> optionalEvent =eventRepository.findById(id);
        return optionalEvent.orElse(null);
    }





    @Override
    public Event createEvent(Event e) {
        return eventRepository.save(e);
    }


    @Override
    //***************************************************
    public Event updateEvent(long id, Event e) {
        if (eventRepository.existsById(id)) {
            e.setIdEvent(id);
            return eventRepository.save(e);
        }
        return null; // Or throw an exception
    }


    @Override
    public void deleteEvent(long id) {
        eventRepository.deleteById(id);

    }


    @Override
    public List<Facture> generateALLFacture(long id) {
        if (eventRepository.existsById(id)) {
            return eventRepository.findById(id).get().getFactures();

        }
        return null; // Or throw an exception
    }


    @Override
    public List<Sponsor> generateSponosors(long id) {
        if (eventRepository.existsById(id)) {
            return eventRepository.findById(id).get().getSponsors();

        }
        return null; // Or throw an exception
    }


    @Override
    public List<Budget> generateBudgets(long id) {
        if (eventRepository.existsById(id)) {
            return eventRepository.findById(id).get().getBudgets();

        }
        return null; // Or throw an exception
    }


    @Override
    public double generateBudgetotal(long id) {
        double s=0;
        if (eventRepository.existsById(id)) {
            List<Budget> l= eventRepository.findById(id).get().getBudgets();
            for(Budget e:l) {s+=e.getMontant();}
            return s;


            }
            return s; // Or throw an exception


    }


    @Override
    public List<Depense> generateDepenses(long id) {
        if (eventRepository.existsById(id)) {
            return eventRepository.findById(id).get().getDepenses();

        }
        return null; // Or throw an exception
    }


    @Override
    public double generateDepenseTotal(long id) {
        double s=0;
        if (eventRepository.existsById(id)) {
            List<Depense> l= eventRepository.findById(id).get().getDepenses();
            for(Depense e:l) {s+=e.getMontant();}
            return s;


        }
        return s; // Or throw an exception
    }


    @Override
    public double remainingBudget(long id) {
        return generateBudgetotal(id) - generateDepenseTotal(id);
    }
}
