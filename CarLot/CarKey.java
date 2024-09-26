package CarLot;

public class CarKey {
  private String VIN;
  private boolean laserCut;

  public CarKey(boolean laserCut) {
    this.laserCut = laserCut;
  }

  public String getVIN() {
    return VIN;
  }

  public void setVIN(String VIN) {
    this.VIN = VIN;
  }

  public boolean isLaserCut() {
    return laserCut;
  }

  public void setLaserCut(boolean laserCut) {
    this.laserCut = laserCut;
  }
}