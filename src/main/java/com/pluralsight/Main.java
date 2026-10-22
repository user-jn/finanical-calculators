
package com.pluralsight;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Create one Scanner for all calculators
        Scanner scnr = new Scanner(System.in);
        String calculatorChoice;

        // Keep showing the menu until user chooses X
        do {
            System.out.println("\n==== FINANCIAL CALCULATORS ====");
            System.out.println("What calculator would you like to use?");
            System.out.println("1. Mortgage Calculator - Find Monthly Payment & Interest");
            System.out.println("2. CD Calculator - Find Future Value of Your CD's One-Time Deposit");
            System.out.println("3. Annuity Calculator - Find Present Value of an Ordinary Annuity");
            System.out.println("X. Exit");


            System.out.print("Select a calculator: ");
            calculatorChoice = scnr.nextLine().trim();

            // Run selected calculator
            switch (calculatorChoice.toUpperCase()) {

                case "1":
                    MortgageCalculator.calculate(scnr);
                    scnr.nextLine(); // Clear leftover Enter
                    break;

                case "2":
                    CDCalculator.calculate(scnr);
                    scnr.nextLine(); // Clear leftover Enter
                    break;

                case "3":
                    AnnuityCalculator.calculate(scnr);
                    scnr.nextLine(); // Clear leftover Enter
                    break;

                case "X":
                    System.out.println("Thank you for using our calculators!");
                    break;

                default:
                    System.out.println("Invalid selection. Try again.");
            }

        } while (!calculatorChoice.equalsIgnoreCase("X"));

        // Close Scanner only when the program exits
        scnr.close();
    }
}
