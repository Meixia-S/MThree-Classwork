package com.sg.foundations.flowcontrol.whiles;

import java.util.Random;

public class LazyTeenager {
  public static void main(String[] args) {
    Random rand = new Random();
    int chance = rand.nextInt(30);
    final int maxPatienceLevel = 7;
    int count = 1;

    do {
      System.out.println("Clean your room!! " + "(x" + count + ")");

      if (count >= maxPatienceLevel) {
        break;
      }

      chance += 10;
      count ++;
    } while (chance < 100);
    // Normally I would just do this (count <= maxPatienceLevel && chance < 100)

    if (count >= maxPatienceLevel) {
      System.out.println("Clean your room!! That's IT, I'm doing it!!! " +
              "YOU'RE GROUNDED AND I'M TAKING YOUR XBOX!");
    } else {
      System.out.println("FINE! I'LL CLEAN MY ROOM. BUT I REFUSE TO EAT MY PEAS.");
    }


  }
}
