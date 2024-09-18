package com.sg.foundations.basics.methods;

import java.util.Random;

public class BarelyControlledChaos {
  private final String[] colors = {"red", "blue", "green", "yellow", "orange", "purple"};
  private final String[] animals = {"dog", "cat", "horse", "rabbit", "wolf", "hawk"};
  private Random random = new Random();
  private int RAND_NUM;


  public static void main(String[] args) {
    BarelyControlledChaos bCC = new BarelyControlledChaos();

    String color = bCC.colors(); // call color method here
    String animal = bCC.animals(); // call animal method again here
    String colorAgain = bCC.colors(); // call color method again here
    int weight = bCC.randomNumWithRange(5, 200); // call number method,
      // with a range between 5 - 200
    int distance = bCC.randomNumWithRange(10, 20); // call number method,
      // with a range between 10 - 20
    int number = bCC.randomNumWithRange(10000, 20000); // call number method,
      // with a range between 10000 - 20000
    int time = bCC.randomNumWithRange(2, 6); // call number method,
      // with a range between 2 - 6

    System.out.println("Once, when I was very small...");

    System.out.println("I was chased by a " + color + ", "
            + weight + "lb " + " miniature " + animal
            + " for over " + distance + " miles!!");

    System.out.println("I had to hide in a field of over "
            + number + " " + colorAgain + " poppies for nearly "
            + time + " hours until it left me alone!");

    System.out.println("\nIt was QUITE the experience, "
            + "let me tell you!");
  }

  private String colors() {
    RAND_NUM = random.nextInt(6);
    return colors[RAND_NUM];
  }
  private String animals() {
    RAND_NUM = random.nextInt(6);
    return animals[RAND_NUM];
  }

  private int randomNumWithRange(int min, int max) {
    RAND_NUM = random.nextInt((max - min) + 1) + min;
    return RAND_NUM;
  }
}