package Foundations.basics.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class Factorizer {
  private Scanner userInput = new Scanner(System.in);
  private ArrayList<Integer> factors = new ArrayList<>();

  public void Factorize() {
    Factorizer factorizer = new Factorizer();
    System.out.println("What number would you like to factor? ");
    int userNum = factorizer.userInput.nextInt();

    for (int i = 1; i <= userNum; i++) {
      if (userNum % i == 0) {
        factorizer.factors.add(i);
      }
    }
    factorizer.PerfectNumANDPrime(userNum);
  }

  private void PerfectNumANDPrime(int userNum) {
    int isPerfectNum = determinePerfectNum(userNum);

    if (isPerfectNum == userNum) {
      System.out.println(userNum + " is a perfect number.");
    } else {
      System.out.println(userNum + " is not a perfect number.");
    }

    if (factors.size() == 2) {
      System.out.println(userNum + " is a prime number.");
    } else {
      System.out.println(userNum + " is not a prime number.");
    }
  }

  private int determinePerfectNum(int userNum) {
    int isPerfectNum = 0;
    String factorals = "";
    System.out.println("The factors of " + userNum + " are:");

    for (int i = 0; i < factors.size() - 1; i++) {
      isPerfectNum += factors.get(i);
      factorals += factors.get(i) + " ";
    }

    System.out.println(factorals + userNum);
    System.out.println(userNum + " has " + factors.size() + " factors.");
    return isPerfectNum;
  }
}