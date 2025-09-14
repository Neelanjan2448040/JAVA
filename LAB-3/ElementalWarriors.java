/* Lab 3
Name: Neelanjan Dutta
Registration Number:2448040 */


import java.util.Scanner;

// Character class representing an anime character
class Character {
    private String name;
    private int age;
    private String ability;
    private String title; // Optional field

    // Constructor for a character without a title
    public Character(String name, int age, String ability) {
        this.name = name;
        this.age = age;
        this.ability = ability;
        this.title = "None"; // Default value if no title is provided
    }

    // Constructor for a character with a title
    public Character(String name, int age, String ability, String title) {
        this.name = name;
        this.age = age;
        this.ability = ability;
        this.title = title;
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    // Method to update the ability of a character
    public void updateAbility(String newAbility) {
        this.ability = newAbility;
        System.out.println("Ability updated successfully!");
    }

    // Method to display character details
    public void displayDetails(boolean detailed) {
        System.out.println("\nCharacter Details:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ability: " + ability);
        if (detailed) {
            System.out.println("Title: " + title);
        }
    }
}

// Main class to handle user interactions
public class ElementalWarriors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many characters would you like to create? ");
        int numCharacters = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Character[] characters = new Character[numCharacters];

        for (int i = 0; i < numCharacters; i++) {
            System.out.println("\nCreate character " + (i + 1) + ":");
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            System.out.print("Enter ability: ");
            String ability = scanner.nextLine();

            System.out.print("Does the character have a title? (yes/no): ");
            String hasTitle = scanner.nextLine();

            if (hasTitle.equalsIgnoreCase("yes")) {
                System.out.print("Enter title: ");
                String title = scanner.nextLine();
                characters[i] = new Character(name, age, ability, title);
            } else {
                characters[i] = new Character(name, age, ability);
            }
        }

        // Choosing display format
        System.out.print("\nWould you like a detailed view of all characters? (yes/no): ");
        boolean detailedView = scanner.nextLine().equalsIgnoreCase("yes");

        // Displaying all characters
        for (Character character : characters) {
            character.displayDetails(detailedView);
        }

        // Updating ability
        for (Character character : characters) {
            System.out.print("\nWould you like to update the ability of " + character.getName() + "? (yes/no): ");
            String updateChoice = scanner.nextLine();
            if (updateChoice.equalsIgnoreCase("yes")) {
                System.out.print("Enter new ability: ");
                String newAbility = scanner.nextLine();
                character.updateAbility(newAbility);
                character.displayDetails(detailedView);
            }
        }

        // Closing the scanner
        scanner.close();
    }
}