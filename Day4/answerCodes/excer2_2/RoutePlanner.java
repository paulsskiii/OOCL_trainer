package Java34.day4.excer2_2;

import java.util.Arrays;
import java.util.List;

public class RoutePlanner {
    private List<String> validPorts = Arrays.asList("Manila", "Singapore", "Tokyo", "Busan", "Hong Kong");

    public void planRoute(String origin, String destination) throws PortNotRecognizedException {
        if (!validPorts.contains(origin)) {
            throw new PortNotRecognizedException("Origin port '" + origin + "' is not recognized.");
        }
        if (!validPorts.contains(destination)) {
            throw new PortNotRecognizedException("Destination port '" + destination + "' is not recognized.");
        }
        System.out.println("Route planned successfully from " + origin + " to " + destination + ".");
    }

    public static void main(String[] args) {
        RoutePlanner planner = new RoutePlanner();

        // Test Case 1: Valid route
        try {
            System.out.println("--- Test Case 1: Valid Route ---");
            planner.planRoute("Manila", "Singapore");
        } catch (PortNotRecognizedException e) {
            System.err.println("Route planning failed: " + e.getMessage());
        }

        // Test Case 2: Invalid destination
        try {
            System.out.println("\n--- Test Case 2: Invalid Destination ---");
            planner.planRoute("Tokyo", "New York");
        } catch (PortNotRecognizedException e) {
            System.err.println("Route planning failed: " + e.getMessage());
        }

        // Test Case 3: Invalid origin
        try {
            System.out.println("\n--- Test Case 3: Invalid Origin ---");
            planner.planRoute("London", "Busan");
        } catch (PortNotRecognizedException e) {
            System.err.println("Route planning failed: " + e.getMessage());
        }

        // Test Case 4: Both invalid
        try {
            System.out.println("\n--- Test Case 4: Both Invalid ---");
            planner.planRoute("London", "New York");
        } catch (PortNotRecognizedException e) {
            System.err.println("Route planning failed: " + e.getMessage());
        }
    }
}

