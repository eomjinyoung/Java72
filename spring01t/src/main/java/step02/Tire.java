package step02;

public class Tire {
  String  maker;
  int     width;
  float   diameter;
  
  @Override
  public String toString() {
    return "Tire [maker=" + maker + ", width=" + width + ", diameter=" + diameter + "]";
  }
  
  public String getMaker() {
    return maker;
  }
  public void setMaker(String maker) {
    this.maker = maker;
  }
  public int getWidth() {
    return width;
  }
  public void setWidth(int width) {
    this.width = width;
  }
  public float getDiameter() {
    return diameter;
  }
  public void setDiameter(float diameter) {
    this.diameter = diameter;
  }
  
  
}
