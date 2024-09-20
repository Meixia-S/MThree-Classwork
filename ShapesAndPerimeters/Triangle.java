package ShapesAndPerimeters;

public class Triangle extends Shape {
  double sideA;
  double base;
  double sideC;
  double height;

  public Triangle(String color, double sideA, double base, double sideC, double height) {
    super(color);
    this.sideA = sideA;
    this.base = base;
    this.sideC = sideC;
    this.height = height;
  }

  @Override
  double getArea() {
    return this.base * this.height * 0.5;
  }

  @Override
  double getPerimeter() {
    return this.sideA + this.base + this.sideC;
  }
}