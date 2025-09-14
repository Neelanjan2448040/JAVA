import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

public class CollectionDemo {
    public static void main(String[] args) {
        // Demonstrating ArrayList
        ArrayList<String> students = new ArrayList<>();
        students.add("Alice"); // add()
        students.add("Bob");
        students.add("Charlie");
        students.add(1, "David"); // add(index, element)
        System.out.println("Student List: " + students);
        
        students.remove("Bob"); // remove(Object)
        System.out.println("After removing Bob: " + students);
        
        System.out.println("Second Student: " + students.get(1)); // get(index)
        
        System.out.println("List Size: " + students.size()); // size()
        
        // Demonstrating HashSet
        HashSet<String> courses = new HashSet<>();
        courses.add("Math"); // add()
        courses.add("Physics");
        courses.add("Computer Science");
        courses.add("Math"); // Duplicate, won't be added
        System.out.println("Courses Offered: " + courses);
        
        courses.remove("Physics"); // remove()
        System.out.println("After removing Physics: " + courses);
        
        System.out.println("Contains Math? " + courses.contains("Math")); // contains()
        
        System.out.println("Total Courses: " + courses.size()); // size()
        
        // Demonstrating HashMap
        HashMap<String, String> grades = new HashMap<>();
        grades.put("Alice", "A"); // put()
        grades.put("Bob", "B");
        grades.put("Charlie", "A");
        System.out.println("Student Grades: " + grades);
        
        grades.put("Alice", "A+"); // Overwrites previous value
        System.out.println("Updated Grades: " + grades);
        
        System.out.println("Bob's Grade: " + grades.get("Bob")); // get(key)
        
        grades.remove("Charlie"); // remove(key)
        System.out.println("After removing Charlie: " + grades);
        
        System.out.println("Contains Alice? " + grades.containsKey("Alice")); // containsKey()
    }
}
