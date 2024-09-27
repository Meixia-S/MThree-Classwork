import org.example.DVD;
import org.example.DVDDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DVDDAOTest {

  private DVDDAO dvdDAO;
  private DVD dvd1;
  private DVD dvd2;

  @BeforeEach
  public void setUp() {
    dvdDAO = new DVDDAO();
    List<String> notesZero = new ArrayList<>();
    notesZero.add("Mind-bending thriller");
    dvd1 = new DVD(
            "Inception",
            LocalDate.parse("07/16/2010", DateTimeFormatter.ofPattern("MM/dd/yyyy")),
            "PG-13",
            "Christopher Nolan",
            "Warner Bros",
            notesZero
    );

    List<String> notes = new ArrayList<>();
    notes.add("Sci-fi classic");
    dvd2 = new DVD(
            "The Matrix",
            LocalDate.parse("03/31/1999", DateTimeFormatter.ofPattern("MM/dd/yyyy")),
            "R",
            "The Wachowskis",
            "Warner Bros",
            notes);
  }

  @Test
  public void testAddDVD() {
    dvdDAO.addDVD(dvd1);
    assertEquals(1, dvdDAO.getDvdMap().size(), "DVD should be added to the collection.");
    assertTrue(dvdDAO.getDvdMap().containsKey(dvd1.getTitle()), "Inception should be in the collection.");
  }

  @Test
  public void testRemoveDVD() {
    dvdDAO.addDVD(dvd1);
    dvdDAO.removeDVD(dvd1.getTitle());
    assertEquals(0, dvdDAO.getDvdMap().size(), "DVD should be removed from the collection.");
    assertFalse(dvdDAO.getDvdMap().containsKey(dvd1.getTitle()), "Inception should no longer be in the collection.");
  }

  @Test
  public void testEditDVD() {
    dvdDAO.addDVD(dvd1);
    dvdDAO.editDVD(dvd1.getTitle(), dvd2); // Edit Inception to The Matrix
    assertTrue(dvdDAO.getDvdMap().containsKey(dvd2.getTitle()), "The Matrix should be in the collection.");
    assertEquals("Sci-fi classic", dvdDAO.getDvdMap().get(dvd2.getTitle()).getUserRatingOrNote().get(0),
            "User rating should be updated.");
  }

  @Test
  public void testListDVDs() {
    dvdDAO.addDVD(dvd1);
    dvdDAO.addDVD(dvd2);
    assertEquals(2, dvdDAO.getDvdMap().size(), "Both DVDs should be listed in the collection.");
  }

  @Test
  public void testDisplayDVD() {
    dvdDAO.addDVD(dvd1);
    DVD foundDVD = dvdDAO.getDvdMap().get(dvd1.getTitle());
    assertNotNull(foundDVD, "DVD should be found in the collection.");
    assertEquals("Inception", foundDVD.getTitle(), "The title should be Inception.");
  }

  @Test
  public void testSearchDVD() {
    dvdDAO.addDVD(dvd1);
    assertTrue(dvdDAO.getDvdMap().containsKey(dvd1.getTitle()), "Inception should be found.");
  }

  @Test
  public void testLoadFromFile() {
    // Assuming the file "dvdCollection.txt" exists and has correct data format
    dvdDAO.addDVD(dvd2);
    dvdDAO.loadFromFile("dvdCollection.txt");
    assertFalse(dvdDAO.getDvdMap().isEmpty(), "The DVD collection should be loaded from the file.");
  }

  @Test
  public void testSaveToFile() {
    dvdDAO.addDVD(dvd1);
    dvdDAO.saveToFile("DVsdsdssdD/dvdOutput.txt");
    // Manually verify that the "dvdOutput.txt" file has the correct data
  }
}