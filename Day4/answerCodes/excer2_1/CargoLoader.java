package Java34.day4.excer2_1;

public class CargoLoader {

    public void loadCargo(double currentWeight, double cargoWeight, double shipCapacity) throws ShipOverloadException, IllegalArgumentException {
        if (cargoWeight <= 0) {
            throw new IllegalArgumentException("Cargo weight must be positive and non-zero.");
        }
        if (currentWeight < 0 || shipCapacity <= 0) {
            throw new IllegalArgumentException("Current weight and ship capacity must be non-negative and positive respectively.");
        }

        double newTotalWeight = currentWeight + cargoWeight;
        if (newTotalWeight > shipCapacity) {
            throw new ShipOverloadException("Cannot load cargo. Ship capacity (" + shipCapacity + "kg) would be exceeded. Current load: " + currentWeight + "kg, Cargo to add: " + cargoWeight + "kg. New total: " + newTotalWeight + "kg.");
        }
        System.out.println("Cargo successfully loaded. New total weight: " + newTotalWeight + "kg.");
    }

    public static void main(String[] args) {
        CargoLoader loader = new CargoLoader();

        // Test Case 1: Valid load
        try {
            System.out.println("--- Test Case 1: Valid Load ---");
            loader.loadCargo(1000.0, 500.0, 2000.0);
        } catch (ShipOverloadException | IllegalArgumentException e) {
            System.err.println("Error loading cargo: " + e.getMessage());
        }

        // Test Case 2: Negative cargo weight
        try {
            System.out.println("\n--- Test Case 2: Negative Cargo Weight ---");
            loader.loadCargo(1000.0, -100.0, 2000.0);
        } catch (ShipOverloadException | IllegalArgumentException e) {
            System.err.println("Error loading cargo: " + e.getMessage());
        }

        // Test Case 3: Overload
        try {
            System.out.println("\n--- Test Case 3: Overload ---");
            loader.loadCargo(1800.0, 500.0, 2000.0);
        } catch (ShipOverloadException | IllegalArgumentException e) {
            System.err.println("Error loading cargo: " + e.getMessage());
        }

        // Test Case 4: Zero cargo weight
        try {
            System.out.println("\n--- Test Case 4: Zero Cargo Weight ---");
            loader.loadCargo(1000.0, 0, 2000.0);
        } catch (ShipOverloadException | IllegalArgumentException e) {
            System.err.println("Error loading cargo: " + e.getMessage());
        }
    }
}

