package com.example.demo.AboutEvent.Service;


import com.example.demo.AboutEvent.Models.*;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FactureService {

   Facture createFacture(Facture f);
   Facture updateFacture(Integer id , Facture f);
   void deleteFacture(Integer id);


    List<Facture> getAllFactures();


    Facture getFactureById(Integer id);

    
}
