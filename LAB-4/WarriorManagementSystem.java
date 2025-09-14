import java.util.Scanner;

class Kingdom {
    private static final String kingdomName = "Mahishmati";
    private static String ruler = "Amarendra Baahubali";
    private static int totalWarriors = 0;

    static {
        initializeKingdom();
    }

    private static void initializeKingdom() {
        System.out.println("Initializing the kingdom of " + kingdomName);
    }

    public static void setRuler(String rulerName) {
        ruler = rulerName;
    }

    public static String getRuler() {
        return ruler;
    }

    public static void incrementWarriors() {
        totalWarriors++;
    }

    public static int getTotalWarriors() {
        return totalWarriors;
    }

    public static void displayStatus() {
        System.out.println("Kingdom: " + kingdomName);
        System.out.println("Ruler: " + ruler);
        System.out.println("Total Warriors: " + totalWarriors);
    }

    public static void displayFinalStatus() {
        System.out.println("Ruler: " + ruler);
        System.out.println("Final Total Number of Warriors: " + totalWarriors);
    }
}

class Warrior {
    private String name;
    private String rank;

    public Warrior(String name, String rank) {
        this.name = name;
        this.rank = rank;
        Kingdom.incrementWarriors();
    }

    public String getName() {
        return name;
    }

    public String getRank() {
        return rank;
    }

    public void displayWarriorDetails() {
        System.out.println("Warrior Name: " + name);
        System.out.println("Warrior Rank: " + rank);
    }

    public static void displayTotalWarriors() {
        System.out.println("Total Warriors in Mahishmati: " + Kingdom.getTotalWarriors());
    }
}

public class WarriorManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Set ruler's name if needed
        System.out.print("Enter the ruler's name (or press Enter to keep the default 'Amarendra Baahubali'): ");
        String rulerName = scanner.nextLine();
        if (!rulerName.isEmpty()) {
            Kingdom.setRuler(rulerName);
        }

        // Display the current status of the kingdom before creating any warriors
        Kingdom.displayStatus();

        // Create warriors based on user input
        System.out.print("How many warriors would you like to create? ");
        int numWarriors = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Warrior[] warriors = new Warrior[numWarriors];

        for (int i = 0; i < numWarriors; i++) {
            System.out.println("\nCreating warrior " + (i + 1) + ":");
            System.out.print("Enter warrior name: ");
            String name = scanner.nextLine();
            System.out.print("Enter warrior rank: ");
            String rank = scanner.nextLine();
            warriors[i] = new Warrior(name, rank);

            // Display warrior details immediately after creation
            warriors[i].displayWarriorDetails();
        }

        // Display the final status of the kingdom after creating warriors
        Kingdom.displayFinalStatus();

        scanner.close();
    }
}