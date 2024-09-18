package com.sg.foundations;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
  private HashMap<String, Integer> map = new HashMap<>();
  private final Random rand = new Random();
  private final Scanner userInput = new Scanner(System.in);
  int rounds;
  public static void main(String[] args) {
    RockPaperScissors RPS = new RockPaperScissors();
    String answer = "yes";

    do {
      RPS.setup();

      if (RPS.rounds < 0 || RPS.rounds > 11) {
        System.out.println("Error: Invalid Number of Rounds");
        return;
      }

      System.out.println("1 = Rock, 2 = Paper, 3 = Scissor");
      RPS.rounds();

      System.out.println("\nTies: " + RPS.map.get("tie"));
      System.out.println("Your Win Count: " + RPS.map.get("player"));
      System.out.println("Computer's Win Count: " + RPS.map.get("computer"));

      if (RPS.map.get("player") >= RPS.map.get("computer")) {
        System.out.println("** You are the Overall Winner! Good Job! **");
      } else {
        System.out.println("The computer is the Overall Winner!");
      }

      RPS.userInput.nextLine();
      System.out.println("\nTry Again? (yes/y to continue): ");
      answer = RPS.userInput.nextLine().toLowerCase();
      System.out.println("\n");

    } while (answer.equals("yes") || answer.equals("y"));

    System.out.println("Thank you for playing!");
  }

  private void rounds() {
    for (int i = 1; i <= rounds; i++) {
      System.out.println("\nYour Turn!");
      int turn = userInput.nextInt();
      int computerTurn = rand.nextInt(3);
      System.out.println("Computer's Turn: " + (computerTurn + 1));

      if ((turn == 1 && computerTurn == 2) || (turn == 2 && computerTurn == 0)
              || (turn == 3 && computerTurn == 1)) {
        map.put("player", map.get("player") + 1);
      } else if ((turn == 1 && computerTurn == 1) || (turn == 2 && computerTurn == 2)
              || (turn == 3 && computerTurn == 0)) {
        map.put("computer", map.get("computer") + 1);
      } else {
        map.put("tie", map.get("tie") + 1);
      }
    }
  }

  public void setup() {
    map.put("tie", 0);
    map.put("player", 0);
    map.put("computer", 0);

    System.out.println("How many rounds do you want to play (1- 10)?");
    rounds = userInput.nextInt();
    System.out.println("\n");
  }
}
