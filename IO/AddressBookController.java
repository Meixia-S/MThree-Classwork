package IO;

// Design is not the best - focused on functionality

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AddressBookController {
  AddressBookDao addressBookDao = new AddressBookDao();
  UserIOLab userIOLab = new UserIOLab();

  public static void main(String[] args) throws IOException {
    AddressBookController  abc = new AddressBookController();
    int option = 1;
    do {
      option = abc.userIOLab.readInt("================================== \n" +
              "Initial Menu:\n" +
              "      Please select the operation you wish to perform:\n" +
              "            1. Add Address\n" +
              "            2. Delete Address\n" +
              "            3. Find Address\n" +
              "            4. List Address Count\n" +
              "            5. List All Addresses\n" +
              "            6. Edit Address\n" +
              "            7. Read Address from File\n" +
              "            8. Save Address to File\n" +
              " To Exit or Quick Enter Any Other Integer");

      if (option == 1) {

        abc.userIOLab.print("Add Address Menu:");
        String firstName = abc.userIOLab.readString("Enter first name: ");
        String lastName = abc.userIOLab.readString("Enter last name: ");
        String country = abc.userIOLab.readString("Enter the country: ");
        String zipCode = abc.userIOLab.readString("Enter the zip code: ");
        String city = abc.userIOLab.readString("Enter the city: ");
        String street = abc.userIOLab.readString("Enter the street: ");
        abc.addressBookDao.addAddress(firstName, lastName, country, zipCode, city, street);

      } else if (option == 2) {

        abc.userIOLab.print("Remove Address Menu:");
        String lastName = abc.userIOLab.readString("Enter last name: ");
        abc.addressBookDao.removeAddress(lastName);

      } else if (option == 3) {

        abc.userIOLab.print("Find Address Menu:");
        String lastName = abc.userIOLab.readString("Enter last name: ");
        AddressBook ab = abc.addressBookDao.map.get(lastName);
        abc.userIOLab.print(ab.getFirstName() + " " +
                            ab.getLastName() + " " +
                            ab.getCountry() + " " +
                            ab.getZipCode() + " " +
                            ab.getCity() + " " + ab.getStreet());

      } else if (option == 4) {

        abc.userIOLab.print("Get Number of Addresses Menu:");
        abc.userIOLab.print(String.valueOf(abc.addressBookDao.numOfAddresses()));

      } else if (option == 5) {

        abc.userIOLab.print("List All Address Menu:");
        abc.addressBookDao.viewAddresses();

      } else if (option == 6) {

        abc.userIOLab.print("Edit Address Menu:");
        String firstName = abc.userIOLab.readString("Enter first name: ");
        String lastName = abc.userIOLab.readString("Enter last name: ");
        String country = abc.userIOLab.readString("Enter the country: ");
        String zipCode = abc.userIOLab.readString("Enter the zip code: ");
        String city = abc.userIOLab.readString("Enter the city: ");
        String street = abc.userIOLab.readString("Enter the street: ");
        abc.addressBookDao.addAddress(firstName, lastName, country, zipCode, city, street);

      } else if (option == 7) {

        try {
          abc.userIOLab.print("Read Address from File Menu:");
          String fileName = abc.userIOLab.readString("Enter file name: ");
          Scanner scanner = new Scanner(new BufferedReader(new FileReader("Files/"+fileName+".txt")));
          while (scanner.hasNextLine()) {
            String[] splitText = scanner.nextLine().split("::");
            abc.addressBookDao.addAddress(splitText[0], splitText[1], splitText[2],
                    splitText[3], splitText[4], splitText[5]);
          }
        } catch (FileNotFoundException e) {
          throw new RuntimeException(e);
        }

      } else if (option == 7) {

        abc.userIOLab.print("Save Address to File Menu:");
        String fileName = abc.userIOLab.readString("Enter file name: ");
        String name = abc.userIOLab.readString("Enter last name of address: ");
        PrintWriter printWriter = new PrintWriter(new FileWriter("Files/"+fileName+".txt", true));
        printWriter.print(abc.addressBookDao.map.get(name).getFirstName() + "::" +
                          abc.addressBookDao.map.get(name).getFirstName() + "::" +
                          abc.addressBookDao.map.get(name).getFirstName() + "::" +
                          abc.addressBookDao.map.get(name).getFirstName() + "::" +
                          abc.addressBookDao.map.get(name).getFirstName() + "::" +
                          abc.addressBookDao.map.get(name).getFirstName());
      }

    } while (option > 0 && option < 8);
  }
}