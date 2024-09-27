package org.example;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class DVDDAO implements DVDLibrary {
  private Map<String, DVD> dvdMap; // Collection of DVDs

  public DVDDAO() {
    dvdMap = new HashMap<>();
  }

  // Method to add a DVD to the collection
  @Override
  public void addDVD(DVD dvd) {
    dvdMap.put(dvd.getTitle(), dvd);
    System.out.println("DVD added: " + dvd.getTitle());
  }

  // Method to remove a DVD from the collection
  @Override
  public void removeDVD(String title) {
    if (dvdMap.remove(title) != null) {
      System.out.println("DVD removed: " + title);
    } else {
      System.out.println("DVD not found: " + title);
    }
  }

  // Method to edit the information for an existing DVD
  @Override
  public void editDVD(String title, DVD updatedDVD) {
    if (dvdMap.containsKey(title)) {
      if (!dvdMap.get(title).equals(updatedDVD.getTitle())) {
        updatedDVD.setTitle(title);
      }
      dvdMap.put(title, updatedDVD);
      System.out.println("DVD updated: " + updatedDVD.getTitle());
    } else {
      System.out.println("DVD not found: " + title);
    }
  }

  // Method to list all DVDs in the collection
  @Override
  public void listDVDs() {
    if (dvdMap.isEmpty()) {
      System.out.println("No DVDs in the collection.");
      return;
    }
    System.out.println("DVD Collection:");
    for (DVD dvd : dvdMap.values()) {
      System.out.println(dvd.toString());
    }
  }

  // Method to display information for a particular DVD
  @Override
  public void displayDVD(String title) {
    DVD dvd = dvdMap.get(title);
    if (dvd != null) {
      System.out.println(dvd);
    } else {
      System.out.println("DVD not found: " + title);
    }
  }

  // Method to search for a DVD by title
  @Override
  public void searchDVD(String title) {
    if (dvdMap.containsKey(title)) {
      System.out.println("DVD found: " + dvdMap.get(title));
    } else {
      System.out.println("DVD not found: " + title);
    }
  }

  // Method to load the DVD library from a file
  @Override
  public void loadFromFile(String filename) {
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");
        String title = parts[0].trim();
        LocalDate releaseDate = LocalDate.parse(parts[1].trim(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String mpaaRating = parts[2].trim();
        String directorName = parts[3].trim();
        String studio = parts[4].trim();
        String userRatingOrNote = parts[5].trim();

        DVD dvd = new DVD(title, releaseDate, mpaaRating, directorName, studio,
                Collections.singletonList(userRatingOrNote));
        addDVD(dvd);
      }
      System.out.println("DVD library loaded from " + filename);
    } catch (IOException e) {
      System.out.println("Error loading DVD library: " + e.getMessage());
    }
  }

  // Method to save the DVD library back to the file
  @Override
  public void saveToFile(String filename) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
      for (DVD dvd : dvdMap.values()) {
        writer.write(String.join(",",
                dvd.getTitle(),
                dvd.getReleaseDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")),
                dvd.getMpaaRating(),
                dvd.getDirectorName(),
                dvd.getStudio(),
                turingIntoString(dvd.getUserRatingOrNote())));
        writer.newLine();
      }
      System.out.println("DVD library saved to " + filename);
    } catch (IOException e) {
      System.out.println("Error saving DVD library: " + e.getMessage());
    }
  }

  private StringBuilder turingIntoString(List<String> userRatingOrNote) {
    StringBuilder stringBuilder = new StringBuilder();
    for (String note : userRatingOrNote) {
      stringBuilder.append(note + "\n");
    }
    return stringBuilder;
  }

  @Override
  public List<DVD> findMoviesByReleaseYear(int year) {
    List<DVD> movies = new ArrayList<>();
    LocalDate curDate = LocalDate.now();
    dvdMap.forEach((key, value) -> {
      if (value.getReleaseDate().isAfter(curDate.minusYears(year)) ||
              value.getReleaseDate().isEqual(curDate.minusYears(year))) {
        movies.add(value);
      }
    });
    return movies;
  }

  @Override
  public List<DVD> findMovesByMPAA(String mpaa) {
    List<DVD> movies = new ArrayList<>();
    dvdMap.forEach((key, value) -> {
      if (value.getMpaaRating().equals(mpaa)) {
        movies.add(value);
      }
    });
    return movies;
  }

  @Override
  public List<DVD> findMoviesByDirector(String directorName) {
    List<DVD> movies = new ArrayList<>();
    dvdMap.forEach((key, value) -> {
      if (value.getDirectorName().equals(directorName)) {
        movies.add(value);
      }
    });
    return movies;
  }

  @Override
  public List<DVD> findMoviesByStudio(String studio) {
    List<DVD> movies = new ArrayList<>();
    dvdMap.forEach((key, value) -> {
      if (value.getDirectorName().equals(studio)) {
        movies.add(value);
      }
    });
    return movies;
  }

  @Override
  public double findAverageAgeOfMovies() {
    if (dvdMap.isEmpty()) {
      return 0.00;
    }

    LocalDate curDate = LocalDate.now();
    int result = dvdMap.values().stream()
            .mapToInt(dvd -> (int) ChronoUnit.DAYS.between(dvd.getReleaseDate(), curDate)) // Get the difference in days
            .sum();
    return result / dvdMap.size();
  }

  @Override
  public double findAverageNumberOfNotes() {
    if (dvdMap.isEmpty()) {
      return 0.00;
    }

    int result = dvdMap.values().stream()
            .mapToInt(dvd -> dvd.getUserRatingOrNote().size())
            .sum();
    return result / dvdMap.size();
  }

  @Override
  public DVD newestMovie() {
    Collection<DVD> dvds = dvdMap.values();
    Optional<DVD> dvd = dvds.stream().min(Comparator.comparing(DVD::getReleaseDate));
    return dvd.get();
  }

  @Override
  public DVD oldestMovie() {
    Collection<DVD> dvds = dvdMap.values();
    Optional<DVD> dvd = dvds.stream().max(Comparator.comparing(DVD::getReleaseDate));
    return dvd.get();
  }

  public Map<String, DVD> getDvdMap() {
    return dvdMap;
  }
}