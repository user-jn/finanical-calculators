
package com.pluralsight;

import java.util.Scanner;

public class CDCalculator {

    // Allows us to run the CD calculator independently
    public static void main(String[] args) {

        // Create a Scanner for standalone testing
        Scanner scnr = new Scanner(System.in);

        // Run the CD calculation
        calculate(scnr);

        // Close Scanner when running this file alone
        scnr.close();
    }


    // Receives the Scanner from Main or our own main method
    public static void calculate(Scanner scnr) {

        System.out.println("\n*** CD Future Value Calculator ***");

        // STEP 1: Ask for the initial deposit
        System.out.print("Enter your initial deposit: ");
        double principal = scnr.nextDouble();

        // STEP 2: Ask for the annual interest rate as a percent
        System.out.print("Enter annual interest rate (%): ");
        double annualRate = scnr.nextDouble();

        // STEP 3: Ask for the number of years
        System.out.print("Enter number of years: ");
        int years = scnr.nextInt();

        // Clear the leftover Enter character
        // This allows Main to read the next menu choice
        scnr.nextLine();

        // Check that our inputs are valid
        if (principal <= 0 || annualRate < 0 || years <= 0) {
            System.out.println("Invalid CD information.");
            return;
        }

        // STEP 4: Call our method to find future value
        double futureValue =
                calcFutureValue(principal, annualRate, years);

        // STEP 5: Calculate how much interest was earned
        double totalInterest = futureValue - principal;

        // STEP 6: Display the results
        printResults(principal, annualRate, years,
                futureValue, totalInterest);
    }


    // Separate method for calculating future value
    public static double calcFutureValue(double principal,
                                         double annualRate,
                                         int years) {

        // Convert percent into decimal form
        // Example: 1.75 / 100 = 0.0175
        double interestRate = annualRate / 100;

        // Daily compounding uses 365 days
        int daysPerYear = 365;

        // Calculate the total number of days
        int totalDays = daysPerYear * years;

        // FV = P * (1 + (r / d)) ^ n
        // Math.pow compounds the daily interest
        double futureValue = principal *
                Math.pow(1 + (interestRate / daysPerYear), totalDays);

        // Return the future value
        return futureValue;
    }


    // Separate method to display the CD results
    public static void printResults(double principal,
                                    double annualRate,
                                    int years,
                                    double futureValue,
                                    double totalInterest) {

        System.out.println("\n==== CD RESULTS ====");

        System.out.printf(
                "If you deposit $%.2f in a CD that earns %.2f%% annual interest%n",
                principal, annualRate);

        System.out.println("and matures in " + years + " years,");

        System.out.printf(
                "your CD's ending balance will be $%.2f%n",
                futureValue);

        System.out.printf(
                "Total Interest Earned: $%.2f%n",
                totalInterest);
    }
}

