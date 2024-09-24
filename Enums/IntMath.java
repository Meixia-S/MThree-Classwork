package Enums;

import java.util.Scanner;

public class IntMath {

  public static void main (String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter Operator: ");
    String operator = scanner.nextLine();
    System.out.println("Enter Operand: ");
    int operandOne = scanner.nextInt();
    System.out.println("Enter Second Operand: ");
    int operandTwo = scanner.nextInt();
    System.out.println(calculate(MathOperator.valueOf(operator.toUpperCase()), operandOne, operandTwo));
  }

  public static int calculate(MathOperator operator, int operand1, int operand2) {
    switch(operator) {
      case PLUS:
        return operand1 + operand2;
      case MINUS:
        return operand1 - operand2;
      case MULTIPLY:
        return operand1 * operand2;
      case DIVIDE:
        return operand1 / operand2;
      default:
        throw new UnsupportedOperationException();
    }
  }
}