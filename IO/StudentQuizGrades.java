package IO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

// Design is not the best - focused on functionality

public class StudentQuizGrades {

  public static void main(String[] args) {
    HashMap<String, ArrayList<Double>> map = new HashMap<>();
    UserIOLab userIO = new UserIOLab();
    String command = userIO.readString("--Menu--\nList all students [l]\nAdd a student [a]" +
                                                "\nRemove a student [r]" +
                                   "\nView list of all scores [va]\nView student test scores [vs]");

    if (command.equals("l")) {

      String result = "";
      for (Map.Entry<String, ArrayList<Double>> entry : map.entrySet()) {
        result += entry.getKey() + " ";
      }
      userIO.print(result);

    } else if (command.equals("a")) {
      String name = userIO.readString("Enter Name of Student");
      userIO.print("You now need to add each test score, press another key when you are done.");
      map.putIfAbsent(name, new ArrayList<>());
      while (true) {
        try {
          Double score = userIO.readDouble("Enter Another Test Score: ");
          map.get(name).add(score);
        } catch (InputMismatchException e) {
          break;
        }
      }

    } else if (command.equals("r")) {

      String name = userIO.readString("Enter Name of Student");
      map.remove(name);

    } else if (command.equals("va")) {

      String result = "";
      for (Map.Entry<String, ArrayList<Double>> entry : map.entrySet()) {
        for (double score : entry.getValue()) {
          result += score + " ";
        }
        result = entry.getKey() + " " + result;
      }
      userIO.print(result);

    } else if (command.equals("vs")) {

      String name = userIO.readString("Enter Name of Student");
      Double result = 0.00;
      for (double score : map.get(name)) {
        result += score;
      }

      if (result == 0.0) {
        userIO.print("No Scores to Average");
      } else {
        result /= map.get(name).size();
        userIO.print(String.valueOf(result));
      }

    } else {
      userIO.print("Invalid Option/Input");
    }
  }
}