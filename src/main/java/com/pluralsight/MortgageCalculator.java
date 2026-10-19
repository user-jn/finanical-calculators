
package com.pluralsight;

import java.util.Scanner;

public class MortgageCalculator {

    // This method receives the Scanner from Main.java
    // We do not create another Scanner inside this calculator
    public static void calculate(Scanner scnr) {

        // Display the mortgage calculator title
        System.out.println("\n*** Mortgage Calculator ***");


        // STEP 1: Ask for the home purchase price
        // We use double because money can have decimal values
        System.out.print("Enter the home purchase price: ");
        double principal = scnr.nextDouble();


        // STEP 2: Ask how much money the user is putting down
        // This amount will be subtracted from the purchase price
        System.out.print("Enter your down payment: ");
        double downPayment = scnr.nextDouble();


        // STEP 3: Ask for the annual interest rate
        // Example: Enter 7.625 for 7.625%
        System.out.print("Enter annual interest rate (%): ");
        double annualRate = scnr.nextDouble();


        // STEP 4: Ask for the length of the loan in years
        // We use int because we are asking for whole years
        System.out.print("Enter loan length in years: ");
        int years = scnr.nextInt();


        // STEP 5: Convert annual interest into monthly interest
        // Divide by 100 to convert percentage into decimal form
        // Divide by 12 because there are 12 months in a year
        double monthlyRate = annualRate / 100 / 12;


        // STEP 6: Calculate the total number of monthly payments
        // Example: 30 years * 12 months = 360 payments
        int numberOfPayments = years * 12;


        // STEP 7: Calculate how much money is actually borrowed
        // Subtract the down payment from the purchase price
        double loanAmount = principal - downPayment;


        // STEP 8: Create a variable to store the monthly payment
        double monthlyPayment;


        // STEP 9: Check if the annual interest rate is zero
        // This prevents dividing by zero in our formula
        if (annualRate == 0) {

            // Without interest, divide the loan by total payments
            monthlyPayment = loanAmount / numberOfPayments;

        } else {

            // Calculate the compound interest factor
            // Math.pow raises a number to a power
            double compoundFactor =
                    Math.pow(1 + monthlyRate, numberOfPayments);


            // Calculate the monthly mortgage payment
            monthlyPayment = loanAmount *
                    (monthlyRate * compoundFactor) /
                    (compoundFactor - 1);
        }


        // STEP 10: Calculate the total interest paid
        // Multiply monthly payment by the number of payments
        // Subtract the original borrowed amount
        double totalInterest =
                (monthlyPayment * numberOfPayments) - loanAmount;


        // STEP 11: Display the mortgage results
        System.out.println("\n*** Mortgage Results ***");

        // Display the down payment
        System.out.printf("Down Payment: $%.2f%n", downPayment);

        // Display how much money was borrowed
        System.out.printf("Loan Amount: $%.2f%n", loanAmount);

        // Display the monthly mortgage payment
        System.out.printf("Monthly Payment: $%.2f%n", monthlyPayment);

        // Display the total interest paid
        System.out.printf("Total Interest: $%.2f%n", totalInterest);


        // We do not close scnr here
        // Main.java is responsible for closing it
    }
}

