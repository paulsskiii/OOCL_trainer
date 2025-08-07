package com.cargoship.cargoapi.model;

/**
* A simple Plain Old Java Object (POJO) representing a Ship.
* This class acts as a model or entity for our application.
*/
public class Ship {
    private Long id;
    private String name;
    private int capacity; // in tons
    private String currentPort;
    
    // Default constructor
    public Ship() {
    }
    
    // Constructor with all fields
    public Ship(Long id, String name, int capacity, String currentPort) {
    this.id = id;
    this.name = name;
    this.capacity = capacity;
    this.currentPort = currentPort;
    }
    
    // Getters and Setters
    public Long getId() {
    return id;
    }
    
    public void setId(Long id) {
    this.id = id;
    }
    
    public String getName() {
    return name;
    }
    
    public void setName(String name) {
    this.name = name;
    }
    
    public int getCapacity() {
    return capacity;
    }
    
    public void setCapacity(int capacity) {
    this.capacity = capacity;
    }
    
    public String getCurrentPort() {
    return currentPort;
    }
    
    public void setCurrentPort(String currentPort) {
    this.currentPort = currentPort;
    }
    
    @Override
    public String toString() {
    return "Ship{" +
    "id=" + id +
    ", name='" + name + '\'' +
    ", capacity=" + capacity +
    ", currentPort='" + currentPort + '\'' +
    '}';
    }
    }
    
