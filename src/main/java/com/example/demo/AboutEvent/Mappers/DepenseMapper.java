package com.example.demo.AboutEvent.Mappers;

import org.modelmapper.ModelMapper;
import com.example.demo.AboutEvent.DTO.DepenseDTO;
import com.example.demo.AboutEvent.Models.Depense;

public class DepenseMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static DepenseDTO convertToDto(Depense depense) {
        return modelMapper.map(depense, DepenseDTO.class);
    }

    public static Depense convertToEntity(DepenseDTO depenseDto) {
        return modelMapper.map(depenseDto, Depense.class);
    }
}
