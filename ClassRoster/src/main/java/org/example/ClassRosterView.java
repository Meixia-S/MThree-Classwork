package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassRosterView {
  public UserIOLab userIO;

  @Autowired
  public ClassRosterView(UserIOLab userIO) {
    this.userIO = userIO;
  }

  public int displayMenu() {
    userIO.print("\n----- Student Management Menu -----");
    userIO.print("1. Create Student");
    userIO.print("2. Display All Students");
    userIO.print("3. Display a Single Student");
    userIO.print("4. Remove Student");
    userIO.print("5. Update Student in Class Roster Audit");
    userIO.print("6. Exit");

    int choice = userIO.readInt("Enter your choice: ");
    return(choice);
  }
}