package Files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StateCapitals3 {

  public static void main(String[] args) {
    HashMap<String, String[]> map = new HashMap<>();

    try {
      Scanner scanner = new Scanner(new BufferedReader(new FileReader("Files/morestatecapitals.txt")));

      while (scanner.hasNextLine()) {
        String[] splitText = scanner.nextLine().split("::");
        String[] values = {splitText[1], splitText[2], splitText[3]};
        map.put(splitText[0], values);
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }

    System.out.println("50 STATE/CAPITAL PAIRS LOADED.\n==============================");
    for (Map.Entry<String, String[]> entry : map.entrySet()) {
      System.out.println(entry.getKey() + " - "
              + entry.getValue()[0] + " | " + entry.getValue()[1] + " | " + entry.getValue()[2]);
    }

    Scanner scan = new Scanner(System.in);
    System.out.println("\nPlease enter the lower limit for capital city population: ");
    int pop =  scan.nextInt();
    System.out.println("LISTING CAPITALS WITH POPULATIONS GREATER THAN " + pop + ":");

    for (Map.Entry<String, String[]> entry : map.entrySet()) {
      if (Integer.valueOf(entry.getValue()[1]) > pop) {
        System.out.println(entry.getKey() + " - "
                + entry.getValue()[0] + " | " + entry.getValue()[1] + " | " + entry.getValue()[2]);
      }
    }

    System.out.println("\nPlease enter the upper limit for capital city sq mileage: ");
    double sqMilage =  scan.nextInt();
    System.out.println("\nLISTING CAPITALS WITH AREAS LESS THAN " + sqMilage + ":");

    for (Map.Entry<String, String[]> entry : map.entrySet()) {
      if (Double.valueOf(entry.getValue()[2]) < sqMilage) {
        System.out.println(entry.getKey() + " - "
                + entry.getValue()[0] + " | " + entry.getValue()[1] + " | " + entry.getValue()[2]);
      }
    }
  }
}