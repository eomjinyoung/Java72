package net.bitacademy.java72.step04;

public class Test04 {
  static class Account {
    long balance = 1000000;
    
    // * Critical Section(Critical Region)
    // -> 여러 스레드가 동시에 접근했을 때 문제가 발생하는 코드 영역
    // -> Thread safe 하지 않다.
    // -> 스레드들이 공유하는 변수의 값을 변경할 때 발생!
    //
    // 참고: thread safe => 여러 스레드가 동시에 접근하더라도 문제가 발생하지 않는 코드
    // 
    // 문제 해결책
    // - 한 번에 한 스레드만 크리티컬 섹션에 들어가도록 해야 한다.
    //
    // * 세마포어(semaphore)
    //   => 지정된 수 만큼만 진입을 허용한다.
    //
    // * 뮤텍스(Mutex) -> 상호 배제
    //   => 오직 한 개만 진입 허용.
    synchronized public boolean withdraw(long money) {
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












