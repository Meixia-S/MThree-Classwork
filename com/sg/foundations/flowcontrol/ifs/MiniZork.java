package com.sg.foundations.flowcontrol.ifs;
import java.util.Scanner;

public class MiniZork {

  public static void main(String[] args) {



    System.out.println("You are standing in an open field west of a white house,");
    System.out.println("With a boarded front door.");
    System.out.println("There is a small mailbox here.");
    System.out.print("Break into the house, or open the mailbox, or go into the garden? ");
    Scanner userInput = new Scanner(System.in);
    String action = userInput.nextLine();

    if (action.equals("open the mailbox")) {
      System.out.println("You open the mailbox.");
      System.out.println("It's really dark in there.");
      System.out.print("Look inside or stick your hand in? ");
      action = userInput.nextLine();

      if (action.equals("look inside")) {
        System.out.println("You peer inside the mailbox.");
        System.out.println("It's really very dark. So ... so very dark.");
        System.out.print("Run away or keep looking? ");
        action = userInput.nextLine();

        if (action.equals("keep looking")) {
          System.out.println("Turns out, hanging out around dark places isn't a good idea.");
          System.out.println("You've been eaten by a grue.");
        } else if (action.equals("run away")) {
          System.out.println("You run away screaming across the fields - looking very foolish.");
          System.out.println("But you alive. Possibly a wise choice.");
        }
      } else if (action.equals("stick your hand in")) {
        System.out.println("Suddenly you've been eaten by a grue.");
      }
    } else if (action.equals("break into the house")) {
      System.out.print("Unlike the creepy mailbox in front of the house, the house itself is quite nice.");
      System.out.println("There is a door to the bedroom and a large window looking out to the garden");
      System.out.println("Which one do you want to open first? ");
      action = userInput.nextLine();

      if (action.equals("open the door")) {
        System.out.print("Sitting on the bed was a doll with red eyes. You look above at a small" +
                " hanging painting on the wall when the doll suddenly blinks. ");
        System.out.println("Do you kick the doll and smash it or pick it up? ");
        action = userInput.nextLine();

        if (action.equals("pick it up")) {
          System.out.println("Congrats you have now been cursed and will continue to be until you " +
                  "can get someone else to keep the creepy doll. Oof");
        } else if (action.equals("kick it")) {
          System.out.println("Good choice, you leave the house untouched. Years later it is torn" +
                  " down and a large new house is built in its place. Curse avoided for good.");
        }
      } else if (action.equals("open the window")) {
        System.out.println("The small garden had many vegetables growing with flowers on the " +
                "boarder. You think it is quite a lovely garden but who planted it?");
        System.out.println("Perhaps good things should be left alone, do you want to take some " +
                "of the vegetables or pick some of the flowers? ");
        action = userInput.nextLine();

        if (action.equals("yes")) {
          System.out.println("You climb out the window and start taking what you want. Suddenly " +
                  "the ground beneath you caves in and you fall into sink hole - never to be " +
                  "seen again.");
        } else {
          System.out.println("Good choice, you leave the house untouched. Years later it is torn" +
                  " down and a large new house is built in its place. Curse avoided for good.");
        }
      }
    } else {
      System.out.println("The small garden had many vegetables growing with flowers on the " +
              "boarder. You think it is quite a lovely garden but who planted it?");
      System.out.println("Perhaps good things should be left alone, do you want to take some " +
              "of the vegetables or pick some of the flowers? ");
      action = userInput.nextLine();

      if (action.equals("yes")) {
        System.out.println("You climb out the window and start taking what you want. Suddenly the" +
                " ground beneath you caves in and you fall into sink hole - never to be seen " +
                "again.");
      } else {
        System.out.println("Good choice, you leave the house untouched. Years later it is torn" +
                " down and a large new house is built in its place. Curse avoided for good.");
      }
    }
  }
}