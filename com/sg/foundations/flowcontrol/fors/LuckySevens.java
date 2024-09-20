package com.sg.foundations.flowcontrol.fors;

import java.util.Random;
import java.util.Scanner;

public class LuckySevens {
  private Scanner inputReader = new Scanner(System.in);
  private Random rand = new Random();
  private int rolls;
  private int aboveWaterRolls;
  private int aboveWaterValue;

  public void playLuckySevens() {
    LuckySevens luckySevens = new LuckySevens();
    System.out.println("How many dollars do you have? ");
    int amount = luckySevens.inputReader.nextInt();

    while (amount > 0) {
      int diceOne = luckySevens.rand.nextInt(6);
      int diceTwo = luckySevens.rand.nextInt(6);
      luckySevens.rolls++;

      if ((diceOne + 1) + (diceTwo + 1) == 7) {
        amount += 4;
      } else {
        amount -= 1;
      }

      if (luckySevens.aboveWaterValue <= amount) {
        luckySevens.aboveWaterRolls = luckySevens.rolls;
        luckySevens.aboveWaterValue = amount;
      }
    }
    System.out.println("\nYou are broke after " + luckySevens.rolls + " rolls.");
    System.out.println("You should have quit after " + luckySevens.aboveWaterRolls +
            " rolls when you had $" + luckySevens.aboveWaterValue + ".");
  }
}
