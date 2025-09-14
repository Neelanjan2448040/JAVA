import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        // Creating a HashMap
        HashMap<String, String> grades = new HashMap<>();

        // Adding key-value pairs
        grades.put("Alice", "A");
        grades.put("Bob", "B");
        grades.put("Charlie", "A");
        System.out.println("Student Grades: " + grades);

        // Updating a value
        grades.put("Alice", "A+");
        System.out.println("Updated Grades: " + grades);

        // Retrieving a value
        System.out.println("Bob's Grade: " + grades.get("Bob"));

        // Removing a key-value pair
        grades.remove("Charlie");
        System.out.println("After removing Charlie: " + grades);

        // Checking if a key exists
        System.out.println("Contains Alice? " + grades.containsKey("Alice"));

        // Getting all keys
        System.out.println("All Keys: " + grades.keySet());
    }
}
