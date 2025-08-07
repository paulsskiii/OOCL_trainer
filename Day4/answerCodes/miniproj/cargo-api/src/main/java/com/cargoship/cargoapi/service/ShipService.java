package com.cargoship.cargoapi.service;

import com.cargoship.cargoapi.exception.CargoNotFoundException;
import com.cargoship.cargoapi.exception.ShipNotFoundException;
import com.cargoship.cargoapi.exception.ShipOverloadException;
import com.cargoship.cargoapi.model.Cargo;
import com.cargoship.cargoapi.model.Ship;
import com.cargoship.cargoapi.repository.CargoRepository;
import com.cargoship.cargoapi.repository.ShipRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipService {

    private final ShipRepository shipRepository;
    private final CargoRepository cargoRepository; 
// Inject CargoRepository to update cargo status
public ShipService(ShipRepository shipRepository, CargoRepository cargoRepository) {
        this.shipRepository = shipRepository;
        this.cargoRepository = cargoRepository;
    }

    public List<Ship> getAllShips() {
        return shipRepository.findAll();
    }

    public Ship getShipById(Long id) {
        return shipRepository.findById(id)
                             .orElseThrow(() -> new ShipNotFoundException("Ship with ID " + id + " not found."));
    }

    public Ship addShip(Ship ship) {
        if (ship.getCapacityKg() <= 0) {
            throw new IllegalArgumentException("Ship capacity must be positive.");
        }
        if (ship.getCurrentLoadKg() < 0) {
             throw new IllegalArgumentException("Ship current load cannot be negative.");
        }
        if (ship.getCurrentLoadKg() > ship.getCapacityKg()) {
             throw new IllegalArgumentException("Ship current load cannot exceed capacity upon creation.");
        }
        return shipRepository.save(ship);
    }

    public Ship loadCargoOntoShip(Long shipId, Long cargoId) {
        Ship ship = getShipById(shipId); // Throws ShipNotFoundException
        Cargo cargo = cargoRepository.findById(cargoId)
                                     .orElseThrow(() -> new CargoNotFoundException("Cargo with ID " + cargoId + " not found."));

        double newLoad = ship.getCurrentLoadKg() + cargo.getWeightKg();
        if (newLoad > ship.getCapacityKg()) {
            throw new ShipOverloadException("Cannot load cargo " + cargoId + ". Ship " + shipId + " capacity would be exceeded. Remaining capacity: " + (ship.getCapacityKg() - ship.getCurrentLoadKg()) + "kg, Cargo weight: " + cargo.getWeightKg() + "kg.");
        }

        ship.setCurrentLoadKg(newLoad);
        cargo.setStatus("SHIPPED"); // Update cargo status
        shipRepository.save(ship);
        cargoRepository.save(cargo); // Save updated cargo
        return ship;
    }

    public Ship unloadCargoFromShip(Long shipId, Long cargoId) {
        Ship ship = getShipById(shipId); // Throws ShipNotFoundException
        Cargo cargo = cargoRepository.findById(cargoId)
                                     .orElseThrow(() -> new CargoNotFoundException("Cargo with ID " + cargoId + " not found."));

        // Basic validation: ensure cargo was actually loaded
        if (!"SHIPPED".equals(cargo.getStatus())) {
            throw new IllegalArgumentException("Cargo " + cargoId + " is not currently marked as SHIPPED.");
        }
        if (ship.getCurrentLoadKg() < cargo.getWeightKg()) {
            throw new IllegalArgumentException("Ship current load (" + ship.getCurrentLoadKg() + "kg) is less than cargo weight (" + cargo.getWeightKg() + "kg). Cannot unload.");
        }

        ship.setCurrentLoadKg(ship.getCurrentLoadKg() - cargo.getWeightKg());
        cargo.setStatus("DELIVERED"); // Update cargo status
        shipRepository.save(ship);
        cargoRepository.save(cargo); // Save updated cargo
        return ship;
    }
}

