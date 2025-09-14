import java.util.Scanner;

// John Wick class representing the main character
class JohnWick {
    private static final String NAME = "John Wick"; // Constant name (private, static, final)
    private static final String REPUTATION = "Baba Yaga"; // Reputation of John Wick (private, static, final)
    private String status; // Status of John Wick (private)

    // Public constructor to initialize John Wick's status
    public JohnWick(String status) {
        this.status = status;
    }

    // Public method for retrieving weapons
    public void retrieveWeapons() {
        System.out.println(NAME + " is retrieving his weapons.");
    }

    // Public method for checking into The Continental Hotel
    public void checkIntoContinental() {
        System.out.println(NAME + " is checking into The Continental.");
    }

    // Public method to display reputation
    public void showReputation() {
        System.out.println(NAME + " is known as " + REPUTATION);
    }
}

// The Continental Hotel class representing the hotel
class ContinentalHotel {
    private static final String NAME = "The Continental"; // Constant hotel name (private, static, final)
    private String location; // Hotel location (private)
    private Manager manager; // Manager as an inner class object
    private static final String RULES = "No killing on premises"; // Hotel rules (private, static, final)

    // Public constructor to initialize hotel details
    public ContinentalHotel(String location, String managerName) {
        this.location = location;
        this.manager = new Manager(managerName); // Creating an instance of the inner class
    }

    // Inner class representing the Manager of the hotel
    class Manager {
        private String name;

        public Manager(String name) {
            this.name = name;
        }

        public void showManager() {
            System.out.println("Manager: " + name);
        }
    }

    // Public method to enforce hotel rules
    public void enforceRules() {
        System.out.println("Enforcing rules: " + RULES);
    }

    // Public method to display hotel details
    public void showDetails() {
        System.out.println("Hotel: " + NAME + ", Location: " + location);
        manager.showManager(); // Display manager details
    }
}

// The High Table class representing the ruling organization
class HighTable {
    private static final String ORGANIZATION_NAME = "The High Table"; // Constant name (private, static, final)
    private Member[] members; // Array to store High Table members (private)
    private int memberCount; // Count of current members (private)

    // Public constructor to initialize the High Table with a specified size
    public HighTable(int size) {
        members = new Member[size];
        memberCount = 0;
    }

    // Inner class representing a High Table member
    class Member {
        private String name;
        private String role;

        public Member(String name, String role) {
            this.name = name;
            this.role = role;
        }

        public void showMember() {
            System.out.println(name + " - " + role);
        }
    }

    // Public method to add a member to the High Table
    public void addMember(String name, String role) {
        if (memberCount < members.length) {
            members[memberCount++] = new Member(name, role);
        } else {
            System.out.println("No more space to add members.");
        }
    }

    // Public method to issue a command from the High Table
    public void issueCommand(String command) {
        System.out.println(ORGANIZATION_NAME + " issues command: " + command);
    }

    // Public method to display all High Table members
    public void showMembers() {
        System.out.println("Members of " + ORGANIZATION_NAME + ":");
        for (int i = 0; i < memberCount; i++) {
            members[i].showMember();
        }
    }
}

// Main class to execute the program
public class JohnWickUniverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for John Wick's status
        System.out.print("Enter John Wick's status (Active/Retired): ");
        JohnWick john = new JohnWick(scanner.nextLine()); // Creating JohnWick object using constructor
        john.retrieveWeapons();
        john.checkIntoContinental();
        john.showReputation(); // Display John Wick's reputation

        // Taking input for The Continental Hotel details
        System.out.print("Enter location of The Continental: ");
        String location = scanner.nextLine();
        System.out.print("Enter Manager's name: ");
        String managerName = scanner.nextLine();
        ContinentalHotel continental = new ContinentalHotel(location, managerName); // Creating ContinentalHotel object using constructor
        continental.enforceRules();
        continental.showDetails();

        // Taking input for High Table members
        System.out.print("Enter number of High Table members: ");
        int numMembers = scanner.nextInt();
        scanner.nextLine();
        HighTable highTable = new HighTable(numMembers); // Creating HighTable object using constructor

        for (int i = 0; i < numMembers; i++) {
            System.out.print("Enter member name: ");
            String memberName = scanner.nextLine();
            System.out.print("Enter member role: ");
            String role = scanner.nextLine();
            highTable.addMember(memberName, role);
        }

        // Taking input for High Table command
        System.out.print("Enter command issued by The High Table: ");
        highTable.issueCommand(scanner.nextLine());
        highTable.showMembers();

        scanner.close();
    }
}
