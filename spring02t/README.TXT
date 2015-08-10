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
1) 









1) 스프링 설정 파일 변경
  => 트랜잭션을 다루는 객체를 등록한다.
  => application-context.xml
  <bean id="txManager" 
        class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <property name="dataSource" ref="dataSource"/>
  </bean>
2) DAO 클래스 변경
  => auto commit을 false로 설정한다.
  => 모든 작업이 성공했을 때만 commit() 호출.
  => 실패하면 rollback() 호출












