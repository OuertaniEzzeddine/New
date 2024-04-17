package com.example.demo.AboutEvent.Service;

import com.example.demo.AboutEvent.Models.*;


public interface RevenuService {
    Revenu getRevenutbyId(Integer id);
    Revenu createRevenu(Revenu R);
    Revenu updateRevenu(Integer id , Revenu r);
    void deleteRevenu(Integer id);
}
