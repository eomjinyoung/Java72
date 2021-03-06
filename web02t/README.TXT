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
=> webapp/html/*.html
=> Base64Generator.java
   => 바이너리 데이터를 Base64 형식의 문자열로 변환해 주는 클래스.
=> BoardApp의 출력에 HTML, CSS 적용
=> MIME Type: Multi-purpose Internet Mail Extension
   - 메일에 첨부되는 콘텐츠의 타입을 지정하기 위해 만든 문법
   - 현재는 웹 등에서 널리 사용되고 있다. 

[step04: 화면이동]
- Refresh와 Redirect를 이용한 화면이동 기법
- servlet.ex1
  => Refresh 적용 전
  => 화면을 이동하고 싶으면 직접 요청해야 한다.
- servlet.ex2
  => <meta> 태그를 이용한 페이지 자동 요청하기.      
- servlet.ex3
  => 응답 헤더에 Refresh 정보를 둔다.
- servlet.ex4
  => Redirect를 이용한 화면 이동
  => Redirect는 웹 브라우저에게 콘텐츠를 보내지 않는다.
  => 웹 브라우저에 출력하는 것 없이 다른 화면으로 이동하는
     효과를 거둘 수 있다.   
     
       
[step05: GET과 POST 방식의 차이점 이해]
ex1.LogIn
- GET 방식으로 서버에 값을 보내는 방법
- 서버에서 값을 꺼내는 방법   
- GET 요청 프로토콜 형식
method sp request-uri sp http-version(CRLF) <== request line: 
header-name : value(CRLF) <== header(0개이상): 
(CRLF):  <== empty line

- GET 요청 프로토콜 예 
GET /web02t/step05/ex1/LogIn?id=aaa&pwd=bbb HTTP/1.1
Host: localhost:9999
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
User-Agent: Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.89 Safari/537.36
HTTPS: 1
Referer: http://localhost:9999/web02t/step05/ex1/form.html
Accept-Encoding: gzip, deflate, sdch
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4
   
- 특징  
  => GET 요청은 데이터를 Request-URI에 붙여서 보낸다.
  => 단점
  1) 웹 브라우저의 주소 창에 데이터가 보인다. 
     => 중요 정보가 노출될 수 있다. 
  2) 보통 웹 브라우저는 URL을 임시 보관한다.
     => 다른 사람이 URL을 입력할 때 기존에 입력한 
        URL을 보여줄 수 있다.
  3) URL은 문자열로 구성된다.
     => 바이너리 데이터 전송 불가!
  4) 각 웹 서버마다 요청 헤더의 크기가 제한되어있다.
     예) 톰캣서버는 8KB, IIS6는 16KB
     => 대용량의 데이터를 전송할 수 없다.
  => 장점
  1) URL에 서버에 보내는 데이터가 포함되기 때문에
     다른 사람에게 전달하기 쉽다.
     예) 검색 결과, 게시물 조회 등.
  2) 즐겨 찾기에 추가할 수 있다.     
   
- POST 요청 프로토콜 형식
method sp request-uri sp http-version(CRLF) <== request line
header-name: value(CRLF)  <== 0개 이상
(CRLF)
message-body  <== 서버에 보내는 데이터

- POST 요청 프로토콜 예
POST /web02t/step05/ex1/LogIn2 HTTP/1.1
Host: localhost:9999
Content-Length: 16
Cache-Control: max-age=0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
Origin: http://localhost:9999
User-Agent: Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.89 Safari/537.36
HTTPS: 1
Content-Type: application/x-www-form-urlencoded
Referer: http://localhost:9999/web02t/step05/ex1/form2.html
Accept-Encoding: gzip, deflate
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4

id=aaab&pwd=bbbb 

- 특징
  => 데이터를 message-body 영역에 붙여서 보낸다.
  => 장점
  1) 바이너리 데이터 전송 가능(단, multipart/form-data형식)
  2) 대용량 데이터 전송 가능(서버에서 허락하는 한도 안에서는)
  3) 웹 브라우저 주소 창에 노출되지 않는다.
  => 단점
  1) 즐겨 찾기에 추가할 때 데이터가 제외된다.
     => 검색어나 게시물 번호가 저장되지 않기 때문에
        도움이 안된다.
    
- CRLF: 타자기의 줄 바꿈을 흉내 냄.
  1) CR(Carrage Return): 0d
  2) LF(Line Feed) : 0a   
  3) 윈도는 CRLF, 유닉스는 LF만 사용한다.
  
- BoardApp의 등록과 변경 폼에 POST 방식 적용

- 한글 깨지는 현상
  입력(ISO-8859-1)  ---> Unicode ---> 출력(ISO-8859-1)
  1) 읽어 들인 글자를 올바르게 Unicode로 바꾸기
     최초로 getParameter()를 호출하기 전에,
     request.setCharacterEncoding("UTF-8")을 호출하라!
  2) 출력 스트림을 얻기 전에 출력할 문자표를 설정하라.
     response.setContentType("text/html;charset=UTF-8");    

- BoardApp에 한글 처리 추가하라!
  => BoardInsert, BoardUpdate, MemberInsert, MemberUpdate   
   
[step06: GET과 POST를 구분해서 처리하기]
1) servlet.ex1.LogIn : GET과 POST를 구분하지 않는다.
2) servlet.ex2.LogIn : POST 요청에 대해서만 처리한다.
3) servlet.ex3 :
  => service() 메서드의 파라미터 값을 자동으로 형변환 하기
  => HttpGenericServlet 추상 클래스 정의
  => LogIn 서블릿은 이 추상 클래스를 상속 받는다.
4) servlet.ex4 :
  => GET과 POST를 자동 구분하기
  => HttpGenericServlet 추상 클래스에 
     doGet(), doPost() 메서드 추가
5) servlet.ex5:
  => 자바에서 제공해 주는 HttpServlet 클래스를 상속 받음.
6) BoardApp의 모든 서블릿을 HttpServlet 클래스를 상속 받도록
   변경할 것.
       
[step07: 예외 처리]
예외처리
1) 예외 종류
  => 시스템 예외(Error 계열):
      - JVM이 처리하는 예외로서 개발자가 다루는 대상이 아님.
  => 애플리케이션 예외(Exception 계열)
      - 애플리케이션에서 발생하는 예외로서
        개발자가 처리해야 한다.
      - RuntimeException 예외
        : 애플리케이션 예외를 최상위 호출자에게
          조용히 전달할 때 사용.
예제1: 예외 발생하지 않는 경우.
  => A.main() --> B.m() --> C.m() --> D.m()
예제2: 애플리케이션 예외가 발생하는 경우
  => A.main() --> B.m2() --> C.m2() --> D.m2()
  => D.m2()에서 발생하는 예외를 처리하기 위해
     중간의 메서드들은 반드시 throws Exception을 
     선언해야 한다.
예제3: RuntimeException을 통해 조용히 상위 호출자에게
       예외 전달하기.
  => RuntimeException은 메서드 선언부에 
     throws 절을 넣지 않아도 된다.
  => 중간 호출자(메서드)를 간결하게 만들 수 있다.   
         
2) DAO에서 예외처리 하던 것을 호출자에게 위임한다.
  => mybatis의 SqlSession 메서드는 
     RuntimeException 계열의 예외를 던진다.
     따라서 mybatis의 메서드를 사용할 때 굳이
     메서드 선언부에 throws 절을 넣을 필요가 없다.
  => BoardDao, MemberDao
  
* try ... finally 
  => 예외가 발생하면 어차피 호출자에게 전달할 것인데,
     try 블록을 사용하는 이유는 무엇인가?
     => finally를 사용하여 자원을 해제하기 위해.   

[step08: forward]
- 다른 서블릿으로 실행을 위임한다.
  위임한 후 이전 서블릿으로 되돌아 올 수 없다.
- 예외 처리를 전담하는 서블릿을 만들고,
  예외가 발생했을 때 그 서블릿으로 실행을 위임하기. 
  1) ErrorServlet 클래스 작성
  2) BoardXxxx, MemberXxxx 서블릿에서 ErrorServler으로 포워딩
    
- 포워딩 대상 서블릿으로 데이터(또는 객체) 보내기
  ServletRequest 보관소에 저장하여 보낸다.
   
[step09: include]
- 다른 서블릿의 실행 결과를 포함하는 방법
- 여러 서블릿의 실행 결과를 합쳐서 페이지를 만들 경우 사용.
1) 페이지 꼬리말 서블릿 만들기
   => FooterServlet
2) 페이지 머리말 서블릿 만들기
   => HeaderServlet
3) 목록과 상세 페이지에 꼬리말과 머리말을 포함한다.
   => BoardList, BoardDetail, MemberList, MemberDetail
   
[step10: Filter 활용]
- 서블릿 실행 전/후에 특정 작업을 끼워 넣는 기술이다.
- 소스 코드 변경없이 web.xml의 선언 순서를 바꿈으로써
  필터 실행 순서를 조종할 수 있다.
- Design Patterns에 소개된 방법중
  "Chain of Responsibility" 설계 기법을 적용한 예이다.
  즉, 기능을 삽입하고 삭제하기가 매우 쉽다.
- javax.servlet.Filter 인터페이스를 구현하면 된다.
- 배치 방법
  => web.xml에 필터를 등록하고, 
     어떤 URL에 대해서 끼워 넣을 건지 지정한다.    
실습1)
  => MyServlet, MyFilter1, MyFilter2, MyFilter3

실습2)
  => BoardInsert, BoardUpdate, MemberInsert, MemberUpdate를 
    실행하기 전에 클라이언트가 보낸 데이터의 문자표를 지정한다.
  => CharacterEncodingFilter 클래스 작성
  => web.xml에 적용하기
  => BoardInsert, BoardUpdate, MemberInsert, MemberUpdate 클래스에서
     request.setCharacterEncoding() 제거하기    
- 필터 초기화 파라미터
  => 필터에서 사용할 상수 값을 외부 파일(web.xml)에 두고
     필요할 때 꺼내서 쓴다.
  => web.xml에 필터가 사용할 상수 값을 두기.


   
[step11: ServletContextListener]
- 서블릿 컨테이너도 다양한 상황에 대해 이벤트를 발생시킨다.
  예) 서버가 시작되었을 때 이벤트 발생.
      서버가 종료될 때 이벤트 발생
      사용자의 요청이 들어왔을 때 이벤트 발생
      세션이 준비되었을 때 이벤트 발생
      ...   
- ServletContextListener는 
  서블릿 컨테이너가 시작하거나 종료할 때 발생되는 
  이벤트를 처리하는 클래스가 따라야 하는 규칙이다.
  즉, 시작/종료 보고를 받고 싶으면
  이 인터페이스 구현하라! 
  1) ContextLoaderListener 클래스 작성  
  2) contextInitialized() 메서드를 구현한다.
    => 스프링 컨테이너를 ServletContext에 보관한다.
  3) web.xml에 스프링 설정 파일의 경로를 등록한다.

- ServletContext에 보관된 스프링 빈 컨테이너를 사용하도록
  서블릿을 모두 변경한다.
    
[step12: 로그인 화면 만들기]
1) 로그인 화면 만들기: /auth/LoginForm.html
2) 로그인 처리 서블릿 만들기: LoginServlet 클래스 작성
3) 사용자 인증 메서드 추가: MemberDao.exist() 메서드 작성
4) 사용자 조회 SQL 추가: MemberDao.xml에 select문 추가

[step13: 쿠키 다루기]
- 쿠키(Cookie)?
  => 웹 서버가 웹 브라우저에 임시적으로 맡기는 데이터
  => 문자열만 가능
  => 응답 헤더에 쿠키 정보를 실어서 보냄
- 실습1)
  1) 웹 브라우저에게 쿠키 보내기
    => 쿠키 생성 
       Cookie cookie = new Cookie("name", "hong");
    => 응답 헤더에 싣는다. 
       response.addCookie(cookie);
    => 응답 프로토콜 예)
HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Set-Cookie: name=hong
Content-Type: text/html;charset=UTF-8
Content-Length: 53
Date: Tue, 28 Jul 2015 03:41:14 GMT

    => 웹 브라우저는 서버로부터 받은 쿠키 정보를 
        메모리에 보관한다. 
     => 웹 브라우저를 끄면 쿠키 정보가 사라진다.
  2) 웹 브라우저에서 웹 서버로 쿠키 보내기 
    => 서버에 요청할 때마다 그 서버가 맡긴 쿠키를 
       요청 헤더에 실어서 다시 보낸다.
    => 요청 프로토콜 예)
GET /web02t/study/ex1/test01 HTTP/1.1
Host: localhost:9999
Connection: keep-alive
Cache-Control: max-age=0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.107 Safari/537.36
Accept-Encoding: gzip, deflate, sdch
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4
Cookie: name=hong; age=20   

-실습2)
  => 다른 경로의 서블릿에게도 쿠키를 전달하기
  => 쿠키에 경로 정보를 추가하라!
  cookie.setPath(URL);
  
-실습3)
  => 쿠키의 유효기간 설정하기
  => 쿠키에 유효기간을 설정하면 웹 브라우저를 종료하더라도
     유지된다. 왜? 메모리가 아닌 하드 디스크에 저장되기 때문이다.   
  => 유효기간이 지난다면?
     삭제한다. 계속 감시하는 것이 아니라,
     서버에 보내려는 시점에 유효기간을 검사하고,
     유효기간이 지났다고 판단되면 그 때 삭제한다.   
   
-실습4)
  => 로그인 폼에 "이메일 기억하기" 체크상자 추가
  => 로그인 폼을 LoginServlet 에서 출력하도록 변경
  => /webapp/auth/LoginForm.html 파일 삭제
  => doPost()에서 이메일 쿠키 정보 출력하도록 변경    
   
[step14: 세션 다루기]
-실습1) study.ex1.*
  => ServletReqeust를 이용하여 서블릿끼리 데이터 공유하기 
     => 실패!
     => ServletRequest는 매 요청마다 생성되고 
        응답한 후 소멸된다.
-실습2) study.ex2.*
  => ServletContext를 이용하여 서블릿끼리 데이터 공유하기
     => 여러 요청이 공유하기 때문에 데이터를 덮어쓰는 문제 발생

-실습3) study.ex3.*
  => HttpSession을 이용하여 서블릿끼리 데이터 공유하기
  => request.getSession() 내부 프로세스
     요청 헤더에 세션ID를 담은 쿠키가 있는가?
        => no: HttpSession 객체를 생성하여 리턴한다.
        => yes: 세션ID가 유효한가?
           => no: HttpSession 객체를 생성하여 리턴한다.
           => yes: 기존 HttpSession 객체를 리턴한다.
         
-실습4) 세션을 로그인 서블릿에 적용하기
  => LoginServlet 변경: HttpSession에 로그인 정보 저장
  => LoginInfoServlet 추가: 로그인 정보 출력하는 서블릿 
  => BoardList, BoardDetail, MemberList, MemberDetail
     클래스에서 LoginInfoServlet을 인클루드한다.
  => LogoutServlet 추가: 로그아웃 기능 추가
  => referer 요청 헤더 처리
     => 로그인 처리 후 원래 페이지로 리다이렉트 시키기.   
   
[step15: 파일 업로드]
1. 파일 업로드 폼을 만든다.
  => /upload/uploadForm.html
  => 파일은 <input type="file" name="photo">
  => 파일을 서버에 보내려면 form의 인코딩 형식을
     multipart/form-data 로 설정해야 한다.

2. 멀티파트 데이터 처리하는 서블릿 만들기
  => 멀티파트 형식으로 전송된 데이터를 
     getParameter()로 꺼낼 수 없다.
  => 멀티파트 형식에 따라 데이터를 잘라서 써야한다.
     => apache의 fileupload 라이브러리를 사용하자!     

3. 게시판과 회원 관리에 파일 업로드 적용
  => 게시판 첨부파일 추가
  => 회원 정보에 사진 추가
  
[step16: JSP를 활용하여 화면 출력을 쉽게 하자]
- JSP 구동 원리
1) /jsp/hello.jsp 작성
2) 웹 브라우저에서 JSP 요청
3) JSP 엔진이 hello.jsp를 가지고 
   hello_jsp.java 파일을 생성한다.
   => 파일 위치
      .tmp0/work/.../jsp/hello_jsp.java
4) 컴파일된 클래스 파일을 실행한다.

- JSP 엔진이 만든 클래스
1) Servlet 객체이다.
   => hello_jsp ---> HttpJspBase(Tomcat) ---> HttpServlet --->...
       
2) JSP 파일을 가지고 서블릿 클래스를 만들 때는 
   => 반드시 javax.servlet.jsp.HttpJspPage 인터페이스를 
      구현해야 한다.
3) HttpJspPage 인터페이스
   => HttpJspPage ---> JspPage ---> Servlet

- BoardList에 JSP 적용하기
1) 헤더 부분 JSP로 만들기
   HeaderServlet --> /Header.jsp
2) 풋터 부분 JSP로 만들기
   FooterServlet --> /Footer.jsp
3) 로그인 정보 부분 JSP로 만들기
   LoginInfoServlet --> /LoginInfo.jsp   

[step17: Front Controller의 도입]
- 클라이언트의 모든 요청을 받는 서블릿
- 기존 컨트롤러는 서블릿이 될 필요가 없다.
- 기존 컨트롤러의 공통 기능을 수행한다.
- 기존 컨트롤러를 "페이지 컨트롤러"라 부른다.
1) 프론트 컨트롤러 만들기
  => DispatcherServlet 클래스 작성
2) 기존의 서블릿 클래스를 POJO로 바꾸기

[step18: 리플렉션 API - 메서드의 파라미터 분석]
- study.ex1
1) 메서드 파라미터 분석하기
2) 파라미터 변경자 분석하기
3) 비트 연산자 활용
   => 값 안에 여러 개의 값을 넣는 방법    
4) 가변 개수의 파라미터 값 처리하기    
- 프론트 컨트롤러 변경
- 페이지 컨트롤러 변경

[step19: 스프링 MVC 적용]
1) Spring MVC 프레임워크 의존 라이브러리 추가
2) DispatcherServlet를 스프링 클래스로 적용
   => web.xml 변경
   => application-context.xml을 WEB-INF/conf/ 폴더로 이동
3) CharacterEncodingFilter를 스프링 클래스로 교체
   => web.xml 변경
4) @RequestMapping을 스프링 애노테이션으로 교체
   => ...control 패키지의 클래스들 변경   
   
[step20: 스프링 MVC 적용2]
- CRUD 기능을 한 클래스로 묶는다.   
  => BoardController, MemberController, AuthController 클래스 생성
- DAO 클래스 제거 => Mybatis의 자동화 기능 사용.
  => 개발자는 더이상 DAO 클래스의 반복적인 코드를
     작성할 필요가 없다.
     Mybatis에서 자동으로 처리한다.
     단지 SQL 맵퍼 파일에 선언된 name 스페이스의 이름과
     인터페이스의 이름을 같게 하라.
     물론 SQL 아이디의 이름과 메서드 이름을 같게 하라.   
  => 기존의 Dao 클래스를 인터페이스로 선언한다.
1) BoardDao
  => 인터페이스로 바꾼다.
  => BoardDao.xml(SQL 맵퍼파일)에 선언된 네임스페이스 이름과
     인터페이스 이름을 같게 하라.
  => SQL 아이디의 이름과 인터페이스 메서드 이름을 같게하라.
  => SQL 맵퍼 파일과 DAO 인터페이스를 연결해 줄 객체를
     스프링 설정 파일에 추가한다.
     <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" 
             value="net.bitacademy.java72.dao" />
      </bean>
2) MemberDao
  => 인터페이스로 바꾼다.
  => Mybatis의 SQL 맵퍼와 자동으로 연동하려면
     메서드의 파라미터가 반드시 SQL 맵퍼 파일과 일치해야 한다. 
  => exist(email, password) --> exist(map) 바꾼다.
3) AuthController
  => MemberDao.exist(map)을 호출하도록 변경한다.  
  
[step21: 트랜잭션 다루기]
* 트랜잭션(transaction)
  => 여러 개의 작업을 한 단위의 작업으로 묶은 것.
  => 묶인 작업을 모두 성공했을 때 작업을 완료(commit)한다.
  => 만약 하나라도 실패하면 중간에 작업했던 것을 취소(rollback)한다.  

* DBMS의 트랜잭션
  => DML 작업(insert,update,delete)은  임시 테이블에 저장된다.
  => 사용자가 commit을 요청할 때 비로서 임시 테이블의 작업 결과를
     실제 테이블에 적용한다.
  => 만약 사용자가 rollback을 요청하면 임시 테이블에 저장된 작업 결과를
     삭제한다.   
  
* 실습
  => spring02t/step13 참조
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
     
* 실습
0) 의존 라이브러리 추가
  => aspectjweaver 라이브러리 추가
      
1) web.xml 파일 설정
  => ContextLoaderListener 및 컨텍스트 파라미터 설정
  => DispatcherServlet의 설정 파일 이름 변경

2) dispatch-servlet.xml 파일 생성
  => 기존의 application-context.xml 파일을 복사한다.
  => 웹 관련 객체 설정만 남겨두고 나머지는 제거한다.  

3) application-context.xml 파일 변경
  => 웹 관련 객체 설정을 제외한다.
  => 트랜잭션과 관련된 설정 추가
  => DataSource 객체는 JNDI에서 찾도록 설정을 변경한다.   

4) service 컴포넌트 추가
  => 인터페이스 생성: 
     BoardService, MemberService, AuthService
  => 구현체 생성: 
     BoardServiceImpl, MemberServiceImpl, AuthServiceImpl 
  
5) 페이지 컨트롤러 변경
  => DAO를 사용하는 대신 Service 객체를 사용하도록 변경한다.
       
[step22: View 컴포넌트 감추기]
- 뷰 컴포넌트를 클라이이언트에 직접 요청하지 못하게 만든다.
- 모든 JSP를 /WEB-INF/ 폴더로 옮긴다.
1) /WEB-INF/jsp 폴더 생성
2) JSP를 이 폴더로 옮긴다.
  => 페이지 컨트롤러가 include/forward 하는 JSP만 옮긴다.
3) /WEB-INF/jsp 폴더에 있는 JSP를 찾아서 실행시킬 관리자를 교체한다.
- 뷰 컴포넌트를 찾아서 실행하는 관리자를 "View Resolver"라고 부른다.
  => 기존 관리자는 페이지 컨트롤러가 리턴한 JSP 주소를
     컨텍스트 루트에서 찾아 실행하였다.
  => 이 관리자 대신 /WEB-INF/jsp에서 JSP 파일을 찾아 실행시켜 줄
     관리자로 교체하는 것이다.     
4) 페이지 컨트롤러의 리턴 값을 교체한 뷰 리졸버에 맞추어 변경한다.
  => 이전 리턴 값: /board/BoardList.jsp
  => 변경 후 리턴 값: board/BoardList  
  
[step23: CSS 다루기]  
1) CSS 사용법 :  webapp/css
2) BoardApp에 부트스트랩 적용
3) JavaScript 프로그래밍: webapp/javascript
4) JSON 사용 : webapp/javascript/ex6/step04
 
[step24: 페이징 처리]
1) BoardDao.xml 변경
2) BoardDao 인터페이스의 list() 변경
3) BoardService 인터페이스 변경
4) BoardServiceImpl 클래스 변경 
5) BoardController 클래스 변경
* 멤버도 게시판과 같이 처리한다.
  
[step25: AJAX를 이용한 이메일 중복 검사]
1) MemberDao.xml 변경
2) MemberDao 인터페이스 변경  
3) MemberService 인터페이스 및 구현체 변경
4) MemberController 클래스 변경

[step26: BoardApp을 back-end server와 front-end로 분리]
1) javascript 기본 API를 사용하여 게시물 목록 페이지 만들기 
=> /webapp/json/board.html
=> /webapp/json/app.js (백업: app01.js)
=> /webapp/json/common.css
=> bootstrap 도입

2) 간편 라이브러리 만들기
=> DOM API를 쓰기 좋게 포장하기
=> /webapp/json/js/bit.js
=> /webapp/json/app.js 변경 (백업: app02.js)

3) AJAX 함수 추가
=> ajax를 사용하기 쉽게 함수 만들기: bit.ajax()
=> /webapp/json/js/bit.js 변경

4) getJSON() 함수 추가
=> ajax를 사용하기 쉽게 함수 만들기: bit.getJSON()
=> /webapp/json/js/bit.js 변경
  
5) document.querySelectorAll() 함수 처리

6) 페이지 이벤트 처리
app0601: 
=> 이전, 다음 버튼의 상태 변경
=> 이전, 다음 버튼의 링크 정보 설정

app0602:
=> bit.js 변경 : removeAttr(), click() 함수 추가
=> removeAttr(), click() 사용

app0603: 
=> Back-end 개발
  => json.BoardController 클래스 추가
  => /WEB-INF/jsp/json/board/BoardList.jsp 파일 추가
=> Front-end 벼경
  => app.js에서 서버 URL 변경
  
[step27: 페이지 컨트롤러에서 직접 JSON 데이터 출력하기]
=> Google json 라이브러리 다운로드
   => build.gradle에 의존 라이브러리 정보 설정
=> /json/board/*, /json/board/*
=> json.BoardController, json.MemberController 
  
[step28: jQuery 도입]
=> 전체에 jQuery 적용
1) 로그인 및 로그아웃 처리

[step29: 공통 코드 분리 및 로딩]
1) 로그인 HTML 분리
   => login.html, login.js   
2) 로그인 HTML 로딩
   => $(selector).load(url)
3) HTML 템플릿 도입: 테이블 목록에서 tr 태그 생성을 간소화한다.
  => http://handlebarsjs.com/ 에서 라이브러리 파일 다운로드
  => /webapp/javascript/ex7/* 실습 예제 참고
  => board와 member에 적용   
     /webapp/json/board/*
     /webapp/json/member/*
   
[step30: main 페이지를 기준으로 메뉴 별 화면 로딩]
=> /webapp/json2/* 실습 파일 참조

[step31: OOP 리팩토리 -> 중복 로딩 제거]
=> common.js에 define(), requirejs() 함수 추가
=> auth.js, board.js, member.js 변경
=> auth.html, board.html, member.html 변경

[step32: requirejs를 도입하여 스크립트 중복 로딩 제거]
1) 디렉토리 구조 변경
2) requirejs.org에서 라이브러리 파일 다운로드
2) 기존 소스 변경

[step33: Spring 프레임워크에 JSON 뷰 리졸버 도입]
=> 클라이언트가 요청하는 것에 따라서 보낼 데이터를 선정하기
1) DispatcherServlet 설정 파일 변경
  => WEB-INF/conf/dispatch-servlet.xml 
   <bean class="org.springframework.web.servlet.view.ContentNegotiatingViewResolver">
    <!-- 4.2.x 버전에서는  mediaTypes 프로퍼티가 readonly임. 
        => 외부의 ContentNegotiationManager로 대체함.
    -->
    <!--  
    <property name="mediaTypes">
        <map>
            <entry key="atom" value="application/atom+xml"/>
            <entry key="html" value="text/html"/>
            <entry key="json" value="application/json"/>
        </map>
    </property>
    -->
    <property name="contentNegotiationManager" 
              ref="contentNegotiationManager"/>
    <property name="viewResolvers">
        <list>
            <bean class="org.springframework.web.servlet.view.BeanNameViewResolver"/>
            <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
                <property name="prefix" value="/WEB-INF/jsp/"/>
                <property name="suffix" value=".jsp"/>
            </bean>
        </list>
    </property>
    <property name="defaultViews">
        <list>
            <bean class="org.springframework.web.servlet.view.json.MappingJackson2JsonView" />
        </list>
    </property>
  </bean>
  
  <bean id="contentNegotiationManager" class="org.springframework.web.accept.ContentNegotiationManagerFactoryBean">
    <property name="favorPathExtension" value="false" />
    <property name="favorParameter" value="true" />
    <property name="mediaTypes" >
        <value>
            json=application/json
            xml=application/xml
            html=text/html
            atom=application/atom+xml
        </value>
    </property>
  </bean>
 
2) 페이지 컨트롤러 변경


[step34: AJAX 파일 업로드 및 회원 등록 시 메일 중복 검사]









   
   
   
   
   
   
   