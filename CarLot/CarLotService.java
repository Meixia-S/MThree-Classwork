package CarLot;

import java.math.BigDecimal;
import java.util.List;

public interface CarLotService {
  public Car getACar(String VIN);
  public List<Car> getAllCars();
  public List<Car> getCarsByColor(String color);
  public List<Car> getCarsInBudget(BigDecimal maxPrice);
  public List<Car> getCarByMakeAndModel(String make, String model);

  public BigDecimal discountCar(String VIN, BigDecimal percentDiscount)
          throws NoSuchCarException;

  public CarKey sellCar(String VIN, BigDecimal cashPaid)
          throws NoSuchCarException,
          OverpaidPriceException,
          UnderpaidPriceException;

  // THIS WAS NEEDED INORDER TO GET RID OF THE ERRORS SURROUNDING THE EXCEPTIONS!!
  public class NoSuchCarException extends Exception {
    public NoSuchCarException(String message) {
      super(message);
    }
  }

  public class OverpaidPriceException extends Exception {
    public OverpaidPriceException(String message) {
      super(message);
    }
  }

  public class UnderpaidPriceException extends Exception {
    public UnderpaidPriceException(String message) {
      super(message);
    }
  }
}