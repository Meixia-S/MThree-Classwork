package com.sg.foundations.variables;

import java.util.Scanner;

public class BestAdderEver {
  public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);
    System.out.println("Input an integer");
    int a = Integer.valueOf(userInput.nextLine());
    System.out.println("Input an other integer");
    int b = Integer.valueOf(userInput.nextLine());
    System.out.println("Input the final integer");
    int c = Integer.valueOf(userInput.nextLine());

    int total = a + b + c;
    System.out.println(a + " + " + b + " + " + c + " = " + total);
  }
}
