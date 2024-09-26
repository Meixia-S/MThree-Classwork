package IO.Address;

import java.util.HashMap;
import java.util.Map;

import IO.Address.AddressBook;

public class AddressBookDao {
  HashMap<String, AddressBook> map = new HashMap<>();

  public void addAddress(String firstName, String lastName, String country, String zipCode,
                          String city, String street) {
    AddressBook ab = new AddressBook(firstName, lastName, country, zipCode, city, street);
    map.put(lastName, ab);
    System.out.println("Address Added");
  }

  public void removeAddress(String lastName) {
    map.remove(lastName);
    System.out.println("Address Removed");
  }

  public int numOfAddresses() {
    return map.size();
  }

  public void viewAddresses() {
    String list = "";
    for (Map.Entry<String, AddressBook> entry : map.entrySet()) {

      list += entry.getValue().getFirstName() + " " + entry.getValue().getLastName() + " " +
              entry.getValue().getCountry() + " " + entry.getValue().getZipCode() + " " +
              entry.getValue().getCity() + " " + entry.getValue().getStreet() + "\n";
    }
    System.out.println(list);
  }
}