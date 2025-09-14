import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        // Creating an ArrayList
        ArrayList<String> students = new ArrayList<>();
        
        // Adding elements
        students.add("Alice"); 
        students.add("Bob");
        students.add("Charlie");
        students.add(1, "David"); // Adding at a specific index
        System.out.println("Student List: " + students);

        // Removing an element
        students.remove("Bob");
        System.out.println("After removing Bob: " + students);

        // Retrieving an element
        System.out.println("Second Student: " + students.get(1));

        // Getting the size of the list
        System.out.println("List Size: " + students.size());

        // Updating an element
        students.set(1, "Eve");
        System.out.println("After updating index 1: " + students);
    }
}
