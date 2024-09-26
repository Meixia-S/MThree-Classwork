package IO.ClassRoster;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Map;

import IO.UserIOLab;

public class ClassRosterServiceLayer {
  public ClassRosterDAO classRosterDAO = new ClassRosterDAO();
  public ClassAuditDao classAuditDao = new ClassAuditDao();

  private UserIOLab userIO = new UserIOLab();

  public ClassRosterServiceLayer() throws IOException {
  }

  // Method to create a student with user input
  public void createStudent() {
    String id;
    String firstName;
    String lastName;

    try {
      id = userIO.readString("Enter Student ID: ");
      firstName = userIO.readString("Enter First Name: ");
      lastName = userIO.readString("Enter Last Name: ");
    } catch (InputMismatchException e) {
      userIO.print("Must Input Strings, try Again ");
      return;
    }

    classRosterDAO.createStudent(id, firstName, lastName);
    classAuditDao.addStudentToAudit(classRosterDAO.studentMap.get(lastName));
  }

  // Method to display a single student with user input
  public void displaySingleStudent() throws ClassRosterException {
    String lastName = userIO.readString("Enter Last Name of the Student: ");
    classRosterDAO.displaySingleStudent(lastName);
  }

  public void displayAllStudents() throws ClassRosterException {
    String lastName = userIO.readString("All Students: ");
    for (Map.Entry<String, Student> entry : classRosterDAO.studentMap.entrySet()) {
      userIO.print(entry.toString());
    }
  }

  // Method to remove a student with user input
  public void removeStudent() throws ClassRosterException {
    String lastName = userIO.readString("Enter Last Name of the Student to Remove: ");
    classAuditDao.addStudentToAudit(classRosterDAO.studentMap.get(lastName));
    classRosterDAO.removeStudent(lastName);
  }

  public void updateStudentInRosterAudit() throws IOException {
    String id;
    String firstName;
    String lastName;

    try {
      id = userIO.readString("Enter NEW Student ID: ");
      firstName = userIO.readString("Enter NEW First Name: ");
      lastName = userIO.readString("Enter OLD Last Name: ");
    } catch (InputMismatchException e) {
      userIO.print("Must Input Strings, try Again ");
      return;
    }
    Student newStudent = new Student(firstName, lastName, id);
    classAuditDao.updateStudentToAudit(newStudent);
  }
}