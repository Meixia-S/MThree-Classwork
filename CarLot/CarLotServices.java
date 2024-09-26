package CarLot;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarLotServices implements CarLotService{
  public CarLotDAO carLotDAO = new CarLotDAO();

  @Override
  public Car getACar(String VIN) {
    return carLotDAO.carCatalog.get(VIN);
  }

  @Override
  public List<Car> getAllCars() {
    return new ArrayList<>(carLotDAO.carCatalog.values());
  }

  // Return all cars that match a given color
  @Override
  public List<Car> getCarsByColor(String color) {
    return carLotDAO.carCatalog.values().stream()
            .filter(car -> car.getColor().equalsIgnoreCase(color))
            .collect(Collectors.toList());
  }

  // Return all cars that are within the given budget
  @Override
  public List<Car> getCarsInBudget(BigDecimal maxPrice) {
    return carLotDAO.carCatalog.values().stream()
            .filter(car -> car.getPrice().compareTo(maxPrice) <= 0)
            .collect(Collectors.toList());
  }

  // Return cars matching a specific make and model
  @Override
  public List<Car> getCarByMakeAndModel(String make, String model) {
    return carLotDAO.carCatalog.values().stream()
            .filter(car -> car.getMake().equalsIgnoreCase(make) && car.getModel().equalsIgnoreCase(model))
            .collect(Collectors.toList());
  }

  // Apply a discount to a car and return the new price
  @Override
  public BigDecimal discountCar(String VIN, BigDecimal percentDiscount) throws NoSuchCarException {
    Car car = carLotDAO.carCatalog.get(VIN);
    if (car == null) {
      throw new NoSuchCarException("Car with VIN " + VIN + " not found.");
    }

    BigDecimal discountAmount = car.getPrice().multiply(percentDiscount).divide(BigDecimal.valueOf(100));
    BigDecimal newPrice = car.getPrice().subtract(discountAmount);
    car.setPrice(newPrice);

    return newPrice;
  }

  // Sell a car and return the CarKey, while checking payment and throwing appropriate exceptions
  @Override
  public CarKey sellCar(String VIN, BigDecimal cashPaid) throws NoSuchCarException, OverpaidPriceException, UnderpaidPriceException {
    Car car = carLotDAO.carCatalog.get(VIN);
    if (car == null) {
      throw new NoSuchCarException("Car with VIN " + VIN + " not found.");
    }

    BigDecimal carPrice = car.getPrice();

    if (cashPaid.compareTo(carPrice) < 0) {
      throw new UnderpaidPriceException("Insufficient payment. Car price is " + carPrice + " but paid only " + cashPaid + ".");
    } else if (cashPaid.compareTo(carPrice) > 0) {
      throw new OverpaidPriceException("Excessive payment. Car price is " + carPrice + " but paid " + cashPaid + ".");
    }

    // Assume CarKey is generated when the car is sold
    CarKey carKey = car.getKey();
    carLotDAO.carCatalog.remove(VIN);  // Remove car from inventory after sale

    return carKey;
  }
}
