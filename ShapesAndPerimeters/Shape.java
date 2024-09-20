package ShapesAndPerimeters;

public abstract class Shape {
  public final String color;

  public Shape(String color) {
    this.color = color;
  }

  abstract double getArea();

  abstract double getPerimeter();
}