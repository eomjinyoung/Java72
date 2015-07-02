package net.bitacademy.java72.step04;

public class Test04 {
  static class Account {
    long balance = 1000000;
    
    public boolean withdraw(long money) {
      long temp = this.balance;
      
      double d = 3.14159;
      d *= 234.4567;
      Math.random();
      
      temp = temp - money;
      
      d = 3.14159;
      d *= 234.4567;
      Math.random();
      
      if (temp >= 0) {
        this.balance = temp;
        return true;
      }
      
      d = 3.14159;
      d *= 234.4567;
      Math.random();
      
      return false;
    }
  }
  
  static class ATM extends Thread {
    Account account;
    long sum;
    
    public ATM(String name, Account account) {
      super(name);
      this.account = account;
    }
    
    @Override
    public void run() {
      for (int i = 0; i < 10000; i++) {
        if (account.withdraw(100)) {
          sum += 100;
        }
      }
      
      System.out.printf("%s: %d원\n", this.getName(), sum);
    }
  }
  
  public static void main(String[] args) {
    Account account = new Account();
    new ATM("강남", account).start();
    new ATM("종로", account).start();
    new ATM("강변", account).start();
    new ATM("잠실", account).start();
  }

}












