package step03;

public class Sedan extends Car {
  int capacity;

  @Override
  public String toString() {
    return "Sedan [capacity=" + capacity + ", model=" + model + ", cc=" + cc + ", outDate=" + outDate + "]";
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }
  
  
}
