/* LAB 8
Author: Neelanjan Dutta
Time: 9:45 am */

import java.util.Scanner;

// Abstract base class representing a superhero
abstract class Superhero {
    protected String name;
    protected String superpower;
    
    // Constructor to initialize superhero name and power
    public Superhero(String name, String superpower) {
        this.name = name;
        this.superpower = superpower;
    }
    
    // Method to display the superhero's identity
    public void displayIdentity() {
        System.out.println("I am " + name + " and my power is " + superpower + ".");
    }
    
    // Abstract method to be implemented by each superhero
    public abstract void usePower();
}

// Subclass for Mr. Incredible
class MrIncredible extends Superhero {
    public MrIncredible() {
        super("Mr. Incredible", "Super Strength");
    }
    
    @Override
    public void usePower() {
        System.out.println(name + " lifts a car with immense strength!");
    }
}

// Subclass for Elastigirl
class Elastigirl extends Superhero {
    public Elastigirl() {
        super("Elastigirl", "Body Stretching");
    }
    
    @Override
    public void usePower() {
        System.out.println(name + " stretches her arms to grab an object far away!");
    }
}

// Subclass for Violet
class Violet extends Superhero {
    public Violet() {
        super("Violet", "Invisibility & Force Fields");
    }
    
    @Override
    public void usePower() {
        System.out.println(name + " becomes invisible and generates a protective force field!");
    }
}

// Subclass for Dash
class Dash extends Superhero {
    public Dash() {
        super("Dash", "Super Speed");
    }
    
    @Override
    public void usePower() {
        System.out.println(name + " runs faster than the eye can see!");
    }
}

// Subclass for Jack-Jack
class JackJack extends Superhero {
    public JackJack() {
        super("Jack-Jack", "Multiple Powers");
    }
    
    @Override
    public void usePower() {
        System.out.println(name + " uses his laser eyes, teleports, and shape-shifts!");
    }
}

// Main class to get user input and display superhero details
public class TheIncredibles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ask the user for superhero name
        System.out.println("Enter the superhero name (Mr. Incredible, Elastigirl, Violet, Dash, Jack-Jack): ");
        String input = scanner.nextLine().trim();
        
        Superhero hero = null;
        
        // Match user input with the correct superhero
        switch (input.toLowerCase()) {
            case "mr. incredible":
                hero = new MrIncredible();
                break;
            case "elastigirl":
                hero = new Elastigirl();
                break;
            case "violet":
                hero = new Violet();
                break;
            case "dash":
                hero = new Dash();
                break;
            case "jack-jack":
                hero = new JackJack();
                break;
            default:
                System.out.println("Unknown superhero!");
                scanner.close();
                return;
        }
        
        // Display superhero details
        hero.displayIdentity();
        hero.usePower();
        
        scanner.close();
    }
}
