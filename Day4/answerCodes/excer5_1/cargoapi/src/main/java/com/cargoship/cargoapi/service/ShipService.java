package com.cargoship.cargoapi.service;

import com.cargoship.cargoapi.model.Ship;
import com.cargoship.cargoapi.repository.ShipRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
* This service class handles the business logic related to ships.
* It is annotated with @Service to be automatically detected by Spring's component scanning.
* It injects the ShipRepository to perform data access operations.
*/
@Service
public class ShipService {

private final ShipRepository shipRepository;

/**
* Constructor for dependency injection of the ShipRepository.
* Spring automatically provides an instance of ShipRepository here.
* @param shipRepository The repository to be injected.
*/
public ShipService(ShipRepository shipRepository) {
this.shipRepository = shipRepository;
}

/**
* Retrieves a list of all ships from the repository.
* @return a List of all Ship objects.
*/
public List<Ship> getAllShips() {
return shipRepository.findAllShips();
}

/**
* Retrieves the details of a single ship by its ID.
* @param id The ID of the ship.
* @return an Optional containing the Ship if found, or an empty Optional otherwise.
*/
public Optional<Ship> getShipDetails(Long id) {
return shipRepository.findShipById(id);
}
}
