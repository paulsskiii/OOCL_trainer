package com.cargoship.cargoapi.repository;

import com.cargoship.cargoapi.model.Cargo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CargoRepository {
    private final List<Cargo> cargoDb = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong();

    public CargoRepository() {
// Seed initial data
        cargoDb.add(new Cargo(idCounter.incrementAndGet(), "Electronics Crate", 500.0, "Singapore", "PENDING"));
        cargoDb.add(new Cargo(idCounter.incrementAndGet(), "Fresh Produce", 200.0, "Tokyo", "PENDING"));
        cargoDb.add(new Cargo(idCounter.incrementAndGet(), "Machinery Parts", 1500.0, "Manila", "PENDING"));
        cargoDb.add(new Cargo(idCounter.incrementAndGet(), "Textile Rolls", 300.0, "Singapore", "PENDING"));
        cargoDb.add(new Cargo(idCounter.incrementAndGet(), "Raw Materials", 1000.0, "Busan", "PENDING"));
    }

    public List<Cargo> findAll() {
        return new ArrayList<>(cargoDb);
    }

    public Optional<Cargo> findById(Long id) {
        return cargoDb.stream()
                      .filter(cargo -> cargo.getId().equals(id))
                      .findFirst();
    }

    public Cargo save(Cargo cargo) {
        if (cargo.getId() == null) {
            cargo.setId(idCounter.incrementAndGet());
            cargoDb.add(cargo);
        } else {
            // Update existing cargo
            findById(cargo.getId()).ifPresent(existingCargo -> {
                existingCargo.setName(cargo.getName());
                existingCargo.setWeightKg(cargo.getWeightKg());
                existingCargo.setDestinationPort(cargo.getDestinationPort());
                existingCargo.setStatus(cargo.getStatus());
            });
        }
        return cargo;
    }

    public void deleteById(Long id) {
        cargoDb.removeIf(cargo -> cargo.getId().equals(id));
    }
}

