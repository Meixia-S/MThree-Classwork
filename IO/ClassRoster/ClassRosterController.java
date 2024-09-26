package IO.ClassRoster;

import java.io.IOException;
import java.util.InputMismatchException;

import IO.UserIOLab;

public class ClassRosterController {
  ClassRosterServiceLayer classRosterServiceLayer = new ClassRosterServiceLayer();

  public ClassRosterController() throws IOException {
  }

  public void run(int option) throws ClassRosterException, IOException {
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
  }
}