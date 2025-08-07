package com.cargoship.cargoapi.controller;

import com.cargoship.cargoapi.model.Cargo;
import com.cargoship.cargoapi.service.CargoService;
import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cargo")
public class CargoController {

    private final CargoService cargoService;

    public CargoController(CargoService cargoService) {
           this.cargoService = cargoService;
    }

    @GetMapping
    public List<Cargo> getAllCargo() {
        return cargoService.getAllCargo();
    }

    @GetMapping("/{id}")
    public Cargo getCargoById(@PathVariable Long id) {
        return cargoService.getCargoById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Returns 201 Created on success
    public Cargo addCargo(@RequestBody Cargo cargo) {
        return cargoService.addCargo(cargo);
    }

    @PutMapping("/{id}/status")
    public Cargo updateCargoStatus(@PathVariable Long id, @RequestBody String newStatus) {
        return cargoService.updateCargoStatus(id, newStatus);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Returns 204 No Content on successful deletion
    public void deleteCargo(@PathVariable Long id) {
        cargoService.deleteCargo(id);
    }

    @GetMapping("/destination/{destination}")
    public List<Cargo> getCargoByDestination(@PathVariable String destination) {
        return cargoService.findCargoByDestination(destination);
    }

    @GetMapping("/destination/{destination}/total-weight")
    public double getTotalWeightByDestination(@PathVariable String destination) {
        return cargoService.getTotalWeightByDestination(destination);
    }
}
