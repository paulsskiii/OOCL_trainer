package Java34.day4.excer3_3;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet; // For sorted unique elements
import java.util.stream.Collectors;

public class UniquePortExtractor {
    public static void main(String[] args) {
        List<String> cargoRoutes = Arrays.asList(
            "Manila -> Singapore",
            "Singapore -> Tokyo",
            "Manila -> Busan",
            "Busan -> Singapore",
            "Tokyo -> Hong Kong",
            "Manila -> Tokyo" // Duplicate port combinations, but new origin/destination ports
        );

        // Extract all unique port names
        Set<String> uniquePorts = cargoRoutes.stream()
                                            .flatMap(route -> Arrays.stream(route.split(" -> "))) // Split and flatten to a stream of port names
                                            .map(String::trim) // Trim whitespace
                                            .collect(Collectors.toCollection(TreeSet::new)); // Collect into a TreeSet for unique and sorted

        System.out.println("Unique Port Names (Alphabetical Order):");
        uniquePorts.forEach(System.out::println);
    }
}

