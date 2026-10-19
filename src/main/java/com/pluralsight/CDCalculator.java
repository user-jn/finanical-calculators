
package com.pluralsight;

import java.util.Scanner;

public class CDCalculator {

    // This method receives the Scanner from Main.java
    // We use the same Scanner instead of creating a new one
    public static void calculate(Scanner scnr) {

        // Display the CD calculator title
        System.out.println("\n*** CD Future Value Calculator ***");


        // STEP 1: Ask for the initial deposit
        // This is the amount of money the user starts with
        // We use double because money can have decimals
        System.out.print("Enter your initial deposit: ");
        double principal = scnr.nextDouble();


        // STEP 2: Ask for the annual interest rate
        // The user enters a percentage such as 1.75
        System.out.print("Enter annual interest rate (%): ");
        double annualRate = scnr.nextDouble();


        // STEP 3: Ask how many years the CD will mature
        // We use int because we are asking for whole years
        System.out.print("Enter number of years: ");
        int years = scnr.nextInt();


        // STEP 4: Convert the interest percentage into decimal form
        // Example: 1.75 / 100 = 0.0175
        double interestRate = annualRate / 100;


        // STEP 5: Set the number of days per year
        // Daily compounding uses 365 days per year
        int daysPerYear = 365;


        // STEP 6: Calculate the total number of days
        // Example: 365 * 5 = 1825 days
        int totalDays = daysPerYear * years;


        // STEP 7: Calculate the future value of the CD
        //
        // Formula: FV = P * (1 + (r / d)) ^ n
        //
        // P = original deposit
        // r = annual interest rate in decimal form
        // d = 365 days per year
        // n = total number of days
        //
        // First, divide interestRate by daysPerYear
        // This gives us the daily interest rate
        //
        // Next, add 1 to the daily interest rate
        // This creates the daily growth factor
        //
        // Math.pow compounds the growth over all the days
        // Multiply by principal to get the ending balance

        double futureValue = principal *
                Math.pow(1 + (interestRate / daysPerYear), totalDays);


        // STEP 8: Calculate how much interest was earned
        // Subtract the original deposit from the future value
        double totalInterest = futureValue - principal;


        // STEP 9: Display the CD results
        System.out.println("\n*** CD Results ***");


        // Display the original deposit and annual interest rate
        // %.2f displays two decimal places
        // %% displays a percent sign
        // %n moves to the next line
        System.out.printf(
                "If you deposit $%.2f in a CD that earns %.2f%% annual interest%n",
                principal, annualRate);


        // Display how many years the CD will mature in
        System.out.println("and matures in " + years + " years,");


        // Display the future value including the original deposit
        System.out.printf(
                "your CD's ending balance will be $%.2f%n",
                futureValue);


        // Display only the interest earned
        System.out.printf(
                "Total Interest Earned: $%.2f%n",
                totalInterest);


        // We do not close scnr here
        // Main.java is responsible for closing it
    }
}

