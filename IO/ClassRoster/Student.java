package IO.ClassRoster;

public class Student {
  private String id;
  private String firstName;
  private String lastName;

  public Student(String id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  // Getters and Setters
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return "Student{" +
            "id='" + id + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }
}

// I know this is bad but this is practice and I did all this work :/

//  ArrayList<Double> testScores = new ArrayList<>();
//  String firstName;
//  String lastName:
//
//  public Student(String firstName, String lastName) {
//    this.firstName = firstName;
//    this.lastName = lastName;
//  }
//
//  public Student(String lastName, double firstScore) {
//    this.testScores.add(firstScore);
//    this.lastName = lastName;
//  }
//
//  private double calcAverageScore() {
//    double result = 0.0;
//    for (double score : testScores) {
//      result += score;
//    }
//
//    try {
//      return result / testScores.size();
//    } catch (ArithmeticException e) {
//      return 0.0;
//    }
//  }
//
//  public double getAverage() {
//    return calcAverageScore();
//  }
//
//  public String getLastName() {
//    return this.lastName;
//  }
//
//  public String getTestScores() {
//    String result = "";
//    for (double score : testScores) {
//      result += score + " ";
//    }
//    return result = this.firstName + " " + this.lastName + " " + result;
//  }
//
//  public void addScore(double score) {
//    testScores.add(score);
//  }