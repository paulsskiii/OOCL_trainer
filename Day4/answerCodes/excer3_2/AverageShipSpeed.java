package Java34.day4.excer3_2;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class AverageShipSpeed {
    public static void main(String[] args) {
        List<Ship> ships = Arrays.asList(
            new Ship("Sea Serpent", 25.5),
            new Ship("Ocean Drifter", 22.0),
            new Ship("Star Gazer", 18.0),
            new Ship("Pacific Pearl", 30.0)
        );

        // Calculate average max speed
        OptionalDouble averageSpeed = ships.stream()
                                            .mapToDouble(Ship::getMaxSpeedKnot)
                                            .average();

        if (averageSpeed.isPresent()) {
            System.out.println("Average Maximum Ship Speed: " + String.format("%.2f", averageSpeed.getAsDouble()) + " knots");
        } else {
            System.out.println("No ships in the list to calculate average speed.");
        }

        // Test with an empty list
        List<Ship> emptyShips = Arrays.asList();
        OptionalDouble emptyAverage = emptyShips.stream()
                                                .mapToDouble(Ship::getMaxSpeedKnot)
                                                .average();
        System.out.println("Average speed for empty list: " + emptyAverage.orElse(0.0) + " knots");
    }
}