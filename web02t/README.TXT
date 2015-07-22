[Gradle 웹 프로젝트 만들기]
1. web02t 프로젝트 생성
2. src 폴더 생성
3. src/main/webapp 폴더 추가
   => 웹 애플리케이션 관련 파일을 두는 폴더
4. build.gradle 파일 준비
5. .project에 gradle 네이처 추가
6. 기본 이클립스 관련 설정 파일 생성
   => Run As -> build... -> clean, eclipse
   
[톰캣 테스트 서버에 자동 배치할 수 있도록 웹 프로젝트 설정]
1. build.gradle에 웹 관련 플러그인 추가
   => apply plugin: 'war'
   => apply plugin: 'eclipse-wtp'
   => 웹 관련 설정 파일을 만들 수 있는 명령을 사용할 수 있다.

2. 웹 프로젝트 관련 설정 파일 추가
   => build.gradle에 서블릿 스펙 버전과 자바 버전을 설정한다.
      
[웹의 역사]
1. 웹이 등장하기 전의 문서 교환 방법
2. 개선 방법
   => 문서 안에 참조 문서의 연결 정보를 포함(Hyper-Text)
   => Hyper-Text를 만들기 위한 문법 정의 
      Hyper-Text Markup Language
   => HTML 교환 프로토콜을 정의(Connectionless 방식)
      Hyper-Text Transfer Protocol
   => 애플리케이션
      HTTP Server(Web Server) <--> HTTP Client(Web Browser)
3. 웹의 발전
   => 간단한 게시판을 통해 사용자 피드백을 받기
   => 스크립트 언어를 사용하여 좀 더 복잡한
      웹 애플리케이션 작성을 시작
   => 데스크톱 앱 ----> 웹 애플리케이션으로 전환
   
4. CGI(Common Gateway Interface)
   => 웹 서버와 애플리케이션 사이의 데이터 교환 규칙
   => CGI 프로그램: CGI 규칙에 따라 만든 프로그램
   => 스크립트를 사용하면서 CGI 규칙에 벗어남.
   
5. 자바 웹 애플리케이션
   => JavaEE 기술 규격
      Servlet, JSP, EJB, 자원 관리 등의 기술을 총 망라한다.
   => JavaEE 구현체
      JavaEE 기술 규격에 따라 만든 서버
      => Web Application Server 라 부른다.
   => 주의
      고객 사의 WAS가 어떤 JavaEE 버전을 지원하는 지 알아야 한다.
      그 버전에 맞추어 개발해야 한다.

6. JavaEE 구현체
   => 티맥스 소프트의 JEUS(유/무)
   => 오라클의 WebLogic(유), GlassFish(무, 개발용)
   => IBM의 WebSphere(유)
   => 레드햇의 JBoss(유/무)
   => 아파치재단의 Geronemo(무)
   => Servlet과 JSP만 구현한 구현체
      Tomcat, Resin, Jetty

[step01]
1. 서블릿 구현 및 서블릿 구동 원리: HelloWorld
   Servlet 인터페이스
   => 서블릿 컨테이너와 서블릿 사이의 호출 규칙
   => init(): 웹 애플리케이션이 시작될 때 자동 호출됨.
      => 서비스에 필요한 자원을 준비
   => service(): 클라이언트 요청을 처리하는 메서드.
      => 요청을 처리한다.
   => destroy(): 웹 애플리케이션이 종료되기 직전에 호출된다.
      => 자원을 해제

2. 서블릿 클래스를 간단히 만드는 방법: HelloWorld2
  => GenericServlet 추상 클래스 상속 받기 
  => GenericServlet 추상 클래스
     - 개발자를 위해 Servlet 인터페이스를 구현했다.
     - service() 메서드를 제외한 나머지 메소드 모두 구현.
     - service() 구현은 서브 클래스 개발자에게 맡긴다.
             
3. 서블릿을 배포하는 방법
1) @WebServlet 애노테이션을 이용한 방법 
   => Servlet 3.0부터 이용 가능
   => HelloWorld, HelloWorld2
   
2) web.xml에 서블릿 정보를 설정하는 방법
   => 서블릿 클래스를 등록한다.
      <servlet>...</servlet>
   => 서블릿 클래스에 URL을 지정한다.
      <servlet-mapping>...</servlet-mapping>
   => HelloWorld3

4. 웹 브라우저로 출력하는 방법: HelloWorld4
  => ServletResponse 객체를 통해 출력 스트림을 얻는다.
      PrintWriter out = response.getWriter();
  => 이 출력 스트림은 무조건 ISO-8859-1 형식으로 인코딩한다.
     자바소스(UTF-8)--> JVM(Unicode) ---> 출력(ISO-8859-1)
     => ISO-8859-1에 정의되지 않은 문자는 모두 ?로 바뀐다.
     => 한글 깨진다.
     => 해결책!
        출력스트림을 얻기 전에 어떤 문자표를 사용하여
        Unicode를 바꿀 것인지 지정하라!    
     response.setContentType("text/plain;charset=UTF-8");

5. 웹 브라우저로부터 데이터를 입력 받기: HelloWorld5
  => 웹 브라우저가 보낸 데이터를 "파라미터"라고 부른다.
  => 파라미터 값 꺼내기: 
     ServletRequest의 getParameter("파라미터명") 호출한다.

6. 스프링 IoC 컨테이너를 사용할 수 있도록 도우미 클래스 작성.
  => context.MyApplicationContext
  => 객체를 오직 한 개만 만들 수 있도록 설계한다.
     => Singleton 패턴 적용
        1) 생성자를 private으로 막아서 다른 클래스가 
           임의로 객체를 생성하지 못하게  한다.
        2) 인스턴스를 저장할 스태틱 변수를 만든다.
        3) 객체를 리턴해 줄 스태틱 메서드를 만든다.
        => 객체를 한 개만 만들도록 제약하는 설계 기법.

6. BoardApp의 모든 컨트롤러를 서블릿을 변환하라!     

[step02: HTTP 프로토콜]
- 프로토콜?
  클라이언트와 서버 사이에 주고 받는 데이터 형식
- HTTP 프로토콜 Connectionless 방식이다.
- Connectionless?
  연결 -> 요청 -> 응답 -> 연결끊기
  => 단점: 매번 요청할 때마다 연결해야 한다.
  => 장점: 계속 연결되어 있지 않기 때문에, 
           적은 자원으로 더 많은 클라이언트 요청을 처리할 수 있다.
- 웹 브라우저 --> 웹 서버: 요청 프로토콜
request line(\r\n)
*[general | request | entity] header(\r\n)
\r\n
entity

* request line 형식
method sp request-URI sp HTTP-version(\r\n)

* header 형식
header-name: value

예)
GET /web02t/board/list.do HTTP/1.1(\r\n)
Host: localhost:9999(\r\n)
(\r\n)


- 웹 서버 --> 웹 브라우저: 응답 프로토콜
status line(\r\n)
*[general | response | entity] header(\r\n)
\r\n
entity(message body)       

* status line 형식
HTTP-version sp status-code sp status-phrase(\r\n)

예)
HTTP/1.1 200 OK(\r\n)
Content-type: text/plain;charset=UTF(\r\n)   
...
(\r\n)
20, aaa, ddd, 2015-07-22
...   

- 미니 웹 브라우저 만들기
  => util.MyWebBrowser

[step03: HTML로 UI 꾸미기]
Test01.html
  => HTML 구조
  => 1) DOCTYPE 선언 : <!DOCTYPE...>
  <HTML>
  => 2) HTML 문서의 정보: <HEAD>...</HEAD>
  => 3) HTML 문서의 본문: <BODY>...</BODY>
  </HTML>
   
   
   
   
   
   
   
   
   
   
    
   
   