package ShapesAndPerimeters;

public class Square extends Shape {
  double sideLength;

  public Square(String color, double sideLength) {
    super(color);
    this.sideLength = sideLength;
  }

  @Override
  double getArea() {
    return this.sideLength * this.sideLength * this.sideLength;
  }

  @Override
  double getPerimeter() {
    return this.sideLength * 4;
  }
}
