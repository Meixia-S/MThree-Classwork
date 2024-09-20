package SimpleCalcuator;

import java.util.InputMismatchException;

public class SimpleCalculator {

  public int calculate(int a, int b, String operation) {
    int result = 0;

    if (operation.equals("-")) {
      result = a - b;
    } else if (operation.equals("+")) {
      result = a + b;
    } else if (operation.equals("*")) {
      result = a * b;
    } else if (operation.equals("/")) {
      result = a / b;
    } else {
      throw new InputMismatchException("Invalid Operation");
    }
    return result;
  }
}
