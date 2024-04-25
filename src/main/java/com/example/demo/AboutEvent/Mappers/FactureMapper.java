package com.example.demo.AboutEvent.Mappers;
import org.modelmapper.ModelMapper;

import com.example.demo.AboutEvent.Models.Facture;
import com.example.demo.AboutEvent.DTO.FactureDTO;


public class FactureMapper {

    private static final ModelMapper modelMapper = new ModelMapper();
    
    public static FactureDTO convertToDto(Facture facture){
        return modelMapper.map(facture, FactureDTO.class);
    }
    public static Facture convertToEntity(FactureDTO facturedto) {
        return modelMapper.map(facturedto, Facture.class);
    }

}
