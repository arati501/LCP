package cor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LengthConverterProgram {
    private Handler firstHandler;

    public LengthConverterProgram() {
        Handler mileHandler = new MileHandler();
        Handler yardHandler = new YardHandler();
        Handler footHandler = new FootHandler();

        mileHandler.setNextHandler(yardHandler);
        yardHandler.setNextHandler(footHandler);

        firstHandler = mileHandler;
    }
    
    public double convert(double amount, String unit) {
        if (firstHandler != null) {
            return firstHandler.handleRequest(amount, unit);
        } else {
            System.out.println("Handler not set");
            return -1;
        }
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        double distance = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Enter a distance in kilometers: ");
                distance = scanner.nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); 
            }
        }

        System.out.println("Choose a metric to convert length to:");
        System.out.println("1. MILE");
        System.out.println("2. YARD");
        System.out.println("3. FOOT");

        int choice = scanner.nextInt();

        String conversionUnit;
        switch (choice) {
            case 1:
                conversionUnit = "MILE";
                break;
            case 2:
                conversionUnit = "YARD";
                break;
            case 3:
                conversionUnit = "FEET";
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        double result = convert(distance, conversionUnit);

        if (result != -1) {
            System.out.println("Result is " + distance + " kilometers = " + result + " " + conversionUnit);
        }
    }

    public static void main(String[] args) {
        LengthConverterProgram program = new LengthConverterProgram();
        program.start();
    }
}