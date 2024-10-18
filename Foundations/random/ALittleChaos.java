package Foundations.random;

import java.util.Random;

public class ALittleChaos {

  public static void main(String[] args) {

    Random randomizer = new Random();

    System.out.println("Random can make integers: " + randomizer.nextInt());
    System.out.println("Or a double: " + randomizer.nextDouble());
    System.out.println("Or even a boolean: " + randomizer.nextBoolean());

    int num = randomizer.nextInt(100);

    System.out.println("You can store a randomized result: " + num);
    System.out.println("And use it over and over again: " + num + ", " + num);

    System.out.println("Or just keep generating new values");
    System.out.println("Here's a bunch of numbers from 0 - 100: ");

    System.out.print(randomizer.nextInt(51) + 50 + ", ");
    System.out.print(randomizer.nextInt(51) + 50 + ", ");
    System.out.print(randomizer.nextInt(51) + 50 + ", ");
    System.out.print(randomizer.nextInt(51) + 50 + ", ");
    System.out.print(randomizer.nextInt(51) + 50 + ", ");
    System.out.println(randomizer.nextInt(51) + 50);
  }
}

/**
 * What happens if you change randomizer.Next(101) to randomizer.Next(51) + 50?
 *    Not much changes as the randomized number plus 50 will never go above 100.
 *
 * Can you include random numbers in a math statement?
 *    Yes, however the result of the statement will be random.
 *
 * Experiment with different number types to see what the outcomes look like.
 *    Inputting a negative number throws an IllegalArgumentException error
 *    Inputting 0 also throws an IllegalArgumentException error
 *    Inputting nothing sometimes results in a negative number
 *    Inputting an int that is too large results in an Integer Overflow Error
 */