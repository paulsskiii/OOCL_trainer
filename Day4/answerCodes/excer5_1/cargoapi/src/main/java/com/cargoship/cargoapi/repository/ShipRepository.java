package com.cargoship.cargoapi.repository;

import com.cargoship.cargoapi.model.Ship;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* This repository class provides data access for the Ship model.
* It is annotated with @Repository to indicate that it's a component responsible for data access.
* For this example, we are using a simple in-memory list to simulate a database.
*/
@Repository
public class ShipRepository {

// A dummy in-memory list of ships to act as a database
private final List<Ship> ships = new ArrayList<>();

public ShipRepository() {
// Initialize the dummy data
ships.add(new Ship(1L, "Oceanic Explorer", 5000, "Port of Rotterdam"));
ships.add(new Ship(2L, "Sea Voyager", 7500, "Port of Shanghai"));
ships.add(new Ship(3L, "Coastal Carrier", 2000, "Port of Singapore"));
}

/**
* Finds and returns a list of all ships.
* @return a List of all Ship objects.
*/
public List<Ship> findAllShips() {
return new ArrayList<>(ships); // Return a copy to prevent external modification
}

/**
* Finds a ship by its unique ID.
* @param id The ID of the ship to find.
* @return an Optional containing the Ship if found, or an empty Optional otherwise.
*/
public Optional<Ship> findShipById(Long id) {
return ships.stream()
.filter(ship -> ship.getId().equals(id))
.findFirst();
}
}

