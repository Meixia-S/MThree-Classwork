public class Airplane {
  // Model an airplane as if the class were to be part of an air traffic control system.
  private String flightNumber;
  private double altitude;
  private double speed;
  private int direction;  // in degrees
  private double latitude;
  private double longitude;
  private String status;
  private String destination;
  private boolean inCommunication;

  // Model an airplane as if the class were to be part of a flight simulator.
  private String model;
  private double fuelLevel;
//  Flaps Position: Position of the flaps for controlling lift.
//  Throttle Position: Current throttle setting.
//  Landing Gear Status: Whether the landing gear is up or down.
//  Yaw, Pitch, Roll: Orientation of the airplane.
//  Velocity: Speed in a specific direction.
//  Engine Status: Whether the engine is running.


  // Model an airplane as if the class were to be part of an air traffic control system constructor.
  public Airplane(String flightNumber, String destination, boolean inCommunication) {
    // this is when a plane is sitting or about to take off.
    this.flightNumber = flightNumber;
    this.destination = destination;
    this.inCommunication = inCommunication;
  }

  public Airplane(String flightNumber, double altitude, double speed, int direction,
                  double latitude, double longitude, String status,
                  String destination, boolean inCommunication) {
    // this is when the plane is in mid-flight.
    this.flightNumber = flightNumber;
    this.altitude = altitude;
    this.speed = speed;
    this.direction = direction;
    this.latitude = latitude;
    this.longitude = longitude;
    this.status = status;
    this.destination = destination;
    this.inCommunication = inCommunication;
  }
}