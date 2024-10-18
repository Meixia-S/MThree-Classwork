package Foundations.variables;

public class InABucket {

  public static void main(String[] args) {

    // You can declare all KINDS of variables.
    String walrus;
    double piesEaten;
    float weightOfTeacupPig;
    int grainsOfSand;

    // But declaring them just sets up the space for data
    // to use the variable, you have to put data IN it first!
    walrus = "Sir Leroy Jenkins III";
    piesEaten = 42.1;

    System.out.println("Meet my pet walrus, " + walrus);
    System.out.print("He was a bit hungry today, and ate this many pies : ");
    System.out.println(piesEaten);
  }
}

/**
 * Note the use of "=" here. How is it different from "=="?
 *  "=" assigns whatever is on the left side to whatever is on the right side.
 *    ex: num = 3 -> num now equals 3
 *  "==" is checking to see if the value on the left side is equal to the value on the right side
 *
 * What about the use of "+"? How can we add strings of text together and what is the result?
 *  "+" symbol can be used to concatenate two string together
 *  a space needs to be added to the string on the left or right of the symbol to have the correct
 *  readable format
 */