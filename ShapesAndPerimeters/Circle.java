package ShapesAndPerimeters;

public class Circle extends Shape {
  double radius;

  public Circle(String color, double radius) {
    super(color);
    this.radius = radius;
  }

  @Override
  double getArea() {
    return 0;
  }

  @Override
  double getPerimeter() {
    return 2 * 3.14 * this.radius;
  }
}