package CarLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CarLotDAO {
  HashMap<String, Car> carCatalog = new HashMap<>();

  public Car addCar(String VIN, Car car) {
    return carCatalog.put(VIN, car); // Adds the car and returns the previous value if it existed
  }

  public Car getCar(String VIN) {
    return carCatalog.get(VIN); // Returns the car associated with the VIN, or null if not found
  }

  public List<Car> getCars() {
    return new ArrayList<>(carCatalog.values()); // Returns a list of all cars
  }

  public void editCar(String VIN, Car car) {
    if (carCatalog.containsKey(VIN)) {
      carCatalog.put(VIN, car); // Updates the car associated with the VIN
    } else {
      System.out.println("Car with VIN " + VIN + " not found.");
    }
  }

  public Car removeCar(String VIN) {
    return carCatalog.remove(VIN); // Removes the car associated with the VIN and returns it
  }
}