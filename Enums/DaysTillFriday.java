package Enums;

import java.util.Scanner;

public class DaysTillFriday {

  public static void main (String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter Day of Week: ");
    String day = scanner.nextLine();
    System.out.println(calculateDays(DaysOfWeek.valueOf(day.toUpperCase())));
  }

  public static int calculateDays(DaysOfWeek day) {
    switch(day) {
      case MONDAY:
        return 4;
      case TUESDAY:
        return 3;
      case WEDNESDAY:
        return 2;
      case THURSDAY:
        return 1;
      case FRIDAY:
        return 0;
      case SATURDAY:
        return 6;
      case SUNDAY:
        return 5;
      default:
        throw new UnsupportedOperationException();
    }
  }
}
