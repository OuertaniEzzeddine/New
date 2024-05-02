package com.example.demo.AboutEvent.Service;

import com.example.demo.AboutEvent.Models.*;
import com.example.demo.AboutEvent.Repository.BudgetRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class BudgetServiceImpl implements BudgetService{
    private static final Logger logger = LogManager.getLogger(BudgetServiceImpl.class);

    private final BudgetRepository budgetRepository;

    public BudgetServiceImpl(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }



    @Override
    public Budget getBudgetbyId(Integer id) {
        logger.info("Getting budget by id: {}", id);
        Optional<Budget> optionalBudget =budgetRepository.findById(id);
        Budget bg = optionalBudget.orElse(null);
        if (bg == null) {
            logger.warn("Budget with id {} not found", id);
        }
        return bg;
    }


    @Override
    public Budget createBudget(Budget B) {
        logger.info("Creating budget: {}", B);
        budgetRepository.save(B);
        return B;
    }


    @Override
    public Budget updateBudget(Integer id, Budget b) {
        logger.info("Updating budget with id {}: {}", id, b);
        if (budgetRepository.existsById(id)) {
            b.setId(id);
            return budgetRepository.save(b);
        }
        else {
            logger.warn("Budget with id {} not found for update", id);
            return null;
        }
    }


    @Override
    public void deleteBudget(Integer id) {
        logger.info("Deleting budget with id: {}", id);
        budgetRepository.deleteById(id);

    }
}
