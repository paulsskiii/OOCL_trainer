package com.cargoship.cargoapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* This class acts as a REST controller for handling status-related requests.
* The @RestController annotation is a convenience annotation that combines
* @Controller and @ResponseBody. This means that for every method,
* the return value is automatically converted to the response body of the HTTP response.
*/
@RestController
public class StatusController {

/**
* This method handles GET requests to the "/status" endpoint.
* The @GetMapping annotation maps HTTP GET requests onto this specific handler method.
* When a user accesses "http://localhost:8080/status", this method will be executed.
*
* @return A simple string indicating that the API is running.
*/
@GetMapping("/status")
public String getStatus() {
return "Cargo API is running successfully!";
}
}

