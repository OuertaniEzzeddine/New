package com.example.demo.AboutEvent.Service;

import com.example.demo.AboutEvent.Models.*;

public interface BudgetService {

    Budget getBudgetbyId(Integer id);
    Budget createBudget(Budget B);
    Budget updateBudget(Integer id ,Budget b);
    void deleteBudget(Integer id);

}
