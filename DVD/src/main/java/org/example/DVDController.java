package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.List;

@Component
public class DVDController {
  public DVDDAO dvddao = new DVDDAO();
  private Scanner scanner = new Scanner(System.in);
  public String filename = "DVsdsdssdD/dvdLibrary.txt"; // File to save/load DVDs
  private List<DVD> movies = new ArrayList<>();

  @Autowired
  public DVDController(DVDDAO dvddao) {
    this.dvddao = dvddao;
  }

  public void run(int option) {
    switch (option) {
      case 1: // Add DVD
        System.out.println("Enter DVD details (Title, Release Date (MM/dd/yyyy), MPAA Rating, " +
                "Director's Name, Studio, User Rating/Note):");
        String[] details = scanner.nextLine().split(","); // Expecting comma-separated values
        LocalDate releaseDate = LocalDate.parse(details[1].trim(),
                DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        DVD newDVD = new DVD(details[0].trim(), releaseDate, details[2].trim(), details[3].trim(),
                details[4].trim(), Collections.singletonList(details[5].trim()));
        dvddao.addDVD(newDVD);
        break;
      case 2: // Remove DVD
        System.out.print("Enter the title of the DVD to remove: ");
        String titleToRemove = scanner.nextLine();
        dvddao.removeDVD(titleToRemove);
        break;
      case 3: // Edit DVD
        System.out.print("Enter the title of the DVD to edit: ");
        String titleToEdit = scanner.nextLine();
        System.out.println("Enter new DVD details (Title, Release Date (MM/dd/yyyy), " +
                "MPAA Rating, Director's Name, Studio, User Rating/Note):");
        String[] editDetails = scanner.nextLine().split(",");
        LocalDate newReleaseDate = LocalDate.parse(editDetails[1].trim(),
                DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        DVD updatedDVD = new DVD(editDetails[0].trim(), newReleaseDate, editDetails[2].trim(),
                editDetails[3].trim(), editDetails[4].trim(),
                Collections.singletonList(editDetails[5].trim()));
        dvddao.editDVD(titleToEdit, updatedDVD);
        break;
      case 4: // List DVDs
        dvddao.listDVDs();
        break;
      case 5: // Display DVD
        System.out.print("Enter the title of the DVD to display: ");
        String titleToDisplay = scanner.nextLine();
        dvddao.displayDVD(titleToDisplay);
        break;
      case 6: // Search DVD
        System.out.print("Enter the title of the DVD to search: ");
        String titleToSearch = scanner.nextLine();
        dvddao.searchDVD(titleToSearch);
        break;
      case 7: // Save DVD Library
        dvddao.saveToFile(filename);
        break;
      case 8:
        System.out.print("Enter the release date you want to search by: ");
        int year = scanner.nextInt();
        movies = dvddao.findMoviesByReleaseYear(year);
        printMovieList();
        movies.clear();
        break;
      case 9:
        System.out.print("Enter the MPAA rating you want to search by: ");
        String mppaRating = scanner.nextLine();
        movies = dvddao.findMovesByMPAA(mppaRating);
        printMovieList();
        movies.clear();
        break;
      case 10:
        System.out.print("Enter the name of the director you want to search by: ");
        String director = scanner.nextLine();
        movies = dvddao.findMoviesByDirector(director);
        printMovieList();
        movies.clear();
        break;
      case 11:
        System.out.print("Enter the name of the studio you want to search by: ");
        String studio = scanner.nextLine();
        movies = dvddao.findMoviesByStudio(studio);
        printMovieList();
        movies.clear();
        break;
      case 12:
        System.out.print("The average age of movies is: " + dvddao.findAverageAgeOfMovies());
        break;
      case 13:
        System.out.print("The average number of notes per movie is: "
                + dvddao.findAverageNumberOfNotes());
        break;
      case 14:
        System.out.print("The newest movie is: " + dvddao.newestMovie().toString());
        break;
      case 15:
        System.out.print("The oldest movie is: " +  dvddao.oldestMovie().toString());
        break;
      case 16:
        dvddao.saveToFile(filename); // Save on exit
        System.out.println("Exiting...");
        scanner.close();
        return;
      default:
        System.out.println("Invalid option. Please try again.");
    }
  }

  private void printMovieList(){
    System.out.println("==================================");
    for (DVD dvd : movies) {
      dvd.toString();
    }
  }
}