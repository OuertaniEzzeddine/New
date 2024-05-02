package com.example.demo.AboutEvent.Mappers;


import org.modelmapper.ModelMapper;

import com.example.demo.AboutEvent.DTO.BudgetDTO;
import com.example.demo.AboutEvent.Models.Budget;


public class BudgetMapper {
        private static final ModelMapper modelMapper = new ModelMapper();
    
    public static BudgetDTO convertToDto(Budget budget){
        return modelMapper.map(budget, BudgetDTO.class);
    }
    public static Budget convertToEntity(BudgetDTO budgetdto) {
        return modelMapper.map(budgetdto, Budget.class);
    }

}
