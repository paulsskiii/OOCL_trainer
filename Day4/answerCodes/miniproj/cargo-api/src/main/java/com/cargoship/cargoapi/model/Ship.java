package com.cargoship.cargoapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ship {
    private Long id;
    private String name;
    private double capacityKg;
    private double currentLoadKg;
    private String currentPort;
}




