package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class DVDView {
  private Scanner scanner = new Scanner(System.in);
  private DVDController dvdController;

  @Autowired
  public DVDView(DVDController dvdController) {
    this.dvdController = dvdController;
  }

  public void run() {
    dvdController.dvddao.loadFromFile(dvdController.filename);

    while (true) {
      System.out.println("\nDVD Library Menu:");
      System.out.println("1. Add DVD");
      System.out.println("2. Remove DVD");
      System.out.println("3. Edit DVD");
      System.out.println("4. List DVDs");
      System.out.println("5. Display DVD");
      System.out.println("6. Search DVD");
      System.out.println("7. Save DVD Library");
      System.out.println("8. Find Movies by Release Year");
      System.out.println("9. Find Movies by MPAA Rating");
      System.out.println("10. Find Movies by Director");
      System.out.println("11. Find Movies by Studio");
      System.out.println("12. Find Average Age of Movies");
      System.out.println("13. Find Average Number of Notes");
      System.out.println("14. Find Newest Movie");
      System.out.println("15. Find Oldest Movie");
      System.out.println("16. Exit");
      System.out.print("Choose an option: ");

      int option = scanner.nextInt();
      scanner.nextLine();
      dvdController.run(option);

      if (option == 16) {
        return;
      }
    }
  }
}