package Java34.day4.excer3_1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HighValueCargoFilter {
    public static void main(String[] args) {
        List<CargoItem> allCargo = Arrays.asList(
            new CargoItem(201, "Gold Bars", 100.0, 500000.0),
            new CargoItem(202, "Luxury Cars", 5000.0, 150000.0),
            new CargoItem(203, "General Goods", 2000.0, 8000.0),
            new CargoItem(204, "Art Collection", 50.0, 25000.0),
            new CargoItem(205, "Building Materials", 10000.0, 5000.0),
            new CargoItem(206, "Rare Manuscripts", 10.0, 12000.0)
        );

        double threshold = 10000.0; // $10,000

        List<CargoItem> highValueCargo = allCargo.stream()
                                                .filter(item -> item.getValue() > threshold)
                                                .collect(Collectors.toList());

        System.out.println("High-Value Cargo Items (Value > $" + String.format("%.2f", threshold) + "):");
        if (highValueCargo.isEmpty()) {
            System.out.println("No high-value cargo found.");
        } else {
            highValueCargo.forEach(System.out::println);
        }
    }
}

