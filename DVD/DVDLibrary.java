package DVD;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface DVDLibrary {

  // Method to add a DVD to the collection
  public void addDVD(DVD dvd);

  // Method to remove a DVD from the collection
  public void removeDVD(String title);

  // Method to edit the information for an existing DVD
  public void editDVD(String title, DVD updatedDVD);

  // Method to list all DVDs in the collection
  public void listDVDs();
  // Method to display information for a particular DVD
  public void displayDVD(String title);

  // Method to search for a DVD by title
  public void searchDVD(String title);

  // Method to load the DVD library from a file
  public void loadFromFile(String filename);

  // Method to save the DVD library back to the file
  public void saveToFile(String filename);

  // Find all movies released in the last N years
  public List<DVD> findMoviesByReleaseYear(int years);

  // Find all the movies by a given MPAA rating
  public List<DVD> findMovesByMPAA(String mpaa);

  // Find all the movies by a given director
  // When searching by director, the movies should be sorted into separate data structures by MPAA rating.
  public List<DVD> findMoviesByDirector(String directorName);

  // Find all the movies released by a particular studio
  public List<DVD> findMoviesByStudio(String studio);

  // Find the average age of the movies in the collection
  public double findAverageAgeOfMovies();

  // Find the average number of notes associated with movies in your collection
  public double findAverageNumberOfNotes();

  // Find the newest movie in your collection
  public DVD newestMovie();

  // Find the oldest movie in your collection
  public DVD oldestMovie();
}