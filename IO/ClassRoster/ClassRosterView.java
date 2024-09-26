package IO.ClassRoster;

import java.io.IOException;

import IO.UserIOLab;

public class ClassRosterView {
  private ClassRosterController classRosterController;
  private UserIOLab userIO = new UserIOLab();

  public void displayMenu() throws ClassRosterException, IOException {
    while (true) {
      userIO.print("\n----- Student Management Menu -----");
      userIO.print("1. Create Student");
      userIO.print("2. Display All Students");
      userIO.print("3. Display a Single Student");
      userIO.print("4. Remove Student");
      userIO.print("5. Update Student in Class Roster Audit");
      userIO.print("6. Exit");

      int choice = userIO.readInt("Enter your choice: ");
      classRosterController.run(choice);

      if (choice == 6) {
        return;
      }
    }
  }
}