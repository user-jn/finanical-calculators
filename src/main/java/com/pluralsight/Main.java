
package com.pluralsight;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Create one Scanner to get input from the user
        // This Scanner will be shared with both calculators
        Scanner scnr = new Scanner(System.in);

        // Display the financial calculator menu
        System.out.println("==== FINANCIAL CALCULATORS ====");
        System.out.println("What calculator would you like to use?");

        // Display the two available calculators
        System.out.println("1. Mortgage Calculator - Find Monthly Payment & Interest");
        System.out.println("2. CD Calculator - Find Future Value of Your CD's One-Time Deposit");
        System.out.println("X. Exit");

        // Ask the user to select a calculator
        System.out.print("Select a calculator: ");

        // Read the user's choice as a String
        // This allows the user to enter 1, 2, or X
        String calculatorChoice = scnr.nextLine();

        // Use switch to determine which calculator to run
        switch (calculatorChoice) {

            case "1":

                // Run the Mortgage Calculator
                // Pass our existing Scanner into the method
                MortgageCalculator.calculate(scnr);
                break;

            case "2":

                // Run the CD Calculator
                // Pass the same Scanner into the CD method
                CDCalculator.calculate(scnr);
                break;

            case "X":
            case "x":

                // Exit the program
                System.out.println("Thank you for using our calculators!");
                break;

            default:

                // Handle an invalid selection
                System.out.println("Invalid selection. Please try again.");
                break;
        }

        // Close the Scanner after the calculator finishes
        scnr.close();
    }
}
