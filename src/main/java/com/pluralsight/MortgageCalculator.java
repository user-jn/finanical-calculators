package com.pluralsight;

import java.util.Scanner;

public class MortgageCalculator {

    // create scanner so the user can enter information
    Scanner scnr = new Scanner(System.in);

    System.out.println("Mortgage Calculator");

    // ask for the amount of loan
    System.out.print("Enter principal loan ammount: ");
    double principal = scnr.nextDouble();

    // ask for annual interest rate as a percent
    System.out.print("Enter loan length in years: ");
    int loanYears = scnr.nextInt();


}
