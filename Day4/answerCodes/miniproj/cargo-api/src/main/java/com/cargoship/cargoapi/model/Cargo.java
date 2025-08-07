package com.cargoship.cargoapi.model;

// Optional: Using Lombok for boilerplate, if you added it to pom.xml
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor // Generates no-arg constructor
@AllArgsConstructor // Generates constructor with all fields
public class Cargo {
    private Long id;
    private String name;
    private double weightKg;
    private String destinationPort;
    private String status; // e.g., "PENDING", "SHIPPED", "DELIVERED"
}
