package Maps;

import java.util.HashMap;
import java.util.Map;

public class StateCapitals {
  HashMap<String, String> stateCaps = new HashMap<>();

  public static void main(String[] args) {
    StateCapitals stateCapitals = new StateCapitals();
    stateCapitals.intro();

    System.out.println("STATES: \n=======");
    for (Map.Entry<String, String> entry : stateCapitals.stateCaps.entrySet()) {
      System.out.println(entry.getKey());
    }

    System.out.println("\n\nCAPITALS: \n=========");
    for (Map.Entry<String, String> entry : stateCapitals.stateCaps.entrySet()) {
      System.out.println(entry.getValue());
    }

    System.out.println("\n\nSTATE/CAPITAL PAIRS: \n====================");
    for (Map.Entry<String, String> entry : stateCapitals.stateCaps.entrySet()) {
      System.out.println(entry.getKey() + " - " + entry.getValue());
    }
  }

  private void intro () {
    stateCaps.put("Alaska", "Juneau");
    stateCaps.put("Arizona", "Phoenix");
    stateCaps.put("Arkansas" , "Little Rock");
    stateCaps.put("California", "Sacramento");
    stateCaps.put("Colorado", "Denver");
    stateCaps.put("Connecticut" , "Hartford");
    stateCaps.put("Delaware", "Dover");
    stateCaps.put("Florida", "Tallahassee");
    stateCaps.put("Georgia" , "Atlanta");
    stateCaps.put("Hawaii", "Honolulu");
    stateCaps.put("Idaho", "Boise");
    stateCaps.put("Illinois" , "Springfield");
    stateCaps.put("Indiana", "Indianapolis");
    stateCaps.put("Iowa", "Des Moines");
    stateCaps.put("Kansas" , "Topeka");
    stateCaps.put("Kentucky", "Frankfort");
    stateCaps.put("Louisiana", "Baton Rouge");
    stateCaps.put("Maine" , "Augusta");
  }
}
