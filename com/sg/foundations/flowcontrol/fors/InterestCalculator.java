package com.sg.foundations.flowcontrol.fors;

import java.text.DecimalFormat;
import java.util.Scanner;

public class InterestCalculator {
  private Scanner inputReader = new Scanner(System.in);
  private DecimalFormat df = new DecimalFormat("#.00");
  private int numOfCompounding;
  private double interestRate;
  private double amount;
  private int years;

  public static void main(String[] args) {
    InterestCalculator IC =  new InterestCalculator();
    IC.intro();

    for (int i = 1; i <= IC.years; i ++) {
      System.out.println("Year " + i + ":");
      System.out.println("Began with " + IC.amount);
      double newAmount = IC.calculateInterest();
      System.out.println("Earned " + (Double.parseDouble(IC.df.format(newAmount - IC.amount))));
      IC.amount = newAmount;
      System.out.println("Ended with " + Double.parseDouble(IC.df.format(IC.amount)));
      System.out.println("-----------------------------------------\n");
    }
  }

  public double calculateInterest() {
    double compoundedAmount = amount;
    for (int y = 0; y < numOfCompounding; y++) {
      compoundedAmount *= 1 + ((interestRate / numOfCompounding) / 100);
    }
    return Double.parseDouble(df.format(compoundedAmount));
  }

  public void intro() {
    System.out.println("How much do you want to invest? ");
    amount = inputReader.nextInt();
    System.out.println("How many years are investing? ");
    years = inputReader.nextInt();
    System.out.println("What is the annual interest rate % growth? ");
    interestRate = inputReader.nextInt();
    System.out.println("How many interest compounding period a year do you want? ");
    numOfCompounding = inputReader.nextInt();
    System.out.println("\nCalculating...\n");
  }
}

/**
 * Change the program so that interest is compounded monthly.
 *    Change the numOfCompounding to 12.
 * Change the program so that the user can choose from quarterly, monthly, or daily interest compound periods.
 *    Added a line to get number from user and assign it to the numOfCompounding variable.
 */
