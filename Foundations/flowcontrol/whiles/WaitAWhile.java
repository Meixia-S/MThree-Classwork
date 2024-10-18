package Foundations.flowcontrol.whiles;

public class WaitAWhile {

  public static void main(String[] args) {

    int timeNow = 5;
    int bedTime = 10;

    while (timeNow < bedTime) {
      System.out.println("It's only " + timeNow + " o'clock!");
      System.out.println("I think I'll stay up just a liiiiittle longer....");
      timeNow++; // Time passes
    }

    System.out.println("Oh. It's " + timeNow + " o'clock.");
    System.out.println("Guess I should go to bed ...");
  }
}
/**
 * What happens if you change bedTime's value to 11?
 *    An extra lines where added moving bedtime to 11pm:
 *      It's only 10 o'clock!
 *      I think I'll stay up just a liiiiittle longer....
 *      Oh. It's 11 o'clock.
 *      Guess I should go to bed ...
 *
 * What about using bedTime's original value, but changing timeNow to 11?
 *    Result:
 *      Oh. It's 11 o'clock.
 *      Guess I should go to bed ...
 *
 * If you comment out timeNow++ at the end of the loop, what happens?
 *    An infinite loop since the condition statement will never be met.
 */