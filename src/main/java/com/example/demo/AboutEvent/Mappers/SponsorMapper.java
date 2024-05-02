package com.example.demo.AboutEvent.Mappers;

import org.modelmapper.ModelMapper;
import com.example.demo.AboutEvent.DTO.SponsorDTO;
import com.example.demo.AboutEvent.Models.Sponsor;

public class SponsorMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static SponsorDTO convertToDto(Sponsor sponsor) {
        return modelMapper.map(sponsor, SponsorDTO.class);
    }

    public static Sponsor convertToEntity(SponsorDTO sponsorDto) {
        return modelMapper.map(sponsorDto, Sponsor.class);
    }
}
