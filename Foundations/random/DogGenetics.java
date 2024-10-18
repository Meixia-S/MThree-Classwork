package Foundations.random;

import java.util.Random;
import java.util.Scanner;

public class DogGenetics {
  private final Scanner userInput = new Scanner(System.in);
  private final Random rand = new Random();
  private final String[] breeds = {"St. Bernard", "Chihuahua", "Dramatic RedNosed Asian Pug", "Common Cur", "King Doberman"};
  private int percentLeft = 100;

  public static void main(String[] args) {
    DogGenetics DG = new DogGenetics();
    System.out.println("What is your dog's name? ");
    String name = DG.userInput.nextLine();
    System.out.println("\nWell then, I have this highly reliable report on " + name + "'s prestigious background right here.\n");
    System.out.println(name + " is:");

    for (int i = 0; i < 4; i ++) {
      int nextPercent = DG.rand.nextInt(DG.percentLeft);
      if (nextPercent == 0) {
        nextPercent = DG.rand.nextInt(DG.percentLeft);
      }
      System.out.println(nextPercent + "% " + DG.breeds[i]);
      DG.percentLeft -= nextPercent;
    }

    System.out.println(DG.percentLeft + "% " + DG.breeds[4]);
  }
}
