package com.example.demo.AboutEvent.DTO;

import java.util.List;

import lombok.Data;

@Data
public class RapportDTO {
    private String eventname;
    private String contenu;
    private List<DepenseDTO> depenses;
    private List<RevenuDTO> revenus;

}
