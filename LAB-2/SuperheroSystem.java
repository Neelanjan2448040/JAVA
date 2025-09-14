import java.util.Scanner;

// Character class to manage superheroes and villains
class Character {
    String name;
    String alias;
    String[] abilities;
    String affiliation;
    boolean isHero;

    // Constructor to initialize character details
    public Character(String name, String alias, String[] abilities, String affiliation, boolean isHero) {
        this.name = name;
        this.alias = alias;
        this.abilities = abilities;
        this.affiliation = affiliation;
        this.isHero = isHero;
    }

    // Method to display character details
    public void displayCharacter() {
        System.out.println("Name: " + name);
        System.out.println("Alias: " + alias);
        System.out.println("Affiliation: " + affiliation);
        System.out.println("Type: " + (isHero ? "Hero" : "Villain"));
        System.out.print("Abilities: ");
        for (String ability : abilities) {
            System.out.print(ability.trim() + ", ");
        }
        System.out.println("\n----------------------------");
    }
}
  
// Mission class to manage missions
class Mission {
    String missionId;
    String description;
    String difficulty;
    String location;
    String status;
    Character[] charactersInvolved;

    // Constructor to initialize mission details
    public Mission(String missionId, String description, String difficulty, String location, String status, Character[] charactersInvolved) {
        this.missionId = missionId;
        this.description = description;
        this.difficulty = difficulty;
        this.location = location;
        this.status = status;
        this.charactersInvolved = charactersInvolved;
    }

    // Method to display mission details
    public void displayMission(boolean detailed) {
        System.out.println("Mission ID: " + missionId);
        System.out.println("Status: " + status);
        if (detailed) {
            System.out.println("Description: " + description);
            System.out.println("Difficulty: " + difficulty);
            System.out.println("Location: " + location);
            System.out.println("Characters Involved:");
            for (Character character : charactersInvolved) {
                character.displayCharacter();
            }
        }
        System.out.println("----------------------------");
    }

    // Method to update mission status
    public void updateStatus(String newStatus) {
        this.status = newStatus;
        System.out.println("Mission status updated to: " + newStatus);
    }
}

// Main class to test the system
public class SuperheroSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Collect multiple heroes/villains at the beginning
        System.out.println("Enter the number of characters:");
        int numCharacters = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Character[] characters = new Character[numCharacters];

        for (int i = 0; i < numCharacters; i++) {
            System.out.println("\nEnter details for character " + (i + 1) + ":");
           
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
           
            System.out.print("Enter Alias: ");
            String alias = scanner.nextLine();
           
            System.out.print("Enter Affiliation (e.g., Avengers, Guardians): ");
            String affiliation = scanner.nextLine();
           
            System.out.print("Is this a Hero? (true/false): ");
            boolean isHero = scanner.nextBoolean();
            scanner.nextLine(); // Consume newline
           
            System.out.print("Enter abilities (comma-separated): ");
            String abilitiesInput = scanner.nextLine();
            String[] abilities = abilitiesInput.split(",");

            characters[i] = new Character(name, alias, abilities, affiliation, isHero);
        }

        // Step 2: Collect mission details
        System.out.println("\nEnter Mission Details:");
       
        System.out.print("Mission ID: ");
        String missionId = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Difficulty (Low, Medium, High): ");
        String difficulty = scanner.nextLine();

        System.out.print("Location: ");
        String location = scanner.nextLine();

        System.out.print("Status (Pending, In-Progress, Completed): ");
        String status = scanner.nextLine();

        // Step 3: Assign characters to the mission
        Character[] missionCharacters;
        System.out.print("Include all characters in the mission? (yes/no): ");
        String includeAll = scanner.nextLine();

        if (includeAll.equalsIgnoreCase("yes")) {
            missionCharacters = characters; // Assign all characters
        } else {
            System.out.print("Enter number of characters involved in the mission: ");
            int numMissionCharacters = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            missionCharacters = new Character[numMissionCharacters];
            for (int i = 0; i < numMissionCharacters; i++) {
                System.out.print("Enter character index (1 to " + numCharacters + ") for mission: ");
                int charIndex = scanner.nextInt() - 1;
                scanner.nextLine(); // Consume newline
                missionCharacters[i] = characters[charIndex];
            }
        }

        Mission userMission = new Mission(missionId, description, difficulty, location, status, missionCharacters);

        // Step 4: Display details
        System.out.println("\n--- Character Details ---");
        for (Character character : characters) {
            character.displayCharacter();
        }

        System.out.println("\n--- Mission Details ---");
        userMission.displayMission(true); // Detailed view

        // Step 5: Update mission status
        System.out.print("\nEnter new mission status: ");
        String newStatus = scanner.nextLine();
        userMission.updateStatus(newStatus);

        scanner.close();
    }
}
