package Foundations;

import Foundations.basics.arrays.Factorizer;
import Foundations.flowcontrol.fors.InterestCalculator;
import Foundations.flowcontrol.fors.LuckySevens;

import java.util.Scanner;

public class RefactorObjects {

  public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);

    System.out.println("Which of the four tasks do you want to do?");
    System.out.println("* Use the corresponding numbers to chose *");
    System.out.println("1) Play Rock Paper Scissors");
    System.out.println("2) Play LuckySevens");
    System.out.println("3) Calculate Interest ");
    System.out.println("4) Factorize an Integer (1 - 10) ");
    int userChoice = userInput.nextInt();
    System.out.println("\n-----------------------------------------");

    if (userChoice == 1) {
      RockPaperScissors rockPaperScissors = new RockPaperScissors();
      rockPaperScissors.playGame();
    } else if (userChoice == 2) {
      LuckySevens luckySevens = new LuckySevens();
      luckySevens.playLuckySevens();
    } else if (userChoice == 3) {
      InterestCalculator interestCalculator = new InterestCalculator();
      interestCalculator.calculateCompoundInterest();
    } else if (userChoice == 4) {
      Factorizer factorizer = new Factorizer();
      factorizer.Factorize();
    } else {
      System.out.println("Invalid Input, Please Try Again and Enter a Value Between 1 and 4.");
    }
  }
}