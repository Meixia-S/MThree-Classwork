package IO;

import java.util.ArrayList;

//  NOT NEEDED MADE BY MISTAKE  //
public class Student {

  ArrayList<Double> testScores = new ArrayList<>();
  String name;

  public Student(String name) {
    this.name = name;
  }

  public Student(String name, double firstScore) {
    this.testScores.add(firstScore);
    this.name = name;
  }

  private double calcAverageScore() {
    double result = 0.0;
    for (double score : testScores) {
      result += score;
    }

    try {
      return result / testScores.size();
    } catch (ArithmeticException e) {
      return 0.0;
    }
  }

  public double getAverage() {
    return calcAverageScore();
  }

  public String getName() {
    return name;
  }

  public String getTestScores() {
    String result = "";
    for (double score : testScores) {
      result += score + " ";
    }
    return result = this.name + " " + result;
  }

  public void addScore(double score) {
    testScores.add(score);
  }
}