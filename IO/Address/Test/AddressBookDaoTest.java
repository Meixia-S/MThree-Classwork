package IO.Address.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import IO.Address.AddressBookDao;
import static org.junit.jupiter.api.Assertions.*;

public class AddressBookDaoTest {

  private AddressBookDao addressBookDao;

  @BeforeEach
  public void setUp() {
    addressBookDao = new AddressBookDao();
  }

  @Test
  public void testAddAddress() {
    addressBookDao.addAddress("John", "Doe", "USA", "12345", "New York", "123 Elm Street");
    assertEquals(1, addressBookDao.numOfAddresses(), "There should be 1 address in the book.");
  }

  @Test
  public void testRemoveAddress() {
    addressBookDao.addAddress("John", "Doe", "USA", "12345", "New York", "123 Elm Street");
    addressBookDao.removeAddress("Doe");
    assertEquals(0, addressBookDao.numOfAddresses(), "There should be no addresses after removal.");
  }

  @Test
  public void testNumOfAddresses() {
    assertEquals(0, addressBookDao.numOfAddresses(), "Initial address book should be empty.");
    addressBookDao.addAddress("Jane", "Doe", "Canada", "A1B 2C3", "Toronto", "456 Maple Avenue");
    assertEquals(1, addressBookDao.numOfAddresses(), "There should be 1 address after adding.");
  }

  @Test
  public void testViewAddresses() {
    addressBookDao.addAddress("John", "Doe", "USA", "12345", "New York", "123 Elm Street");
    addressBookDao.addAddress("Jane", "Smith", "Canada", "A1B 2C3", "Toronto", "456 Maple Avenue");

    // Capture system output using a ByteArrayOutputStream to verify the printed output.
    java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
    System.setOut(new java.io.PrintStream(outContent));

    addressBookDao.viewAddresses();

    // Get the output and normalize line endings to Unix style (\n)
    String actualOutput = outContent.toString().replaceAll("\\r\\n", "\n").replaceAll("\\r", "\n");

    // Both possible orders, since HashMap doesn't guarantee order
    String expectedOutput1 = "John Doe USA 12345 New York 123 Elm Street\n" +
            "Jane Smith Canada A1B 2C3 Toronto 456 Maple Avenue\n\n";
    String expectedOutput2 = "Jane Smith Canada A1B 2C3 Toronto 456 Maple Avenue\n" +
            "John Doe USA 12345 New York 123 Elm Street\n\n";

    // Check if the actual output matches either of the possible orders
    boolean matchesExpectedOutput = actualOutput.equals(expectedOutput1) || actualOutput.equals(expectedOutput2);

    assertTrue(matchesExpectedOutput, "Addresses should be correctly printed in any order.");
  }
}