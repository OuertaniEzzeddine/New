package com.example.demo.AboutEvent.Service;

import com.example.demo.AboutEvent.Models.*;
import com.example.demo.AboutEvent.Repository.BudgetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetServiceImpl implements BudgetService{

    private final BudgetRepository budgetRepository;

    public BudgetServiceImpl(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }



    @Override
    public Budget getBudgetbyId(Integer id) {
        Optional<Budget> optionalBudget =budgetRepository.findById(id);
        return optionalBudget.orElse(null);
    }


    @Override
    public Budget createBudget(Budget B) {
        budgetRepository.save(B);
        return B;
    }


    @Override
    public Budget updateBudget(Integer id, Budget b) {
        if (budgetRepository.existsById(id)) {
            b.setId(id);
            return budgetRepository.save(b);
        }
        return null; // Or throw an exception

    }


    @Override
    public void deleteBudget(Integer id) {
        budgetRepository.deleteById(id);

    }
}
