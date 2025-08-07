package com.cargoship.cargoapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
* This class provides a REST endpoint for general application information.
* It is a separate controller to maintain a clear separation of concerns from the status check.
*/
@RestController
public class InfoController {

/**
* This method handles GET requests to the "/info" endpoint.
* It returns the current date and time.
*
* @return A formatted string with the current date and time.
*/
@GetMapping("/info")
public String getInfo() {
// Get the current date and time
LocalDateTime now = LocalDateTime.now();
// Define a formatter for the output string
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
// Format the date and time and return the message
return "Current date and time: " + now.format(formatter);
}
}


