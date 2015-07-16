package step03;

public class Truck extends Car {
  int   weight;

  @Override
  public String toString() {
    return "Truck [weight=" + weight + ", model=" + model + ", cc=" + cc + ", outDate=" + outDate + "]";
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }
  
}
