package com.pluralsight;

import java.util.Scanner;

public class AnnuityCalculator {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        calculate(scnr);

    }
    public static void calculate(Scanner scnr) {


        // welcome message

        System.out.println("""
                
                ========================================
                       ANNUITY CALCULATOR
                ========================================
                Calculate how much money you need today
                to receive monthly payments in the future.
                
                --- Please provide the following ---
                """);

        // get inputs
        System.out.print("1. Enter monthly payout ($): ");
        double monthlyPayout = scnr.nextDouble();

        System.out.print("2. Enter annual interest rate (%): ");
        double annualInterest = scnr.nextDouble();

        System.out.print("3. Enter number of years: ");
        int annuityLength = scnr.nextInt();

        // Calculate present value
        double presentValue = calcPresentValue(
                monthlyPayout, annualInterest, annuityLength);
        // Display results
        displayResults(monthlyPayout, annualInterest,
                annuityLength, presentValue);


    }

    // calculate present value of ordinary annuity
    public static double calcPresentValue(double monthlyPayout, double annualInterest,
                                          int annuityLength) {

        // Convert annual percent into monthly decimal rate
        double monthlyInterest = annualInterest / 100 / 12;

        // Calculate total number of monthly payments
        int numberOfPayouts = annuityLength * 12;

        // Handle 0% interest (avoid dividing by zero)
        if (monthlyInterest == 0) {
            return monthlyPayout * numberOfPayouts;
        }

        // Calculate present value
        double presentValue = monthlyPayout *
                (1 - Math.pow(1 + monthlyInterest,
                        -numberOfPayouts)) / monthlyInterest;

        return presentValue;


    }


        // Display formatted annuity summary
        public static void displayResults(
        double monthlyPayout,
        double annualInterest,
        int annuityLength,
        double presentValue) {

            System.out.println("""
                
                ========================================
                         ANNUITY SUMMARY
                ========================================
                """);

            System.out.printf("Monthly Payout:      $%,.2f%n", monthlyPayout);
            System.out.printf("Annual Interest:      %.2f%%%n", annualInterest);
            System.out.printf("Annuity Length:       %d years%n", annuityLength);

            System.out.println("----------------------------------------");

            System.out.printf("Present Value:       $%,.2f%n", presentValue);

            System.out.println("""
                ========================================
                   Thank you for using our calculator!
                ========================================
                """);
        }
    }






