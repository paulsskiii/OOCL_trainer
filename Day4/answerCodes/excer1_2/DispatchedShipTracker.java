package Java34.day4.excer1_2;

import java.util.HashSet;
import java.util.Set;

public class DispatchedShipTracker {
    public static void main(String[] args) {
        Set<String> dispatchedShips = new HashSet<>();

        dispatchedShips.add("Sea Serpent");
        dispatchedShips.add("Ocean Drifter");
        dispatchedShips.add("Star Gazer");
        dispatchedShips.add("Sea Serpent"); // Duplicate, will not be added

        System.out.println("Unique Dispatched Ships:");
        for (String shipName : dispatchedShips) {
            System.out.println(shipName);
        }

        String checkShip1 = "Ocean Drifter";
        System.out.println("\nIs " + checkShip1 + " dispatched? " + dispatchedShips.contains(checkShip1));

        String checkShip2 = "Titanic";
        System.out.println("Is " + checkShip2 + " dispatched? " + dispatchedShips.contains(checkShip2));
    }
}

