[step01: 컨트롤러 만들기1]
1) 페이지 컨트롤러를 만들기 위한 최소 조건: Controll01.java
- 클래스 선언에 @Controller 애노테이션 붙여라.
- 메서드에 @RequestMapping을 붙여라.

2) @RequestMapping과 URL: Controller02.java
- 페이지 컨트롤러에 URL을 연결할 때 사용한다.

3) 메서드에 URL 붙이기
- Controller03.java

4) URL을 클래스와 메서드에 분리하여 선언하기
- Controller04.java

5) 페이지 컨트롤러에 여러 개의 request handler 두기
- Controller05.java

6) GET, POST 요청 지정하기
- Controller06.java
- @RequestMapping의 method 속성 활용하기

7) 리턴 타입 다루기
- Controller07.java
- String : JSP URL 지정
- ModelAndView: JSP URL과 값을 함께 리턴하기.
- JSP URL과 값을 분리하여 전달. 
  => return(ModelAndView), parameter(Map)
.. 등

[step02: 트랜잭션 다루기1 - Mybatis에서 트랜잭션 관리 - auto commit]
- mybatis에서 트랜잭션을 관리.
- DML SQL문(insert,update,delete)을 실행한 후 자동으로
  commit한다.
  즉 각 SQL 실행마다 실제 테이블에 결과를 넣는다.(자동 commit한다)
* 커밋(commit)
- 임시 테이블의 작업 결과를 실제 테이블에 적용하는 것.  
- 실습
1) VO 클래스 작성: Test01, Test02
2) DAO 클래스 작성: TestDao
3) SQL 맵퍼 파일 작성: TestDao.xml
4) mybatis 설정 파일 작성: mybatis-config.xml
5) 페이지 컨트롤러 작성: TestController

[step03: 트랜잭션 다루기2 - Mybatis에서 트랜잭션 관리 - 코드로 트랜잭션 제어하기]
- SqlSession의 commit(), rollback() 사용하기
- auto commit 비활성화 하기 
  SqlSession sqlSession = 
        sqlSessionFactory.openSession(false);
  자동 커밋을 비활성화시키면 commit() 호출하기 전에는
  DB에 작업 결과를 반영하지 않는다.

[step04: 트랜잭션 다루기3 - 두 개 이상의 DAO를 사용할 때]
1) DAO
  => 테이블 당 한 개의 DAO 만들기
  => 기존의 TestDao를 Test01Dao와 Test02Dao로 쪼갠다.
2) Sql Mapper 파일
  => 테이블 당 한 개의 Sql Mapper 파일 만든다.
  => 기존의 TestDao.xml 파일을 Test01Dao.xml과 Test02Dao.xml로 쪼갠다.
3) 페이지 컨트롤러에서 트랜잭션을 관리
  => TestController 클래스 변경

* 문제점:
  => 각각의 DAO가 별도로 Mybatis(SqlSessionFactory)를 
         관리하기 때문에  트랜잭션을 다루기가 어렵다.  
  
[step05: 트랜잭션 다루기4 - Mybatis(SqlSessionFactory) 공유]
1) SqlSessionFactoryFactoryBean 클래스 작성
  => 스프링 빈 컨테이너가 SqlSessionFactory를 관리할 수 있도록
     FactoryBean 구현체를 만든다.
2) DAO 클래스에 SqlSessionFactory 객체 주입
  => 기존의 각 DAO에서 개별적으로 관리하던 SqlSessionFactory를
     스프링으로부터 주입 받는 방식으로 변경한다.

[step06: 트랜잭션 다루기5 - 각 스레드 별로 SqlSession 객체 관리] 
- ServletRequest를 사용하는 대신에 ThreadLocal을 사용한다.
1) DAO 클래스 변경
  => sqlSession 객체를 담을 ThreadLocal 변수를 선언한다.
  => commit(), rollback()에서 ThreadLocal 변수에 
     보관된 SqlSession 객체를 사용한다.
2) TestController 클래스 변경
  => 각 요청 별로 SqlSession을 저장하기 위해
     ServletRequest를 전달할 필요가 없다. 
     ThreadLocal 객체에 의해 자동 처리된다.

[step07: 트랜잭션 다루기6 - Mybatis-Spring 라이브러리 사용하기]
1) 스프링 설정 파일 변경
  => application-context.xml
  => Mybatis-Spring 연동 객체를 등록한다.
  bean id="sqlSessionFactory" 
        class="org.mybatis.spring.SqlSessionFactoryBean">
    <property name="dataSource" ref="dataSource" />
    <property name="typeAliasesPackage" 
        value="study.vo" />
    <property name="mapperLocations" 
        value="classpath*:study/dao/*Dao.xml"/>
  </bean>
  
  => DB커넥션풀 객체도 스프링에서 관리한다.
  <bean id="dataSource" 
        class="org.springframework.jdbc.datasource.DriverManagerDataSource">
    <property name="driverClassName" 
        value="com.mysql.jdbc.Driver"/>
    <property name="url" 
        value="jdbc:mysql://localhost:3306/java72db"/>
    <property name="username" value="java72"/>
    <property name="password" value="java72"/>
  </bean>
  
  => 트랜잭션을 다루는 객체를 등록한다.
  <bean id="txManager" 
        class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <property name="dataSource" ref="dataSource"/>
  </bean>
  
2) DAO 클래스 변경
  => Test01Dao, Test02Dao 클래스 변경
  => commit, rollback은 DAO를 사용하는 페이지 컨트롤러에서
     처리할 것이다. 관련 코드를 삭제한다.

3) TestController에서 스프링  트랜잭션 관리자를 이용하여
   DAO의 트랜잭션을 관리한다.  

[step08: 트랜잭션 다루기7 - 서비스 컴포넌트 도입]
- 페이지 컨트롤러로부터 비즈니스 로직을 분리한다.
1) TestService 클래스 생성
  => 페이지 컨트롤러에 있던 DAO 호출 코드를 가져온다.
2) TestController 클래스 변경
  => 직접 DAO를 사용하는 대신에 Service 컴포넌트를 사용한다.

[step09: 트랜잭션 다루기8 - 서비스 인터페이스와 구현체를 분리]
- 고객사 별로 업무가 약간씩 다를 수 있기 때문에
  다양한 고객사를 대응하기 위해 서비스 객체를 인터페이스와 구현체로 구분한다.
  => 납품하는 고객사의 업무가 다르다면 서비스 구현도 변경한다.
  => 그러나 페이지 컨트롤러는 변경할 필요가 없다.

[step10: 트랜잭션 다루기9 - 애노테이션으로 트랜잭션 다루기]
- PlatformTransactionManager 객체를 통해 트랜잭션을 관리하는 대신
  @Transactional 애노테이션을 통해 트랜잭션을 관리한다.
1) 스프링 설정 파일에 @Transactional 애노테이션을 처리할
   객체를 등록하라!
   
[step11: 트랜잭션 다루기10 - 트랜잭션 관리 정책]
1) REQUIRED
  => 호출자가 트랜잭션에 소속된 경우(tx1)
     => 호출자와 같은 트랜잭션에 소속된다.(tx1)
  => 호출자가 트랜잭션에 소속되지 않은 경우
     => 새로운 트랜잭션을 만든다.(new)
2) REQUIRES_NEW
  => 호출자: tx1
     => 호출자의 트랜잭션에 상관없이 새로 트랜잭션을 시작한다.(tx2)
  => 호출자: X
     => 새로운 트랜잭션을 만든다.(new)
3) SUPPORTS
  => 호출자: tx1
     => tx1
  => 호출자: X
     => 트랜잭션 적용하지 않고 실행한다.

4) NOT_SUPPORTED
  => 호출자: tx1
     => 트랜잭션 적용하지 않고 실행한다.
  => 호출자: X
     => 트랜잭션 적용하지 않고 실행한다.

5) MANDATORY
  => 호출자: tx1
     => tx1
  => 호출자: X
     => 예외 발생!

6) NEVER
  => 호출자: tx1
     => 예외 발생!
  => 호출자: X
     => X

[step12: 트랜잭션 다루기11 - XML과 AOP로 트랜잭션 설정하기]
0) 준비
  => aspectj weaver 의존 라이브러리 추가
  
1) 트랜잭션 정책 설정하기
  <tx:advice id="txAdvice" transaction-manager="txManager">
    <tx:attributes>
      <tx:method name="get*" read-only="true" />
      <tx:method name="list*" read-only="true" />
      <tx:method name="*" propagation="REQUIRED"/>
    </tx:attributes>
  </tx:advice>

2) 트랜잭션을 적용할 대상 지정하기
  <aop:config>
    <!-- 적용할 클래스나 메서드 정의 -->
    <aop:pointcut id="serviceOperation"
      expression="execution(* study.service..*Service.*(..))" />
    
    <!-- 트랜잭션 규칙을 적용 -->
    <aop:advisor pointcut-ref="serviceOperation" 
                 advice-ref="txAdvice" />
  </aop:config>

3) Service 컴포넌트에서 트랜잭션 관련 애노테이션 제거하기
  => TestServiceImpl 클래스 변경
  
[step13: DB 커넥션풀(DataSource)을 관리는 서블릿 컨테이너에게 맡기기]
1) 톰캣 서버에 DataSource 설정하기
      <Resource name="jdbc/java72db" 
         auth="Container" 
         type="javax.sql.DataSource"
         maxTotal="100" 
         maxIdle="30" 
         maxWaitMillis="10000"
         url="jdbc:mysql://localhost:3306/java72db"
         driverClassName="com.mysql.jdbc.Driver"
         username="java72" password="java72"/> 
    
2) 스프링 설정 파일 변경
  => 직접 DB 커넥션을 관리하지 않고,
     서블릿 컨테이너가 관리하는 커넥션풀을 이용한다.
  => 설정 파일에 다음을 추가한다.   
  <jee:jndi-lookup id="dataSource" 
        jndi-name="java:comp/env/jdbc/java72db"/>
   
[step14: DB 관련 객체를 공용 IoC 컨테이너에서 관리하자]
1) 공용 IoC 컨테이너 준비
  => 웹 애플리케이션이 시작될 때 준비되어야 한다.
     => 프론트 컨트롤러가 시작하기 전에 준비되어야 한다.
  => ServletContextListener 구현체를 만들면 된다.
     => 스프링에서 이 구현체를 제공한다.
     => ContextLoaderListener 사용한다.
  => web.xml에 다음 설정을 추가한다.
2) ServletContextLoader 리스너 추가 및 설정 파일 경로 추가
    <context-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>/WEB-INF/conf/application-context.xml</param-value>
    </context-param>
  
    <listener>
      <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
    
3) 기존의 DispatcherServlet을 위한 설정 파일은
     dispatch-servlet.xml로 변경한다.    

4) 기존에 있던 application-context.xml 파일에서
   웹 관련 객체들은 dispatch-servlet.xml로 옮긴다.      













