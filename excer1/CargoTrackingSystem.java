package OOCL_trainer.excer1;

public class CargoTrackingSystem {
    public static void main(String[] args) {
        // 1 & 2. Declare and Initialize Variables
        String cargoType = "Electronics";
        String trackingNumber = "TRK98765";
        String currentLocation = "At Sea";
        int estimatedDeliveryDays = 6;
        boolean isDelivered = false;
        double weightKg = 850.25;

        System.out.println("--- Cargo Details ---");
        System.out.println("Tracking Number: " + trackingNumber);
        System.out.println("Cargo Type: " + cargoType);
        System.out.println("Current Location: " + currentLocation);
        System.out.println("Estimated Delivery Days: " + estimatedDeliveryDays);
        System.out.println("Is Delivered: " + isDelivered);
        System.out.println("Weight: " + weightKg + " kg");
        System.out.println("---------------------\n");

        // 3. Check estimatedDeliveryDays
        if (estimatedDeliveryDays <= 3) {
            System.out.println("Express delivery! Expected in " + estimatedDeliveryDays + " days.");
        } else if (estimatedDeliveryDays >= 4 && estimatedDeliveryDays <= 7) {
            System.out.println("Standard delivery. Expected in " + estimatedDeliveryDays + " days.");
        } else {
            System.out.println("Long haul delivery. Expected in " + estimatedDeliveryDays + " days.");
        }

        System.out.println(); // New line for readability

        // 4. Print message based on cargoType using switch
        switch (cargoType) {
            case "Electronics":
                System.out.println("Handle with care, sensitive items.");
                break;
            case "Perishables":
                System.out.println("Refrigeration required. Time-sensitive.");
                break;
            case "Chemicals":
                System.out.println("Hazardous materials, follow safety protocols.");
                break;
            default:
                System.out.println("General cargo handling.");
        }

        System.out.println(); // New line for readability

        // 5. Simulate daily progress using a while loop
        System.out.println("Simulating daily progress:");
        int daysRemaining = estimatedDeliveryDays; // Use a copy for the loop
        while (daysRemaining > 0 && !isDelivered) {
            System.out.println("Day " + (estimatedDeliveryDays - daysRemaining + 1) + ": " + daysRemaining + " days left until delivery.");
            daysRemaining--;
            if (daysRemaining == 0) { // Simulate delivery on the last day
                isDelivered = true;
                System.out.println("Shipment delivered!");
            }
        }

        // Example for breaking early if already delivered
        boolean anotherIsDelivered = true;
        int anotherDays = 5;
        System.out.println("\nSimulating progress for already delivered item:");
        while (anotherDays > 0 && !anotherIsDelivered) {
            System.out.println("This won't print as isDelivered is true.");
            anotherDays--;
        }
        if (anotherIsDelivered) {
            System.out.println("Shipment already delivered, no progress simulation needed.");
        }
    }
}


