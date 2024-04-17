package com.example.demo.AboutEvent.Service;


import com.example.demo.AboutEvent.Models.*;

public interface FactureService {
   Facture getFacturetbyId(Integer id);
   Facture createFacture(Facture f);
   Facture updateFacture(Integer id , Facture f);
    void deleteFacture(Integer id);

}
