package com.sg.foundations.basics.arrays;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SummativeSums {
  public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);
    System.out.println("Please input an array (String format): ");
    int sum = addAllElements(userInput.nextLine());
    System.out.println("\nArray Sum: " + sum);
  }

  private static int addAllElements(String array) {
    int total = 0;
    Pattern pattern = Pattern.compile("-?\\d+");
    Matcher matcher = pattern.matcher(array);

    while (matcher.find()) {
      total += Integer.valueOf(matcher.group());
    }

    return total;
  }
}