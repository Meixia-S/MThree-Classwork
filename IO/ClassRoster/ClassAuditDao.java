package IO.ClassRoster;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassAuditDao {
  private static final String AUDIT_FILE_PATH = "ClassRoster/StudentRosterAudit.txt";
  private PrintWriter printWriter;
  private Scanner scanner;

  // Constructor
  public ClassAuditDao() throws IOException {
    // Initialize resources
    this.printWriter = new PrintWriter(new FileWriter(AUDIT_FILE_PATH, true));
    this.scanner = new Scanner(new BufferedReader(new FileReader(AUDIT_FILE_PATH)));
  }

  // Method to add a student to the audit file
  public void addStudentToAudit(Student student) {
    printWriter.println(student.toString()); // Add a new line for clarity
    printWriter.flush(); // Ensure the data is written
  }

  // Method to remove a student from the audit file
  public void removeStudentToAudit(Student student) throws IOException {
    List<String> allStudents = new ArrayList<>();

    // Read all lines and store in a list except the line to be removed
    while (scanner.hasNextLine()) {
      String currentLine = scanner.nextLine();
      if (!currentLine.equals(student.toString())) {
        allStudents.add(currentLine);
      }
    }

    // Rewrite the file without the removed student
    rewriteAuditFile(allStudents);
  }

  // Method to update a student's information in the audit file
  public void updateStudentToAudit(Student student) throws IOException {
    List<String> allStudents = new ArrayList<>();
    String studentToUpdate = student.getFirstName() + "::" + student.getLastName() + "::" + student.getId();

    // Read all lines and update the specific student's line
    while (scanner.hasNextLine()) {
      String currentLine = scanner.nextLine();
      if (currentLine.equals(studentToUpdate)) {
        allStudents.add(student.toString()); // Add updated student info
      } else {
        allStudents.add(currentLine); // Keep other lines unchanged
      }
    }

    // Rewrite the file with the updated student information
    rewriteAuditFile(allStudents);
  }

  // Helper method to rewrite the audit file with updated content
  private void rewriteAuditFile(List<String> allStudents) throws IOException {
    // Close the previous PrintWriter
    printWriter.close();

    // Write all the updated lines back to the audit file
    try (PrintWriter writer = new PrintWriter(new FileWriter(AUDIT_FILE_PATH))) {
      for (String studentRecord : allStudents) {
        writer.println(studentRecord);
      }
    }
  }

  // Method to close resources safely when done
  public void closeResources() throws IOException {
    if (scanner != null) {
      scanner.close();
    }
    if (printWriter != null) {
      printWriter.close();
    }
  }
}