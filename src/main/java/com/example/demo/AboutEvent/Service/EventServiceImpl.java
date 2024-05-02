package com.example.demo.AboutEvent.Service;

import com.example.demo.AboutEvent.DTO.*;
import com.example.demo.AboutEvent.Mappers.*;
import com.example.demo.AboutEvent.Models.*;
import com.example.demo.AboutEvent.Repository.EventRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service ("eventServicev1")
public class EventServiceImpl implements EventService {
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
        Optional<Event> optionalEvent = eventRepository.findById(id);
        return optionalEvent.orElse(null);
    }

    @Override
    public EventDTO createEvent(EventDTO e) {
        Event newEvent = EventMapper.convertToEntity(e);
        for (Facture facture : newEvent.getFactures()) {
            facture.setEvent(newEvent);
        }
        for (Budget budget : newEvent.getBudgets()) {
            budget.setEvent(newEvent);
        }
        for (Depense depense : newEvent.getDepenses()) {
            depense.setEvent(newEvent);
        }
        for (Revenu revenu : newEvent.getRevenus()) {
            revenu.setEvent(newEvent);
        }
        for (Sponsor sponsor : newEvent.getSponsors()) {
            sponsor.setEvent(newEvent);
        }
        Rapport rapport = new Rapport();
        RapportDTO rapportDTO = generateRapport(newEvent.getIdEvent());
        rapport = RapportMapper.convertToEntity(rapportDTO);
        rapport.setE(newEvent);

        Event savedEvent = eventRepository.save(newEvent);
        return EventMapper.convertToDto(savedEvent);
    }

    @Override
    public Event updateEvent(long id, Event e) {
        if (eventRepository.existsById(id)) {
            e.setIdEvent(id);
            return eventRepository.save(e);
        } else {
            return null;
        }
    }

    @Override
    public void deleteEvent(long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public List<FactureDTO> generateALLFacture(long id) {
        List<FactureDTO> rr = new ArrayList<>();
        if (eventRepository.existsById(id)) {
            List<Facture> l = eventRepository.findById(id).get().getFactures();
            for (Facture e : l) {
                FactureDTO o = FactureMapper.convertToDto(e);
                rr.add(o);
            }
            return rr;
        } else {
            return null;
        }
    }

    @Override
    public List<BudgetDTO> generateBudgets(long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event with id " + id + " not found"));

        List<BudgetDTO> budgetDTOs = event.getBudgets().stream()
                .map(BudgetMapper::convertToDto)
                .collect(Collectors.toList());

        return budgetDTOs;
    }

    @Override
    public double generateBudgetotal(long id) {
        double s = 0;
        if (eventRepository.existsById(id)) {
            List<Budget> l = eventRepository.findById(id).get().getBudgets();
            for (Budget e : l) {
                s += e.getMontant();
            }
        }
        return s;
    }

    @Override
    public List<DepenseDTO> generateDepenses(long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event with id " + id + " not found"));

        List<DepenseDTO> depenseDTOs = event.getDepenses().stream()
                .map(DepenseMapper::convertToDto)
                .collect(Collectors.toList());

        return depenseDTOs;
    }

    @Override
    public double generateDepenseTotal(long id) {
        double s = 0;
        if (eventRepository.existsById(id)) {
            List<Depense> l = eventRepository.findById(id).get().getDepenses();
            for (Depense e : l) {
                s += e.getMontant();
            }
        }
        return s;
    }

    @Override
    public double remainingBudget(long id) {
        return generateBudgetotal(id) - generateDepenseTotal(id);
    }

    @Override
    public List<RevenuDTO> generateRevenus(long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event with id " + id + " not found"));

        List<RevenuDTO> revenuDTOs = event.getRevenus().stream()
                .map(RevenuMapper::convertToDto)
                .collect(Collectors.toList());

        return revenuDTOs;
    }

    @Override
    public List<SponsorDTO> generateSponsors(long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event with id " + id + " not found"));

        List<SponsorDTO> sponsorDTOs = event.getSponsors().stream()
                .map(SponsorMapper::convertToDto)
                .collect(Collectors.toList());

        return sponsorDTOs;
    }

    @Override
    public RapportDTO generateRapport(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event with id " + id + " not found"));

        List<DepenseDTO> depenseDTOs = event.getDepenses().stream()
                .map(DepenseMapper::convertToDto)
                .collect(Collectors.toList());

        List<RevenuDTO> revenuDTOs = event.getRevenus().stream()
                .map(RevenuMapper::convertToDto)
                .collect(Collectors.toList());

        RapportDTO rapportDTO = new RapportDTO();
        rapportDTO.setEventname(event.getNom());
        rapportDTO.setContenu("Rapport Financier Préparé le : " + LocalDate.now());
        rapportDTO.setDepenses(depenseDTOs);
        rapportDTO.setRevenus(revenuDTOs);

        return rapportDTO;
    }
}
