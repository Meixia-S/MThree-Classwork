package IO.Address;

public class AddressBook {
  String firstName;
  String lastName;
  String country;
  String zipCode;
  String city;
  String street;

  public AddressBook (String firstName, String lastName, String country, String zipCode, String city, String street) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.country = country;
    this.zipCode = zipCode;
    this.city = city;
    this.street = street;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  // Getter and Setter for lastName
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  // Getter and Setter for country
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  // Getter and Setter for zipCode
  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  // Getter and Setter for city
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  // Getter and Setter for street
  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }
}