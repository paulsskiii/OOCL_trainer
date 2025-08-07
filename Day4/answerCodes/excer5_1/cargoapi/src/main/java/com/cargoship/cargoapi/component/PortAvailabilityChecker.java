package Java34.day4.excer5_1.cargoapi.src.main.java.com.cargoship.cargoapi.component;

import org.springframework.stereotype.Component;

/**
* A Spring component to check the operational status of a port.
* The @Component annotation marks this class as a Spring-managed bean,
* making it available for dependency injection.
*/
@Component
public class PortAvailabilityChecker {

/**
* Simulates checking if a port is operational.
* In a real-world scenario, this might involve calling an external API or database.
*
* @param portName The name of the port to check.
* @return true if the port is operational, false otherwise.
*/
public boolean isPortOperational(String portName) {
// Simple logic for demonstration purposes
return !portName.equalsIgnoreCase("Damaged Port");
}
}

