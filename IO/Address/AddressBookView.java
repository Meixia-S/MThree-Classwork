package IO.Address;

import java.io.IOException;

public class AddressBookView {
  AddressBookController addressBookController = new AddressBookController();

  public void run() throws IOException {
    int option = 1;
    do {
      option =
      addressBookController.userIOLab.readInt("================================== \n" +
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
        "     To Exit or Quick Enter Any Other Integer\n");

      addressBookController.userIOLab.readString("");
      addressBookController.run(option);

    } while (option > 0 && option < 9);
  }
}