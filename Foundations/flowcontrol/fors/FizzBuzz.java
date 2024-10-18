package Foundations.flowcontrol.fors;

import java.io.File;
import java.util.Scanner;

public class FizzBuzz {

  public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);
    System.out.println("How many units of fizzing and buzzing do you need in your life?");
    int num = Integer.valueOf(userInput.nextLine());
    int counter = 0;

    for (int i = 0; i < num * 3; i ++) {
      if (counter >= num) {
        break;
      }

      if (i % 3 == 0 && i % 5 == 0 && i != 0) {
        System.out.println("fizz buzz");
        counter ++;
      } else if (i % 5 == 0 && i != 0) {
        System.out.println("buzz");
        counter ++;
      } else if (i % 3 == 0 && i != 0) {
        System.out.println("fizz");
        counter ++;
      } else {
        System.out.println(i);
      }
    }

    System.out.println("TRADITION!!!!!");
  }
}
