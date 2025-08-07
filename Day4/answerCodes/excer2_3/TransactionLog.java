package Java34.day4.excer2_3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionLog {
    private static final String LOG_FILE = "financial_transactions.log";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void recordTransaction(double amount, String description) {
        String logEntry = String.format("[%s] Amount: %.2f, Description: %s",
                                       LocalDateTime.now().format(FORMATTER), amount, description);
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            writer.println(logEntry);
            System.out.println("Transaction recorded successfully: " + description);
        } catch (IOException e) {
            System.err.println("Error recording transaction to log file: " + e.getMessage());
        } finally {
            System.out.println("Transaction logging attempt completed.");
        }
    }

    public static void main(String[] args) {
        TransactionLog logger = new TransactionLog();

        // Test Case 1: Successful transaction
        System.out.println("--- Test Case 1: Successful Transaction ---");
        logger.recordTransaction(1500.75, "Shipping fee for TRK123");

        // Test Case 2: Another successful transaction
        System.out.println("\n--- Test Case 2: Another Successful Transaction ---");
        logger.recordTransaction(-250.00, "Refund for cancelled cargo");

        // Test Case 3: Simulate an invalid file path (if your OS allows testing this way)
        // This often requires specific permissions or an actual non-existent/unwritable path.
        // For simple demonstration, you might need to modify `LOG_FILE` to an invalid one like "/nonexistent_dir/log.txt"
        // or a path you know is protected on your system.
        // For this example, let's just note how you would try to simulate it conceptually.
        // For a reliable test without system-specific setup, you might throw a mock IOException.
        System.out.println("\n--- Test Case 3: Simulated File Error ---");
        // To truly simulate an IO error without changing LOG_FILE, you'd need a more complex setup
        // like mocking FileWriter, but for basic exercise, just observe the catch block if an actual error occurs.
        // If the path is correct and writable, this will also succeed.
        logger.recordTransaction(50.00, "Small payment for port services");
    }
}
