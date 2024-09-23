package Files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class StateCaps {

  public static void main(String[] args) {
    HashMap<String, String> map = new HashMap<>();

    try {
      Scanner scanner = new Scanner(new BufferedReader(new FileReader("Files/statecap.txt")));

      while (scanner.hasNextLine()) {
        String[] splitText = scanner.nextLine().split("::");
        map.put(splitText[0], splitText[1]);
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }

    System.out.println("50 STATES & CAPITALS ARE LOADED.\n=======\nHERE ARE THE STATES:\n");
    for (Map.Entry<String, String> entry : map.entrySet()) {
      System.out.println(entry.getKey() + ", ");
    }

    Random rand = new Random();
    Set<String> set = map.keySet();
    List<String> list = new ArrayList<>(set);
    int index = rand.nextInt(set.size());
    System.out.println("\nREADY TO TEST YOUR KNOWLEDGE? WHAT IS THE CAPITAL OF '"
                        + list.get(index) + "' ?");

    Scanner scan = new Scanner(System.in);
    String guess = scan.nextLine();
    if (guess.equals(map.get(list.get(index)))) {
      System.out.println("NICE WORK! Juneau IS CORRECT!");
    } else {
      System.out.println("Sorry that is Incorrect!");
    }
  }
}