import java.util.Scanner;

// Custom exception for traffic violations
class TrafficViolationException extends Exception {
    public TrafficViolationException(String message) {
        super(message);
    }
}

// Custom exception for unauthorized vehicles
class UnauthorizedVehicleException extends Exception {
    public UnauthorizedVehicleException(String message) {
        super(message);
    }
}

// Vehicle class to store vehicle details
class Vehicle {
    private String vehicleNumber;
    private int speed;
    private boolean redLightJump;

    // Constructor to initialize vehicle details
    public Vehicle(String vehicleNumber, int speed, boolean redLightJump) {
        this.vehicleNumber = vehicleNumber;
        this.speed = speed;
        this.redLightJump = redLightJump;
    }

    // Method to check traffic violations
    public void checkTrafficViolation() throws TrafficViolationException, UnauthorizedVehicleException {
        if (vehicleNumber == null || vehicleNumber.isEmpty()) {
            throw new UnauthorizedVehicleException("Unauthorized Vehicle: No number plate detected");
        }
        if (speed > 60) {
            throw new TrafficViolationException("Challan Issued: Overspeeding");
        }
        if (redLightJump) {
            throw new TrafficViolationException("Challan Issued: Red Light Jump");
        }
        // If no violations, print message
        System.out.println(vehicleNumber + " - No Violation");
    }

    // Getters for validation
    public static int validateSpeed(Scanner scanner) {
        int speed;
        while (true) {
            try {
                System.out.print("Enter speed (0 - 300 km/h): ");
                speed = Integer.parseInt(scanner.nextLine().trim());
                if (speed < 0 || speed > 300) {
                    System.out.println("Invalid speed! Please enter a valid speed between 0 and 300 km/h.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a numeric value for speed.");
            }
        }
        return speed;
    }

    public static boolean validateRedLightJump(Scanner scanner) {
        while (true) {
            System.out.print("Did the vehicle jump a red light? (true/false/yes/no/1/0): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("true") || input.equals("yes") || input.equals("1")) {
                return true;
            } else if (input.equals("false") || input.equals("no") || input.equals("0")) {
                return false;
            } else {
                System.out.println("Invalid input! Please enter true/false, yes/no, or 1/0.");
            }
        }
    }
}

// Main class to simulate the traffic monitoring system
public class TrafficMonitoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of vehicles: ");
        int numVehicles;
        while (true) {
            try {
                numVehicles = Integer.parseInt(scanner.nextLine().trim());
                if (numVehicles <= 0) {
                    System.out.println("Please enter a valid number of vehicles (greater than 0).");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a numeric value.");
            }
        }

        // Array to store vehicle objects
        Vehicle[] vehicles = new Vehicle[numVehicles];

        // Loop to input vehicle details and store them in the array
        for (int i = 0; i < numVehicles; i++) {
            System.out.print("Enter vehicle number (or leave empty if no number plate): ");
            String vehicleNumber = scanner.nextLine().trim();

            int speed = Vehicle.validateSpeed(scanner);
            boolean redLightJump = Vehicle.validateRedLightJump(scanner);

            // Creating and storing Vehicle object in the array
            vehicles[i] = new Vehicle(vehicleNumber, speed, redLightJump);
        }

        // Checking traffic violations for each vehicle
        for (Vehicle vehicle : vehicles) {
            try {
                vehicle.checkTrafficViolation();
            } catch (UnauthorizedVehicleException e) {
                System.out.println(e.getMessage());
            } catch (TrafficViolationException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("Traffic check completed for this vehicle.\n");
            }
        }
        scanner.close();
    }
}
