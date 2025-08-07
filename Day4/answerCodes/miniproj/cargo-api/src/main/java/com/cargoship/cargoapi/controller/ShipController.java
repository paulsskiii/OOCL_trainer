package com.cargoship.cargoapi.controller;

import com.cargoship.cargoapi.model.Ship;
import com.cargoship.cargoapi.service.ShipService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ships")
public class ShipController {

    private final ShipService shipService;

    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping
    public List<Ship> getAllShips() {
        return shipService.getAllShips();
    }

    @GetMapping("/{id}")
    public Ship getShipById(@PathVariable Long id) {
        return shipService.getShipById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ship addShip(@RequestBody Ship ship) {
        return shipService.addShip(ship);
    }

    @PostMapping("/{shipId}/load/{cargoId}")
    public Ship loadCargoOntoShip(@PathVariable Long shipId, @PathVariable Long cargoId) {
        return shipService.loadCargoOntoShip(shipId, cargoId);
    }

    @PostMapping("/{shipId}/unload/{cargoId}")
    public Ship unloadCargoFromShip(@PathVariable Long shipId, @PathVariable Long cargoId) {
        return shipService.unloadCargoFromShip(shipId, cargoId);
    }
}
