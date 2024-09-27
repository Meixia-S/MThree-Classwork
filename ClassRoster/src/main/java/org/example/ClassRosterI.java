package org.example;

public interface ClassRosterI {
  void createStudent(String id, String firstName, String lastName);

  void displayAllStudents();

  void displaySingleStudent(String lastName) throws ClassRosterException;

  void removeStudent(String lastName) throws ClassRosterException;
}