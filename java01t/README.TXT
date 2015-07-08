[step01]
Test01.java
  - 클래스 사용
  - 패키지 이름 지정
  - import 사용
  - 클래스에 묶여 있는 메서드 사용
    - 데이터가 필요없는 메서드(클래스 메서드, 스태틱 메서드)
    - 데이터가 필요한 메서드(인스턴스 메서드)
    
Test02.java    
  - 데이터 준비 = 인스턴스 준비 
    - new 명령어 사용
    - 메서드를 호출 => 데이터 준비 과정이 복잡한 경우, 복잡함을 감추기 위해서.
    
Test03.java
  - 클래스 만들기
    - 데이터가 필요로 하지 않는 "클래스 메서드" 정의 => Calc.java    

Test04.java
  - 클래스 만들기
    - 클래스 변수(스태틱 변수) 활용 

Test05.java
  - 클래스 만들기
    - 인스턴스 변수 활용
    - 데이터를 개별적으로 관리하고 싶다면 인스턴스 변수로 만들어라.
      => 인스턴스마다 별개로 데이터를 관리한다.

Test06.java      
  - 클래스 만들기
    - 데이터를 필요로 하는 "인스턴스 메서드" 정의 => Calc.java   
    
Test07.java
  - static 블록
  - 인스턴스 블록과 생성자의 호출 순서
  - 익명 이너 클래스와 인스턴스 블록

Test08.java
  - 오버로딩
    - 같은 기능을 하는 메서드에 대해 같은 이름을 부여하여 프로그래밍의 일관성을 확보하자.

Test09.java
  - 프로퍼티 = 셋터 메서드 - (set 또는 get) + (첫 알파벳을 소문자로)
  - 프로퍼티는 인스턴스 변수가 아니다!
  
[step02] -----------------------------------------------------
Test01.java
  - Object 클래스 분석              
    
Test02.java
  - ArrayList 사용
  
Test03.java
  - HashSet 사용
  - hashCode(), equals() 재정의
  
Test04.java
  - Object.equals() 의미

Test05.java
  - HashMap 사용

Test06.java
  - 키 클래스를 만들기
  - 키로 사용할 클래스는 반드시 hashCode()와 equals()를 오버라이딩하라!

Test07.java
  - 랩퍼 클래스의 활용
  - boxing, unboxing => auto-boxing  
    
[step03]
Test01.java
  - 셋터 메서드에 체이닝 호출 적용     

Test02.java
  - Reflection API 다루기
  - Class 클래스를 사용한 객체 생성     

Test03.java
  - Reflection API 다루기
  - Method 클래스 사용

Test04.java
  - Reflection API 다루기
  - Parameter 클래스 활용: 메서드의 파라미터 정보 추출하기

[step04]
Test01.java
  - 자바 기본 스레드와 스레드 그룹 조사
        
Test02.java
  - 자바 스레드와 스택 메모리, 힙 메모리의 관계

Test03.java
  - CPU Scheduling : 여러 프로세스와 스레드가 CPU를 공유하기 때문에
                     실행 순서를 관리할 필요가 있다. OS 일이다.     
  - 스레드 생성 및 테스트   

Test04.java
  - Critical Section(Region) <-> Thread Safe
  - Semaphore(n)
  - Semaphore(1) == Mutex
  - sychronized
  
[step05] - JDBC Programming
Test01.java
  - java.sql.Driver 구현체를 로딩  
  - Class.forName() 사용
       
Test02.java
  - java.sql.Driver 구현체를 로딩  
  - DriverManager.registerDriver() 사용

Test03.java
  - java.sql.Driver 구현체를 로딩  
  - Class.forName() 사용 이점.
    => 외부에서 Driver 클래스 이름을 전달할 수 있다.

Test04.java
  - DBMS에 연결하기: java.sql.Connection 구현체

Test05.java
  - SQL 질의를 도와줄 객체 얻기 : java.sql.Statement 구현체            

Test06.java
  - 오류가 발생하더라도 Connection 객체의 연결을 제대로 끊기.

Test07.java
  - 질의 하기 : SELECT 문 실행
  - 결과 가져오기 : ResultSet 사용
      
Test08.java
  - 질의 결과 출력하기
  - next(), getXXX() 사용
  
Test09.java
  - 데이터 입력 : INSERT 문 실행

Test10.java
  - 데이터 변경 : UPDATE 문 실행
  
Test11.java
  - 데이터 삭제 : DELETE 문 실행

[중간 경진 대회]
BoardCreate.java 
BoardRead.java
BoardUpdate.java
BoardDelete.java
* 특별 주문
BoardDelete 실행 
삭제할 게시물 번호> 11(엔터)

Test12.java
  - SQL 문에 데이터를 넣는 쉬운 방법: PreparedStatement

Test13.java
  - SQL 문에 데이터를 넣는 쉬운 방법: PreparedStatement
  - Statement vs PreparedStatement  
  
[step06]
  - 게시물 애플리케이션을 단계적으로 발전시킨다.
  - 객체지향 프로그래밍 개념을 익힌다.
v01.BoardApp
  - 사용자에게 프롬프트를 출력한다.

v02.BoardApp
  - 사용자가 입력한 명령어를 분기 처리한다.

v03.BoardApp
  - 각 명령어에 대해 JDBC 적용

v04.BoardApp
  - 각 명령어를 처리하는 코드를 별도의 메서드를 분리.

v05.BoardApp
  - 데이터를 다루는 메서드를 별도의 클래스로 분리한다.
    => Data Access Object(DAO)
    => BoardDao 클래스 작성

v06.BoardApp
  - BoardDao에서 공통으로 사용할 Connection 객체를 static 변수로 공유한다.
    => static 블록 사용
    
v07.BoardApp
  - BoardDao를 여러 DB에 동시에 연결할 수 있도록 연결 정보를 개별관리한다.
    => Connection 변수를 인스턴스 변수로 전환한다.
    => Connection 객체를 생성자에서 준비한다.         
  
v08.BoardApp
  - Connection 관리 기능을 준비한다. => DBConnectionPool
  - "Pooling 기법"
    => 적은 자원을 효율적으로 사용하기 위해 객체를 공유하는 기법  
  - 필요한 객체를 외부에서 제공(주입; Dependency Injection(DI) => IoC)
  
v09.BoardApp
  - BoardDao에 있는 출력 관련 코드를 BoardApp으로 옮긴다.
  - 두 클래스가 데이터를 주고 받을 수 있도록 값을 전달할 때 사용하는 객체 추가
    => Board
    => DTO(Data Transfer Object), VO(Value Object)    
  
  
  
  
  
  
  
      
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    