package com.example.demo;

import com.example.demo.AboutEvent.Models.Budget;
import com.example.demo.AboutEvent.Repository.BudgetRepository;
import com.example.demo.AboutEvent.Service.BudgetServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BudgetServiceImplTest {

    @Mock
    private BudgetRepository budgetRepository;

    @InjectMocks
    private BudgetServiceImpl budgetService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetBudgetById() {
        Budget budget = new Budget();
        budget.setId(1);
        when(budgetRepository.findById(1)).thenReturn(Optional.of(budget));

        Budget result = budgetService.getBudgetbyId(1);

        assertEquals(budget, result);
    }

    @Test
    public void testCreateBudget() {
        Budget budget = new Budget();
        budget.setId(1);

        Budget result = budgetService.createBudget(budget);

        assertEquals(budget, result);
        verify(budgetRepository, times(1)).save(budget);
    }

    @Test
    public void testUpdateBudget() {
        Budget budget = new Budget();
        budget.setId(1);

        when(budgetRepository.existsById(1)).thenReturn(true);
        when(budgetRepository.save(budget)).thenReturn(budget);

        Budget result = budgetService.updateBudget(1, budget);

        assertEquals(budget, result);
        verify(budgetRepository, times(1)).save(budget);
    }

    @Test
    public void testDeleteBudget() {
        budgetService.deleteBudget(1);

        verify(budgetRepository, times(1)).deleteById(1);
    }
}

