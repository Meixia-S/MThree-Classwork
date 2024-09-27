package org.example;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UserIOLab implements UserIO {
  private Scanner userInput = new Scanner(System.in);

  @Override
  public void print(String message) {
    System.out.println(message);
  }

  @Override
  public String readString(String prompt) {
    System.out.println(prompt);
    return  userInput.nextLine();
  }

  @Override
  public int readInt(String prompt) {
    System.out.println(prompt);
    return userInput.nextInt();
  }

  @Override
  public int readInt(String prompt, int min, int max) {
    int result;

    while (true) {
      System.out.println(prompt);
      result = userInput.nextInt();
      if (result >= min || result <= max) {
        break;
      }
    }
    return result;
  }

  @Override
  public double readDouble(String prompt) {
    System.out.println(prompt);
    return userInput.nextDouble();
  }

  @Override
  public double readDouble(String prompt, double min, double max) {
    double result;

    while (true) {
      System.out.println(prompt);
      result = userInput.nextDouble();
      if (result >= min || result <= max) {
        break;
      }
    }
    return result;
  }

  @Override
  public float readFloat(String prompt) {
    System.out.println(prompt);
    return userInput.nextFloat();
  }

  @Override
  public float readFloat(String prompt, float min, float max) {
    float result;

    while (true) {
      System.out.println(prompt);
      result = userInput.nextFloat();
      if (result >= min || result <= max) {
        break;
      }
    }
    return result;
  }

  @Override
  public long readLong(String prompt) {
    System.out.println(prompt);
    return userInput.nextLong();
  }

  @Override
  public long readLong(String prompt, long min, long max) {
    long result;

    while (true) {
      System.out.println(prompt);
      result = userInput.nextLong();
      if (result >= min || result <= max) {
        break;
      }
    }
    return result;
  }
}
