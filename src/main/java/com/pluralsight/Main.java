
package com.pluralsight;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Create one Scanner for the entire menu
        Scanner scnr = new Scanner(System.in);

        // Store the user's choice
        String calculatorChoice = "";

        // Continue showing the menu until the user enters X
        while (!calculatorChoice.equalsIgnoreCase("x")) {

            // Display the menu
            System.out.println("\n==== FINANCIAL CALCULATORS ====");
            System.out.println("What calculator would you like to use?");
            System.out.println("1. Mortgage Calculator - Find Monthly Payment & Interest");
            System.out.println("2. CD Calculator - Find Future Value of Your CD's One-Time Deposit");
            System.out.println("X. Exit");

            // Ask for a menu selection
            System.out.print("Select a calculator: ");
            calculatorChoice = scnr.nextLine();

            // Determine which calculator should run
            switch (calculatorChoice) {

                case "1":
                    // Pass our Scanner to the mortgage calculator
                    MortgageCalculator.calculate(scnr);
                    break;

                case "2":
                    // Pass our Scanner to the CD calculator
                    CDCalculator.calculate(scnr);
                    break;

                case "X":
                case "x":
                    // Exit the menu
                    System.out.println("Thank you for using our calculators!");
                    break;

                default:
                    // Handle an invalid choice
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
        }

        // Close the Scanner only when exiting the program
        scnr.close();
    }
}
