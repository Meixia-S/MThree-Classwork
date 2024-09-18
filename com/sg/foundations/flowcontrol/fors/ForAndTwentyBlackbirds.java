package com.sg.foundations.flowcontrol.fors;

public class ForAndTwentyBlackbirds {

  public static void main(String[] args) {
    int birdsInPie = 0;
    for (int i = 1; i <= 24; i++) {
      System.out.println("Blackbird #" + i + " goes into the pie!");
      birdsInPie++;
    }

    System.out.println("There are " + birdsInPie + " birds in there!");
    System.out.println("Quite the pie full!");
  }
}

/**
 * Also update the bird number printouts so the count is from 1 to 24. What did you change?
 *   I chanced two parts of the for loop:
 *     1) I changed i = 0 to i = 1 since that variable is used in the print statement.
 *     2) Since the loop will only run 23 times I changed the < sign to <= to ensure it run 24 times.
 */