package ShapesAndPerimeters;

public class Rectangle extends Shape {
  double length;
  double width;

  public Rectangle(String color, double length, double width) {
    super(color);
    this.length = length;
    this.width = width;
  }

  @Override
  double getArea() {
    return this.length * this.width;
  }

  @Override
  double getPerimeter() {
    return (this.length * 2) + (this.width * 2);
  }
}