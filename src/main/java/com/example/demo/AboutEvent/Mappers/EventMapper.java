package com.example.demo.AboutEvent.Mappers;


import org.modelmapper.ModelMapper;

import com.example.demo.AboutEvent.Models.Event;
import com.example.demo.AboutEvent.DTO.EventDTO;
public class EventMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static EventDTO convertToDto(Event event){
        return modelMapper.map(event, EventDTO.class);
    }
    public static Event convertToEntity(EventDTO eventdto) {
        return modelMapper.map(eventdto, Event.class);
    }
}
