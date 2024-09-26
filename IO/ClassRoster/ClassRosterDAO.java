package IO.ClassRoster;

import java.util.HashMap;

public class ClassRosterDAO implements ClassRosterI {
  HashMap<String, Student> studentMap = new HashMap<>();

  @Override
  public void createStudent(String id, String firstName, String lastName) {
    Student student = new Student(id, firstName, lastName);
    studentMap.put(lastName, student);
    System.out.println("Student added: " + student);
  }

  @Override
  public void displayAllStudents() {
    if (studentMap.isEmpty()) {
      System.out.println("No students to display.");
    } else {
      System.out.println("All Students:");
      studentMap.values().forEach(System.out::println);
    }
  }

  @Override
  public void displaySingleStudent(String lastName) throws ClassRosterException {
    Student student = studentMap.get(lastName);
    if (student != null) {
      System.out.println("Student Details: " + student);
    } else {
      throw new ClassRosterException("No student found with last name: " + lastName);
    }
  }

  @Override
  public void removeStudent(String lastName) throws ClassRosterException {
    Student removedStudent = studentMap.remove(lastName);
    if (removedStudent != null) {
      System.out.println("Student removed: " + removedStudent);
    } else {
      throw new ClassRosterException("No student found with last name: " + lastName);
    }
  }
}