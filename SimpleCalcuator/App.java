package SimpleCalcuator;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);
    do {
      System.out.println("\nWhat Operation do You Want to Use? ");
      System.out.println("-, +, *, /, or exit");
      String operation = userInput.nextLine();

      if (operation.equals("exit")) {
        break;
      }

      System.out.println("What are The Two Operands? ");
      int a = userInput.nextInt();
      int b = userInput.nextInt();
      userInput.nextLine(); // Consume the leftover newline from nextInt

      SimpleCalculator simpleCalculator = new SimpleCalculator();
      System.out.println("------------------------------------\n"
              + simpleCalculator.calculate(a, b, operation)
              + "\n------------------------------------");

    } while (true);
    System.out.println("Thank You for Using The Program!");
  }
}