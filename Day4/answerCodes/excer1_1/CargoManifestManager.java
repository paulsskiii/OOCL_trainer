package Java34.day4.excer1_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CargoManifestManager {
    public static void main(String[] args) {
        List<CargoItem> manifest = new ArrayList<>();

        // Add 5 different cargo items
        manifest.add(new CargoItem(101, "Electronics", 150.5, "Singapore"));
        manifest.add(new CargoItem(102, "Perishables", 75.2, "Tokyo"));
        manifest.add(new CargoItem(103, "Machinery Parts", 500.0, "Manila"));
        manifest.add(new CargoItem(104, "Textiles", 200.0, "Busan"));
        manifest.add(new CargoItem(105, "Medical Supplies", 120.0, "Singapore"));

        System.out.println("Initial Cargo Manifest:");
        for (CargoItem item : manifest) {
            System.out.println(item);
        }

        // Remove a cargo item by its id
        long cargoIdToRemove = 103;
        Iterator<CargoItem> iterator = manifest.iterator();
        while (iterator.hasNext()) {
            CargoItem item = iterator.next();
            if (item.getId() == cargoIdToRemove) {
                iterator.remove();
                System.out.println("\nRemoved CargoItem with ID: " + cargoIdToRemove);
                break;
            }
        }

        System.out.println("\nCargo Manifest after removal:");
        if (manifest.isEmpty()) {
            System.out.println("Manifest is empty.");
        } else {
            for (CargoItem item : manifest) {
                System.out.println(item);
            }
        }
    }
}

