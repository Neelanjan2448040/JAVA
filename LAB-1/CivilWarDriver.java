/*
Name: Neelanjan Dutta    Reg no: 2448040    

LAB 1

Create a class called Civil War, which has the names of 3 Avengers and 2 methods called duel, which takes in the names of 2 Avengers and returns the name of the Avenger who wins the duel, and a print function that prints the name of your favorite avenger

The logic for the duel:
Both the Avengers will give an integer value; the integer, if its prime or palindrome, then that Avenger wins, creates one object of the Civil War class in a driver class named Civil War Driver. Call both the methods and also have a default constructor in the class.


*/

import java.util.Random;
import java.util.Scanner;

class CivilWar {
    private String avenger1, avenger2, avenger3;

    // Default constructor
    public CivilWar() {
        avenger1 = "";
        avenger2 = "";
        avenger3 = "";
    }

    // Method to set Avenger names
    public void setAvengers(String avenger1, String avenger2, String avenger3) {
        this.avenger1 = avenger1;
        this.avenger2 = avenger2;
        this.avenger3 = avenger3;
    }

    // Method to check if a number is prime
    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // Method to check if a number is a palindrome
    private boolean isPalindrome(int num) {
        int original = num, reverse = 0;
        while (num > 0) {
            reverse = reverse * 10 + num % 10;
            num /= 10;
        }
        return original == reverse;
    }

    // Duel method to determine the winner
    public String duel(String avengerA, String avengerB, int scoreA, int scoreB) {
        boolean avengerAPrime = isPrime(scoreA);
        boolean avengerAPalindrome = isPalindrome(scoreA);
        boolean avengerBPrime = isPrime(scoreB);
        boolean avengerBPalindrome = isPalindrome(scoreB);

        // Check for a tie
        if ((avengerAPrime && avengerBPrime) || (avengerAPalindrome && avengerBPalindrome) ||
            (avengerAPrime && avengerBPalindrome) || (avengerBPrime && avengerAPalindrome)) {
            return "It's a tie!";
        }

        // Determine the winner
        if (avengerAPrime || avengerAPalindrome) {
            return avengerA;
        } else if (avengerBPrime || avengerBPalindrome) {
            return avengerB;
        } else {
            return "No one"; // Neither Avenger meets the criteria
        }
    }

    // Print favorite Avenger
    public void printFavorite(String favorite) {
        System.out.println("Your favorite Avenger is: " + favorite);
    }
}

public class CivilWarDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an object of CivilWar
        CivilWar civilWar = new CivilWar();

        // Take input for the names of three Avengers
        System.out.println("Enter the name of the first Avenger:");
        String avenger1 = scanner.nextLine();

        System.out.println("Enter the name of the second Avenger:");
        String avenger2 = scanner.nextLine();

        System.out.println("Enter the name of the third Avenger:");
        String avenger3 = scanner.nextLine();

        // Set the names of the Avengers in the CivilWar object
        civilWar.setAvengers(avenger1, avenger2, avenger3);

        // Select two Avengers for the duel
        System.out.println("Select the first Avenger for the duel:");
        String avengerA = scanner.nextLine();

        System.out.println("Select the second Avenger for the duel:");
        String avengerB = scanner.nextLine();

        // Validate selection to ensure valid Avengers are chosen
        if (!avengerA.equals(avenger1) && !avengerA.equals(avenger2) && !avengerA.equals(avenger3)) {
            System.out.println("Invalid choice for the first Avenger.");
            scanner.close();
            return;
        }

        if (!avengerB.equals(avenger1) && !avengerB.equals(avenger2) && !avengerB.equals(avenger3)) {
            System.out.println("Invalid choice for the second Avenger.");
            scanner.close();
            return;
        }

        // Generate random scores (two-digit numbers)
        int scoreA = getRandomTwoDigitScore();
        int scoreB = getRandomTwoDigitScore();

        System.out.println("Randomly generated score for " + avengerA + ": " + scoreA);
        System.out.println("Randomly generated score for " + avengerB + ": " + scoreB);

        // Call the duel method to determine the winner or tie
        String result = civilWar.duel(avengerA, avengerB, scoreA, scoreB);
        System.out.println("Result of the duel: " + result);

        // Take input for the user's favorite Avenger
        System.out.println("Enter your favorite Avenger:");
        String favoriteAvenger = scanner.nextLine();

        // Print the user's favorite Avenger
        civilWar.printFavorite(favoriteAvenger);

        // Close the scanner to avoid resource leaks
        scanner.close();
    }

    // Method to generate a random two-digit score
    private static int getRandomTwoDigitScore() {
        Random rand = new Random();
        while (true) {
            int num = rand.nextInt(90) + 10;  // Generates a number between 10 and 99
            if (isPrime(num) || isPalindrome(num)) {
                return num;
            }
        }
    }

    // Method to check if a number is prime
    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // Method to check if a number is a palindrome
    private static boolean isPalindrome(int num) {
        int original = num, reverse = 0;
        while (num > 0) {
            reverse = reverse * 10 + num % 10;
            num /= 10;
        }
        return original == reverse;
    }
}
