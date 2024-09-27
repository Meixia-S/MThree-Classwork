package org.example;

import java.time.LocalDate;
import java.util.List;

public class DVD {
  private String title;
  private LocalDate releaseDate;
  private String mpaaRating;
  private String directorName;
  private String studio;
  private List<String> userRatingOrNote;

  // Constructor
  public DVD (String title, LocalDate releaseDate, String mpaaRating, String directorName, String studio, List<String> userRatingOrNote) {
    this.title = title;
    this.releaseDate = releaseDate;
    this.mpaaRating = mpaaRating;
    this.directorName = directorName;
    this.studio = studio;
    this.userRatingOrNote = userRatingOrNote;
  }

  public String getTitle() {
    return title;
  }

  public LocalDate getReleaseDate() {
    return releaseDate;
  }

  public String getMpaaRating() {
    return mpaaRating;
  }

  public String getDirectorName() {
    return directorName;
  }

  public String getStudio() {
    return studio;
  }

  public List<String> getUserRatingOrNote() {
    return userRatingOrNote;
  }

  // Setters
  public void setTitle(String title) {
    this.title = title;
  }

  public void setReleaseDate(LocalDate releaseDate) {
    this.releaseDate = releaseDate;
  }

  public void setMpaaRating(String mpaaRating) {
    this.mpaaRating = mpaaRating;
  }

  public void setDirectorName(String directorName) {
    this.directorName = directorName;
  }

  public void setStudio(String studio) {
    this.studio = studio;
  }

  public void addUserRatingOrNote(String userRatingOrNote) {
    this.userRatingOrNote.add(userRatingOrNote);
  }

  @Override
  public String toString() {
    return "Movie{" +
            "title='" + title + '\'' +
            ", releaseDate=" + releaseDate +
            ", mpaaRating='" + mpaaRating + '\'' +
            ", directorName='" + directorName + '\'' +
            ", studio='" + studio + '\'' +
            ", userRatingOrNote='" + turingIntoString(userRatingOrNote) + '\'' +
            '}';
  }

  private StringBuilder turingIntoString(List<String> userRatingOrNote) {
    StringBuilder stringBuilder = new StringBuilder();
    for (String note : userRatingOrNote) {
      stringBuilder.append(note + "\n");
    }
    return stringBuilder;
  }
}