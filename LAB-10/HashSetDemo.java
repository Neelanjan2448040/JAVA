import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        // Creating a HashSet
        HashSet<String> courses = new HashSet<>();

        // Adding elements
        courses.add("Math");
        courses.add("Physics");
        courses.add("Computer Science");
        courses.add("Math"); // Duplicate won't be added
        System.out.println("Courses Offered: " + courses);

        // Removing an element
        courses.remove("Physics");
        System.out.println("After removing Physics: " + courses);

        // Checking if an element exists
        System.out.println("Contains Math? " + courses.contains("Math"));

        // Getting the size of the set
        System.out.println("Total Courses: " + courses.size());

        // Clearing the HashSet
        courses.clear();
        System.out.println("After clearing HashSet: " + courses);
    }
}
