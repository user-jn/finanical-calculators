
package com.pluralsight;

import java.util.Scanner;

public class MortgageCalculator {

    // Allows us to run this calculator independently
    public static void main(String[] args) {

        // Create a Scanner for standalone testing
        Scanner scnr = new Scanner(System.in);

        // Run the mortgage calculation
        calculate(scnr);

        // Close Scanner when running this file alone
        scnr.close();
    }


    // Receives the Scanner from Main or our own main method
    public static void calculate(Scanner scnr) {

        System.out.println("\n*** Mortgage Calculator ***");

        // STEP 1: Get the home purchase price
        System.out.print("Enter the home purchase price: ");
        double principal = scnr.nextDouble();

        // STEP 2: Get the down payment
        System.out.print("Enter your down payment: ");
        double downPayment = scnr.nextDouble();

        // STEP 3: Get the annual interest rate as a percent
        System.out.print("Enter annual interest rate (%): ");
        double annualRate = scnr.nextDouble();

        // STEP 4: Get the loan length in years
        System.out.print("Enter loan length in years: ");
        int years = scnr.nextInt();

        // Consume the leftover Enter character
        // So the main menu can read another choice
        scnr.nextLine();

        // Make sure the entered amounts are valid
        if (principal <= 0 || downPayment < 0 ||
                downPayment > principal || annualRate < 0 || years <= 0) {
            System.out.println("Invalid mortgage information.");
            return;
        }

        // STEP 5: Find how much money is borrowed
        double loanAmount = principal - downPayment;

        // STEP 6: Convert annual interest to monthly interest
        double monthlyRate = annualRate / 100 / 12;

        // STEP 7: Calculate the total number of payments
        int numberOfPayments = years * 12;

        // STEP 8: Call our separate method to calculate payment
        double monthlyPayment =
                calcMonthlyPayment(loanAmount, monthlyRate, numberOfPayments);

        // STEP 9: Calculate the total interest
        double totalInterest =
                (monthlyPayment * numberOfPayments) - loanAmount;

        // STEP 10: Display our results
        printResults(downPayment, loanAmount, monthlyPayment, totalInterest);
    }


    // Separate method for calculating monthly payments
    public static double calcMonthlyPayment(double loanAmount,
                                            double monthlyRate,
                                            int numberOfPayments) {

        // If there is no interest, divide loan by payments
        if (monthlyRate == 0) {
            return loanAmount / numberOfPayments;
        }

        // Calculate the compound factor
        double compoundFactor =
                Math.pow(1 + monthlyRate, numberOfPayments);

        // Calculate the monthly mortgage payment
        double monthlyPayment = loanAmount *
                (monthlyRate * compoundFactor) /
                (compoundFactor - 1);

        // Send the calculated payment back
        return monthlyPayment;
    }


    // Separate method to display the mortgage results
    public static void printResults(double downPayment,
                                    double loanAmount,
                                    double monthlyPayment,
                                    double totalInterest) {

        System.out.println("\n==== MORTGAGE RESULTS ====");
        System.out.printf("Down Payment: $%.2f%n", downPayment);
        System.out.printf("Loan Amount: $%.2f%n", loanAmount);
        System.out.printf("Monthly Payment: $%.2f%n", monthlyPayment);
        System.out.printf("Total Interest: $%.2f%n", totalInterest);
    }
}

