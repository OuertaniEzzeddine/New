package com.example.demo.AboutEvent.Service;

import com.example.demo.AboutEvent.Models.*;
import com.example.demo.AboutEvent.Repository.BudgetRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BudgetServiceImpl implements BudgetService {

    private final BudgetRepository budgetRepository;

    public BudgetServiceImpl(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    @Override
    public Budget getBudgetbyId(Integer id) {
        Optional<Budget> optionalBudget = budgetRepository.findById(id);
        return optionalBudget.orElse(null);
    }

    @Override
    public Budget createBudget(Budget B) {
        if (B == null) {
            throw new IllegalArgumentException("Budget cannot be null");
        }
        return budgetRepository.save(B);
    }

    @Override
    public Budget updateBudget(Integer id, Budget b) {
        if (budgetRepository.existsById(id)) {
            b.setId(id);
            return budgetRepository.save(b);
        }
        else {
            return null;
        }
    }

    @Override
    public void deleteBudget(Integer id) {
        budgetRepository.deleteById(id);
    }
}