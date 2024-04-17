package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.AboutEvent.Models.Budget;

import static org.junit.jupiter.api.Assertions.*;

public class BudgetTest {

    private Budget budget;

    @BeforeEach
    public void setUp() {
        budget = new Budget();
        budget.setId(1);
        budget.setMontant(1000.0);
        budget.setDesciption("Test budget");
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals(1, budget.getId());
        assertEquals(1000.0, budget.getMontant());
        assertEquals("Test budget", budget.getDesciption());

        // Test setters
        budget.setId(2);
        budget.setMontant(2000.0);
        budget.setDesciption("Updated budget");

        assertEquals(2, budget.getId());
        assertEquals(2000.0, budget.getMontant());
        assertEquals("Updated budget", budget.getDesciption());
    }

    @Test
    public void testEqualsAndHashCode() {
        Budget budget1 = new Budget(1, 1000.0, "Test budget");
        Budget budget2 = new Budget(1, 1000.0, "Test budget");
        Budget budget3 = new Budget(2, 2000.0, "Updated budget");

        // Test equals method
        assertTrue(budget1.equals(budget2));
        assertFalse(budget1.equals(budget3));

        // Test hashCode method
        assertEquals(budget1.hashCode(), budget2.hashCode());
        assertNotEquals(budget1.hashCode(), budget3.hashCode());
    }
}
