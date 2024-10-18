package Foundations.flowcontrol.fors;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class InterestCalculator {
  private Scanner inputReader = new Scanner(System.in);
  private DecimalFormat df = new DecimalFormat("#.00");
  private int numOfCompounding;
  private BigDecimal interestRate;
  private BigDecimal amount;
  private int years;


  public static void main(String[] args) {
    InterestCalculator ic = new InterestCalculator();
    ic.calculateCompoundInterest();
  }

  public void calculateCompoundInterest() {
    InterestCalculator IC = new InterestCalculator();
    IC.intro();

    for (int i = 1; i <= IC.years; i++) {
      System.out.println("Year " + i + ":");
      System.out.println("Began with " + df.format(IC.amount));
      BigDecimal newAmount = IC.calculateInterest();
      System.out.println("Earned " + df.format(newAmount.subtract(IC.amount)));
      IC.amount = newAmount;
      System.out.println("Ended with " + df.format(IC.amount));
      System.out.println("-----------------------------------------\n");
    }
  }

  private BigDecimal calculateInterest() {
    BigDecimal compoundedAmount = amount;
    for (int y = 0; y < numOfCompounding; y++) {
      BigDecimal interestPerCompounding = interestRate.divide(BigDecimal.valueOf(numOfCompounding), RoundingMode.HALF_UP).divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP);
      compoundedAmount = compoundedAmount.add(compoundedAmount.multiply(interestPerCompounding));
    }
    return compoundedAmount.setScale(2, RoundingMode.HALF_UP); // Set scale to 2 for decimal places
  }

  private void intro() {
    System.out.println("How much do you want to invest? ");
    amount = BigDecimal.valueOf(inputReader.nextDouble());
    System.out.println("How many years are you investing? ");
    years = inputReader.nextInt();
    System.out.println("What is the annual interest rate % growth? ");
    interestRate = BigDecimal.valueOf(inputReader.nextDouble());
    System.out.println("How many interest compounding periods a year do you want? ");
    numOfCompounding = inputReader.nextInt();
    System.out.println("\nCalculating...\n");
  }
}