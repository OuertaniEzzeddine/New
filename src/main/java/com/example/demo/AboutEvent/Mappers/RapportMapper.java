package com.example.demo.AboutEvent.Mappers;

import org.modelmapper.ModelMapper;
import com.example.demo.AboutEvent.DTO.RapportDTO;
import com.example.demo.AboutEvent.Models.Rapport;

public class RapportMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static RapportDTO convertToDto(Rapport rapport) {
        return modelMapper.map(rapport, RapportDTO.class);
    }

    public static Rapport convertToEntity(RapportDTO rapportDto) {
        return modelMapper.map(rapportDto, Rapport.class);
    }
}
