package com.example.demo.AboutEvent.Service;

import com.example.demo.AboutEvent.Models.*;
import com.example.demo.AboutEvent.Repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service ("eventServicev1")
public class EventServiceImpl implements EventService{
    private static final Logger logger = LogManager.getLogger(EventServiceImpl.class);

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    @Override
    public List<Event> getALLEvents() {
        logger.info("Getting all events: ");
        return eventRepository.findAll();
    }


    @Override
    public Event getEventbyId(long id) {
        logger.info("Getting event by id: {}", id);
        Optional<Event> optionalEvent =eventRepository.findById(id);
        Event e = optionalEvent.orElse(null);
        if (e==null) {
            logger.warn("Event with id {} not found", id);
        }
        return e;
    }





    @Override
    public Event createEvent(Event e) {
        logger.info("Creating event: {}",e);
        return eventRepository.save(e);
    }


    @Override
    //***************************************************
    public Event updateEvent(long id, Event e) {
        logger.info("Updating event with id {}", id);

        if (eventRepository.existsById(id)) {
            e.setIdEvent(id);
            return eventRepository.save(e);
        } else {
            logger.warn("Event with id {} not found for update", id);
            return null;
        }
       
    }


    @Override
    public void deleteEvent(long id) {
        logger.info("Deleting Event with id {}",id);
        eventRepository.deleteById(id);

    }


    @Override
    public List<Facture> generateALLFacture(long id) {
        logger.info("Finding Factures for event with id {}",id);
        if (eventRepository.existsById(id)) {
            return eventRepository.findById(id).get().getFactures();

        }else {
            logger.warn("event with id {} not found", id);
            return null;
        }
    }


    @Override
    public List<Sponsor> generateSponosors(long id) {
        logger.info("Getting Sponsors for event with id {}",id);
        if (eventRepository.existsById(id)) {
            return eventRepository.findById(id).get().getSponsors();

        }
        logger.warn("Event with id {} not found ",id);
        return null;
    }


    @Override
    public List<Budget> generateBudgets(long id) {
        logger.info("Getting Budgets for event with id {}",id);

        if (eventRepository.existsById(id)) {
            return eventRepository.findById(id).get().getBudgets();

        }
        logger.warn("Event with id {} not found ",id);
        return null; // Or throw an exception
    }


    @Override
    public double generateBudgetotal(long id) {
        logger.info("Calculating Budget:");
        double s=0;
        if (eventRepository.existsById(id)) {
            List<Budget> l= eventRepository.findById(id).get().getBudgets();
            for(Budget e:l) {s+=e.getMontant();}
            return s;


            }
            logger.warn("Event with id {} does not exist", id);
            return s; 

    }


    @Override
    public List<Depense> generateDepenses(long id) {
        logger.info("Getting Depenses: ");
        if (eventRepository.existsById(id)) {
            return eventRepository.findById(id).get().getDepenses();

        }
        logger.warn("Event with id {} not found", id);
        return null; 
    }


    @Override
    public double generateDepenseTotal(long id) {
        logger.info("Calculating total depenses for event with id {}",id);
        double s=0;
        if (eventRepository.existsById(id)) {
            List<Depense> l= eventRepository.findById(id).get().getDepenses();
            for(Depense e:l) {s+=e.getMontant();}
            return s;


        }
        logger.warn("Event with id {} not found", id);
        return s; 
    }


    @Override
    public double remainingBudget(long id) {
        logger.info("Calculating remaining budget for event with id {}",id);
        return generateBudgetotal(id) - generateDepenseTotal(id);
    }
}
