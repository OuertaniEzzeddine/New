package com.example.demo.AboutEvent.Service;

import com.example.demo.AboutEvent.DTO.BudgetDTO;
import com.example.demo.AboutEvent.DTO.DepenseDTO;
import com.example.demo.AboutEvent.DTO.EventDTO;
import com.example.demo.AboutEvent.DTO.FactureDTO;
import com.example.demo.AboutEvent.DTO.RapportDTO;
import com.example.demo.AboutEvent.DTO.RevenuDTO;
import com.example.demo.AboutEvent.DTO.SponsorDTO;
import com.example.demo.AboutEvent.Models.*;

import lombok.NoArgsConstructor;

import java.util.List;

public interface EventService {
    List<Event> getALLEvents();
    Event getEventbyId(long id);
    EventDTO createEvent(EventDTO e);
    Event updateEvent(long id ,Event e);
    void deleteEvent(long id);
    List<FactureDTO> generateALLFacture(long id);
    List<SponsorDTO> generateSponsors(long id);
    List<BudgetDTO> generateBudgets(long id);
    double generateBudgetotal(long id);
    List<DepenseDTO> generateDepenses(long id);
    double generateDepenseTotal(long id);
    double remainingBudget(long id);
    List<RevenuDTO> generateRevenus(long id);
    RapportDTO generateRapport(Long id);
}
