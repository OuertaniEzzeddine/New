package com.example.demo.AboutEvent.Mappers;

import org.modelmapper.ModelMapper;
import com.example.demo.AboutEvent.Models.Revenu;
import com.example.demo.AboutEvent.DTO.RevenuDTO;

public class RevenuMapper {

    private static final ModelMapper modelMapper = new ModelMapper();
    
    public static RevenuDTO convertToDto(Revenu revenu){
        return modelMapper.map(revenu, RevenuDTO.class);
    }
    
    public static Revenu convertToEntity(RevenuDTO revenuDtos) {
        return modelMapper.map(revenuDtos, Revenu.class);
    }
}
