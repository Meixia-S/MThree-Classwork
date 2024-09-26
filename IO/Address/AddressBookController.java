package IO.Address;

// Design is not the best - focused on functionality

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import IO.UserIOLab;

public class AddressBookController {
  AddressBookDao  addressBookDao = new AddressBookDao();
  UserIOLab userIOLab = new UserIOLab();

  public void run(int option) throws IOException {
    if (option == 1) {

      userIOLab.print("Add Address Menu:");
      String firstName = userIOLab.readString("Enter first name: ");
      String lastName = userIOLab.readString("Enter last name: ");
      String country = userIOLab.readString("Enter the country: ");
      String zipCode = userIOLab.readString("Enter the zip code: ");
      String city = userIOLab.readString("Enter the city: ");
      String street = userIOLab.readString("Enter the street: ");
      addressBookDao.addAddress(firstName, lastName, country, zipCode, city, street);

    } else if (option == 2) {

        userIOLab.print("Remove Address Menu:");
        String lastName = userIOLab.readString("Enter last name: ");
        addressBookDao.removeAddress(lastName);

      } else if (option == 3) {

        userIOLab.print("Find Address Menu:");
        String lastName = userIOLab.readString("Enter last name: ");
        try {
          AddressBook ab = addressBookDao.map.get(lastName);
          userIOLab.print(ab.getFirstName() + " " +
                  ab.getLastName() + " " +
                  ab.getCountry() + " " +
                  ab.getZipCode() + " " +
                  ab.getCity() + " " + ab.getStreet());
        } catch (NullPointerException e)  {
           userIOLab.print("Invalid Last Name, Try Again");
        }

      } else if (option == 4) {

        userIOLab.print("Get Number of Addresses Menu:");
        userIOLab.print(String.valueOf(addressBookDao.numOfAddresses()));

      } else if (option == 5) {

        userIOLab.print("List All Address Menu:");
        addressBookDao.viewAddresses();

      } else if (option == 6) {

        userIOLab.print("Edit Address Menu:");
        String firstName = userIOLab.readString("Enter first name: ");
        String lastName = userIOLab.readString("Enter last name: ");
        String country = userIOLab.readString("Enter the country: ");
        String zipCode = userIOLab.readString("Enter the zip code: ");
        String city = userIOLab.readString("Enter the city: ");
        String street = userIOLab.readString("Enter the street: ");
        addressBookDao.addAddress(firstName, lastName, country, zipCode, city, street);

      } else if (option == 7) {

        try {
          userIOLab.print("Read Address from File Menu:");
          String fileName = userIOLab.readString("Enter file name: ");
          Scanner scanner = new Scanner(new BufferedReader(new FileReader("Files/"+fileName+".txt")));
          while (scanner.hasNextLine()) {
            String[] splitText = scanner.nextLine().split("::");
            addressBookDao.addAddress(splitText[0], splitText[1], splitText[2],
                    splitText[3], splitText[4], splitText[5]);
          }
        } catch (FileNotFoundException e) {
          throw new RuntimeException(e);
        }

    } else if (option == 7) {

      userIOLab.print("Save Address to File Menu:");
      String fileName = userIOLab.readString("Enter file name: ");
      String name = userIOLab.readString("Enter last name of address: ");
      PrintWriter printWriter = new PrintWriter(new FileWriter("Files/"+fileName+".txt", true));
      printWriter.print(addressBookDao.map.get(name).getFirstName() + "::" +
                        addressBookDao.map.get(name).getFirstName() + "::" +
                        addressBookDao.map.get(name).getFirstName() + "::" +
                        addressBookDao.map.get(name).getFirstName() + "::" +
                        addressBookDao.map.get(name).getFirstName() + "::" +
                        addressBookDao.map.get(name).getFirstName());
    }
  }
}