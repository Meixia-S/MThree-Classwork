package com.sg.foundations.userinput;

import java.util.Scanner;

public class MiniMadLibs {
  public static void main(String[] args) {
    Scanner inputReader = new Scanner(System.in);
    System.out.println("Let's play MAD LIBS!");
    System.out.println("I need a noun (Cap):");
    String nounOne = inputReader.nextLine();
    System.out.println("Now an adjective:");
    String adjectiveOne = inputReader.nextLine();
    System.out.println("Another noun:");
    String nounTwo = inputReader.nextLine();
    System.out.println("And a number:");
    String num = inputReader.nextLine();
    System.out.println("Another adjective (color):");
    String adjectiveTwo = inputReader.nextLine();
    System.out.println("A plural noun:");
    String pluralNounOne = inputReader.nextLine();
    System.out.println("Another one:");
    String pluralNounTwo = inputReader.nextLine();
    System.out.println("One more:");
    String pluralNounThree = inputReader.nextLine();
    System.out.println("A verb (infinitive form):");
    String verbOne = inputReader.nextLine();
    System.out.println("Same verb (past participle):");
    String verbTwo = inputReader.nextLine();

    System.out.println("*** NOW LETS GET MAD (libs) ***");
    System.out.println(nounOne + ": the " + adjectiveOne + " frontier. These are the voyages of " +
            "the starship " + nounTwo + ". Its " + num + "-year mission: to explore strange " +
            adjectiveTwo + " " + pluralNounOne + ", to seek out " + adjectiveTwo + " " +
            pluralNounTwo + ", " + adjectiveTwo + " " + pluralNounThree + ", to boldly " + verbOne +
            " where no one has " + verbTwo + " before.");
  }
}