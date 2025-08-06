package OOCL_trainer.excer2;

import java.util.ArrayList;
import java.util.List;

public class TestVessels {
    public static void main(String[] args) {
        // Create instances of different ship types
        Ship genericShip = new Ship("The Wanderer", "Alice Smith", 15.0, 75);
        Tanker oilTanker = new Tanker("Ocean Giant", "Bob Johnson", 12.5, 90, "Crude Oil");
        ContainerShip maerskTripleE = new ContainerShip("Maersk Mc-Kinney Møller", "Charlie Brown", 20.0, 80, 18000);

        // Test encapsulation (invalid fuel level)
        System.out.println("--- Testing Encapsulation ---");
        genericShip.setFuelLevelPercentage(110); // Should print error
        System.out.println("Generic Ship Fuel: " + genericShip.getFuelLevelPercentage() + "%");
        genericShip.setFuelLevelPercentage(50);
        System.out.println("Generic Ship Fuel (updated): " + genericShip.getFuelLevelPercentage() + "%\n");


        // Polymorphism: Store different ship types in a list of the base type
        List<Ship> fleet = new ArrayList<>();
        fleet.add(genericShip);
        fleet.add(oilTanker);
        fleet.add(maerskTripleE);

        System.out.println("--- Displaying Fleet Information (Polymorphism) ---");
        for (Ship ship : fleet) {
            ship.displayShipInfo(); // Polymorphic method call
            System.out.println("----------------------------------");
        }
    }
}


