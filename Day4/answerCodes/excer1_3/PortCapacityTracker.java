package Java34.day4.excer1_3;

import java.util.HashMap;
import java.util.Map;

public class PortCapacityTracker {
    public static void main(String[] args) {
        Map<String, Port> ports = new HashMap<>();

        ports.put("Manila", new Port("Manila", 5, 3));
        ports.put("Singapore", new Port("Singapore", 7, 6));
        ports.put("Tokyo", new Port("Tokyo", 4, 4)); // Tokyo is at full capacity

        System.out.println("Initial Port Capacities:");
        ports.values().forEach(System.out::println);

        System.out.println("\nSimulating ship arrivals:");

        // Ship arrives at Manila
        Port manila = ports.get("Manila");
        if (manila != null && manila.addShip()) {
            System.out.println("Ship arrived at " + manila.getName() + ". Current occupancy: " + manila.getCurrentOccupancy());
        } else if (manila != null) {
            System.out.println("Error: " + manila.getName() + " is at full capacity.");
        }

        // Ship arrives at Singapore
        Port singapore = ports.get("Singapore");
        if (singapore != null && singapore.addShip()) {
            System.out.println("Ship arrived at " + singapore.getName() + ". Current occupancy: " + singapore.getCurrentOccupancy());
        } else if (singapore != null) {
            System.out.println("Error: " + singapore.getName() + " is at full capacity.");
        }

        // Ship arrives at Tokyo (should fail)
        Port tokyo = ports.get("Tokyo");
        if (tokyo != null && tokyo.addShip()) {
            System.out.println("Ship arrived at " + tokyo.getName() + ". Current occupancy: " + tokyo.getCurrentOccupancy());
        } else if (tokyo != null) {
            System.out.println("Error: " + tokyo.getName() + " is at full capacity. Cannot add ship.");
        }

        System.out.println("\nFinal Port Capacities:");
        ports.values().forEach(System.out::println);
    }
}
