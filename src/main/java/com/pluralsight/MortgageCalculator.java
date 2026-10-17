package com.pluralsight;

import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {

        // create scanner so the user can enter information
        Scanner scnr = new Scanner(System.in);

        System.out.println("Mortgage Calculator");

        // ask for the amount of loan
        System.out.print("Enter principal loan amount: ");
        double principal = scnr.nextDouble();

        // ask for annual interest rate as a percent
        System.out.print("Enter annual interest rate: ");
        double annualInterestRate = scnr.nextDouble();

        // ask how many year the loan will last
        System.out.print("Enter loan length in years: ");
        int loanYears = scnr.nextInt();

        // convert the interest percent into decimal form
        double interestDecimal = annualInterestRate / 100;

        // convert annual interest into monthly interest
        double monthlyInterestRate = interestDecimal / 12;

        // find total number of monthly payments
        //ex. 15 years * 12 = 180 payments
        int numberOfPayments = loanYears * 12;

        // calculate the monthly mortgage payment
        // M = P * (i * (1 + i)^n) / ((1 + i)^n - 1)
        double monthlyPayment =
                principal
                        * (monthlyInterestRate
                        * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                        / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        // calculate total interest paid over the life of the loan
        double totalInterest = (monthlyPayment * numberOfPayments) - principal;

        // display results
        System.out.printf("Monthly Payment: $%.2f%n", monthlyPayment);
        System.out.printf("Total Interest Paid: $%.2f%n", totalInterest);

        // close scanner
        scnr.close();


    }
}
