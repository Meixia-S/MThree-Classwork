package Dates;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;

public class BirthdayCalculator {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    LocalDate todaysDate = LocalDate.now();

    System.out.println("Welcome to the Magical BirthDAY Calculator!");
    System.out.println("What's your birthday? (MM/dd/yyyy)");

    LocalDate birthday = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    System.out.println("\nThat means you were born on a " + birthday.getDayOfWeek() + "!");

    int diffInYears = todaysDate.getYear() - birthday.getYear();
    LocalDate thisYearsBirthday = birthday.withYear(todaysDate.getYear());
    System.out.println("This year it falls on a " + thisYearsBirthday.getDayOfWeek() + "!");

    long daysUntilNextBirthday = ChronoUnit.DAYS.between(todaysDate, thisYearsBirthday.plusYears(1));
    System.out.println("Since today is " + todaysDate + ", there's only " + daysUntilNextBirthday + " more days until the next one!");
    System.out.println("Bet you are excited to be turning " + (diffInYears + (thisYearsBirthday.isEqual(todaysDate) ? 0 : 1)) + "!");
  }
}
