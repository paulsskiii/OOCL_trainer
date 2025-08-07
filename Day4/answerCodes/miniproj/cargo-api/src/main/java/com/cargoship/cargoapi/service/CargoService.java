package com.cargoship.cargoapi.service;

import com.cargoship.cargoapi.exception.CargoNotFoundException;
import com.cargoship.cargoapi.model.Cargo;
import com.cargoship.cargoapi.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CargoService {

    private final CargoRepository cargoRepository;
    public CargoService(CargoRepository cargoRepository) {
          this.cargoRepository = cargoRepository;
    }

    public List<Cargo> getAllCargo() {
        return cargoRepository.findAll();
    }

    public Cargo getCargoById(Long id) {
        return cargoRepository.findById(id)
                              .orElseThrow(() -> new CargoNotFoundException("Cargo with ID " + id + " not found."));
    }

    public Cargo addCargo(Cargo cargo) {
        if (cargo.getWeightKg() <= 0) {
            throw new IllegalArgumentException("Cargo weight must be positive.");
        }
        if (cargo.getStatus() == null || cargo.getStatus().isEmpty()) {
            cargo.setStatus("PENDING"); // Default status
        }
        return cargoRepository.save(cargo);
    }

    public Cargo updateCargoStatus(Long id, String newStatus) {
        Cargo cargo = getCargoById(id); // Throws CargoNotFoundException if not found
        cargo.setStatus(newStatus);
        return cargoRepository.save(cargo);
    }

    public void deleteCargo(Long id) {
        // Check if cargo exists before attempting to delete
        getCargoById(id);
        cargoRepository.deleteById(id);
    }

    public List<Cargo> findCargoByDestination(String destination) {
        return cargoRepository.findAll().stream()
                              .filter(cargo -> cargo.getDestinationPort().equalsIgnoreCase(destination))
                              .collect(Collectors.toList());
    }

    public double getTotalWeightByDestination(String destination) {
        return cargoRepository.findAll().stream()
                              .filter(cargo -> cargo.getDestinationPort().equalsIgnoreCase(destination))
                              .mapToDouble(Cargo::getWeightKg)
                              .sum();
    }
}

