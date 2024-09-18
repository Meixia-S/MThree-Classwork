package com.sg.foundations.random;

import java.util.Random;
import java.util.Scanner;

public class GuessMeMore {
  private final Random random = new Random();
  private int RAND_NUM = random.nextInt(101);
  private final Scanner userInput = new Scanner(System.in);

  public GuessMeMore() {
    final int isNegative = random.nextInt(2);
    if (isNegative == 0) {
      RAND_NUM *= - 1;
    }
  }

  public static void main(String[] args) {
    GuessMeMore guessMeMore = new GuessMeMore();

    System.out.println("A random number has just been generated between -100 and 100.");
    System.out.println("You get 20 tries to guess what the number is - don't worry we will give " +
            "you hints!");

    guessMeMore.numChecker();
  }

  private void numChecker() {
    for (int i = 0; i < 20; i ++) {
      int guess = Integer.valueOf(userInput.nextLine());
      if (guess > RAND_NUM) {
        System.out.println("That number is too high! Try Again!");
      } else if (guess < RAND_NUM) {
        System.out.println("That number is too low! Try Again!");
      } else {
        System.out.println("You Got It! " + RAND_NUM + " was the random number");
        break;
      }
    }
  }
}
