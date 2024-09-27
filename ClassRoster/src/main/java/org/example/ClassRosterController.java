package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ClassRosterController {
  private ClassRosterServiceLayer classRosterServiceLayer;
  private ClassRosterView classRosterView;

  @Autowired
  public ClassRosterController(ClassRosterServiceLayer classRosterServiceLayer, ClassRosterView classRosterView) throws IOException {
    this.classRosterServiceLayer = classRosterServiceLayer;
    this.classRosterView = classRosterView;
  }

  public void run() throws ClassRosterException, IOException {
    int option;
    do {
      option = classRosterView.displayMenu();

      switch (option) {
        case 1:
          classRosterServiceLayer.createStudent();
          break;
        case 2:
          classRosterServiceLayer.displayAllStudents();
          break;
        case 3:
          classRosterServiceLayer.displaySingleStudent();
          break;
        case 4:
          classRosterServiceLayer.removeStudent();
          break;
        case 5:
          classRosterServiceLayer.updateStudentInRosterAudit();
          break;
        case 6:
          System.out.println("Exiting the program.");
          return;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    } while (option > 0 && option < 6);
  }
}