package CarLot;

import java.math.BigDecimal;

public class Car {
  private String VIN;
  private String make;
  private String model;
  private String color;
  private BigDecimal price;
  private long odometerMiles;
  private CarKey key;

  public Car(String VIN, String make, String model, String color, BigDecimal price, long odometerMiles, CarKey key) {
    this.VIN = VIN;
    this.make = make;
    this.model = model;
    this.color = color;
    this.price = price;
    this.odometerMiles = odometerMiles;
    this.key = key;
    key.setVIN(VIN);
  }

  public String getVIN() {
    return VIN;
  }

  public void setVIN(String VIN) {
    this.VIN = VIN;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public long getOdometerMiles() {
    return odometerMiles;
  }

  public void setOdometerMiles(long odometerMiles) {
    this.odometerMiles = odometerMiles;
  }

  public CarKey getKey() {
    return key;
  }

  public void setKey(CarKey key) {
    this.key = key;
  }

  @Override
  public String toString() {
    return "Car{" +
            "VIN='" + VIN + '\'' +
            ", make='" + make + '\'' +
            ", model='" + model + '\'' +
            ", color='" + color + '\'' +
            ", price=" + price +
            ", odometerMiles=" + odometerMiles +
            '}';
  }
}