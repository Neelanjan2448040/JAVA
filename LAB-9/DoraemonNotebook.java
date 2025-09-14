import java.io.*;
import java.util.*;

public class DoraemonNotebook {
    private static final String FILE_NAME = "gadgets.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            // Display menu options
            System.out.println("\nMenu:");
            System.out.println("1. Add a new gadget");
            System.out.println("2. View all gadgets");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                addGadget(scanner);
            } else if (choice == 2) {
                viewGadgets();
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }

    // Method to add a new gadget
    private static void addGadget(Scanner scanner) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            System.out.print("Enter gadget name: ");
            String name = scanner.nextLine();
            System.out.print("Enter gadget description: ");
            String description = scanner.nextLine();
            
            writer.write(name + " - " + description);
            writer.newLine();
            System.out.println("Gadget added!");
        } catch (IOException e) {
            System.out.println("Error saving gadget.");
        }
    }

    // Method to view all gadgets
    private static void viewGadgets() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\nStored Gadgets:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("No gadgets found.");
        }
    }
}

