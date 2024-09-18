package com.sg.foundations.userinput;

import java.util.Scanner;

public class HealthyHearts {

  public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);
    System.out.println("Hello, what is your age? ");
    int age = userInput.nextInt();
    int maxHeartRate = 220 - age;
    System.out.println("Your maximum heart rate should be " + maxHeartRate + " beats per minute");
    System.out.println("Your target HR Zone is " +
            (maxHeartRate * .50) + " - " + (maxHeartRate * 0.85) + " beats per minute");
  }
}
