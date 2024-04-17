package com.example.demo.AboutEvent.Service;

import com.example.demo.AboutEvent.Models.*;

public interface DepenseService {

    Depense getDepensetbyId(Integer id);
    Depense createDepense(Depense B);
    Depense updateDepense(Integer id ,Depense b);
    void deleteDepense(Integer id);

}
