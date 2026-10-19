package com.pluralsight;

import java.util.Scanner;

public class CDCalculator {
    public static void main(String[] args) {

        // create a scanner so we can get input from the user
        Scanner scnr = new Scanner(System.in);

        // add message showing which calculator the user is using
        System.out.println("*** CD Future Value Calculator ***");

        // ask the user how much money they are initially depositing
        System.out.println("Enter your initial deposit: ");
        double principal = scnr.nextDouble();

        // ask for the annual interest rate as a percent
        System.out.print("Enter annual interest rate (%): ");
        double annualRate = scnr.nextDouble();

        // ask for how many years the CD will mature
        System.out.print("Enter number of years: ");
        int years = scnr.nextInt();

        // use double because interest rates have decimals
        // The formula needs the interest rate in decimal form
        // We divide by 100 to convert percent into decimal
        double interestRate = annualRate / 100;

        // set the number of days in a year
        // daily compounding 365 days per year
        int daysPerYear = 365;

        // calculate the total number of days
        // multiply days per year by the number of years
        // this tells us how many times interest is compounded
        int totalDays = daysPerYear * years;


        // calculate the future value of the CD
        // The assignment gives us this formula:
        // FV = P * (1 + (r / d)) ^ n
        //
        // P = principal (starting deposit)
        // r = annual interest rate as a decimal
        // d = number of days per year (365)
        // n = total days the CD earns interest
        //
        // First, divide interestRate by daysPerYear
        // This gives us the daily interest rate
        //
        // Next, add 1 to the daily interest rate
        // This creates the daily growth factor
        //
        // Math.pow() raises that growth factor to totalDays
        // This represents interest compounding each day
        //
        // Finally, multiply by principal to get the ending balance
        double futureValue = principal *
                Math.pow(1 + (interestRate / daysPerYear), totalDays);

        // calculate the total interest earned
        // the future value includes the original deposit
        // subtract the original deposit to find only the interest
        double totalInterest = futureValue - principal;

        // display final results
        // \n creates a blank line before the results
        System.out.println("\n*** CD Results ***");

        // %.2f displays two numbers after the decimal point
        // %% prints a percent sign
        // %n moves the output to the next line
        System.out.printf("If you deposit $%.2f in a CD that earns %.2f%% annual interest%n",
                principal, annualRate);

        // display how many years the CD will mature in
        // The + signs combine text with the years variable
        System.out.println("and matures in " + years + "years,");

        // Display the ending balance
        // %.2f formats the money to two decimal places
        System.out.printf("your CD's ending balance will be $%.2f%n", totalInterest);


        // Display how much interest was earned
        // This does not include the original deposit
        System.out.printf("Total interest earned: $%.2f%n", totalInterest);

        // close the scanner
        scnr.close();




    }
}
