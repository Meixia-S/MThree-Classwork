package DVD;

import java.time.LocalDate;

public class DVD {
  private String title;
  private LocalDate releaseDate;
  private String mpaaRating;
  private String directorName;
  private String studio;
  private String userRatingOrNote;

  // Constructor
  public DVD (String title, LocalDate releaseDate, String mpaaRating, String directorName, String studio, String userRatingOrNote) {
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

  public String getUserRatingOrNote() {
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

  public void setUserRatingOrNote(String userRatingOrNote) {
    this.userRatingOrNote = userRatingOrNote;
  }

  @Override
  public String toString() {
    return "Movie{" +
            "title='" + title + '\'' +
            ", releaseDate=" + releaseDate +
            ", mpaaRating='" + mpaaRating + '\'' +
            ", directorName='" + directorName + '\'' +
            ", studio='" + studio + '\'' +
            ", userRatingOrNote='" + userRatingOrNote + '\'' +
            '}';
  }
}
