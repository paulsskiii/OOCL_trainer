package com.cargoship.cargoapi.repository;

import com.cargoship.cargoapi.model.Ship;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ShipRepository {
    private final List<Ship> shipDb = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong();

    public ShipRepository() {
        // Seed initial data
        shipDb.add(new Ship(idCounter.incrementAndGet(), "Sea Serpent", 10000.0, 0.0, "Manila"));
        shipDb.add(new Ship(idCounter.incrementAndGet(), "Ocean Drifter", 15000.0, 0.0, "Singapore"));
        shipDb.add(new Ship(idCounter.incrementAndGet(), "Star Gazer", 8000.0, 0.0, "Tokyo"));
    }

    public List<Ship> findAll() {
        return new ArrayList<>(shipDb);
    }

    public Optional<Ship> findById(Long id) {
        return shipDb.stream()
                     .filter(ship -> ship.getId().equals(id))
                     .findFirst();
    }

    public Ship save(Ship ship) {
        if (ship.getId() == null) {
            ship.setId(idCounter.incrementAndGet());
            shipDb.add(ship);
        } else {
            // Update existing ship
            findById(ship.getId()).ifPresent(existingShip -> {
                existingShip.setName(ship.getName());
                existingShip.setCapacityKg(ship.getCapacityKg());
                existingShip.setCurrentLoadKg(ship.getCurrentLoadKg());
                existingShip.setCurrentPort(ship.getCurrentPort());
            });
        }
        return ship;
    }
}

