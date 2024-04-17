package com.example.demo.AboutEvent.Service;


import com.example.demo.AboutEvent.Models.*;

public interface RapportService {
   Rapport getRapporttbyId(Integer id);
   Rapport createRapport(Rapport b);
   Rapport updateRapport(Integer id , Rapport r);
   void deleteRapport(Integer id);
}
