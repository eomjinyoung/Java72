[톰캣 테스트 환경 구축]
1. Eclipse에 톰캣 홈 디렉토리 등록한다.
  => Window(메뉴) -> Preferences 
      -> Server(노드) -> Runtime Environments
      [Add] 클릭 -> 등록할 서버 선택 (Apache Tomcat 8.0 선택)
    [Next] 클릭 -> 톰캣을 설치한 폴더를 등록한다.
    [Finish] 클릭 -> 창 닫는다.

2. 톰캣 테스트 환경 구축
  => [Servers] 뷰에서 -> 새 서버 추가 
     테스트 환경으로 추가할 서버 선택 -> 
     테스트 환경 이름 입력(server name: bit server) ->
     [Finish] 버튼 클릭 => Servers 프로젝트가 생성된다.
  => Servers/bit server-config 폴더가 생성된 것을 확인할 수 있다.
     해당 폴더에서 톰캣 홈 디렉토리에서 복사해 온 설정파일이 있다.
     
3. 톰캣 테스트 환경에 구축한 설정 파일을 바탕으로 톰캣을 실행한다.
    [Servers] 뷰 -> 실행할 테스트 환경 선택 -> 플레이 버튼 클릭
  => [Console] 뷰를 통해 오류가 없는지 확인한다.
  => [Servers] 뷰를 보면 started로 되어 있다.
  => 웹 브라우저를 통해 서버가 실행되었는 지 확인한다.
     http://localhost:9999
     => 출력 화면을 보면 Http status 404 오류 내용이 보인다.
        이유: 테스트 환경에 어떤 웹 애플리케이션도 등록하지 않았기 때문에

4. 톰캣 테스트 환경의 실제 배치 폴더 확인한다
    => 프로젝트의 워크스페이스 폴더 / .metadata / .plugins 
      / org.eclipse.wst.server.core / tmp0
  => 해당 폴더를 즐겨 찾기에 등록한다.


[웹 애플리케이션 프로젝트 준비]
1. 웹 애플리케이션 프로젝트 생성
- 톰캣 테스트 환경에 자동 배치할 수 있는 프로젝트이다.
  => [File] 메뉴 -> New -> Dynamic Web Project
  => 프로젝트 이름: web01
     target runtime: 배치할 서버를 선택 
     dynamic web module version: 서블릿 명세 버전
  => [Next] => [Next] => Web Model 설정 화면
    Context Root: 웹 애플리케이션 이름
                   나중에 배치할 때 이 이름으로 폴더를 만든다.
           기본 값이 프로젝트 이름으로 되어 있다.
    Content Directory: HTML, CSS, JavaScript, GIF, JSP 등
                       웹 애플리케이션 파일을 두는 폴더.
    Generate web.xml Deployement Descriptor: 
                          웹 애플리케이션 설정파일(web.xml)을 
                          자동으로 생성할 지 여부 지정.             
  
  => [Finish] 
2. 웹 애플리케이션 폴더 확인한다
   /src  : 자바 소스 또는 .properties, .xml 파일을 둔다.
   /WebContent: 기타 웹 파일을 둔다.
   /build : 컴파일된 클래스 파일을 둔다.
    
[HelloWorld 서블릿 만들고 실행해 보기]
1. src/HelloWorld.java 파일 생성
2. Servlet 인터페이스 구현
   => 모든 메서드 정의한다.
   => 각 메서드에 출력문을 추가한다.
3. 클래스 선언부에 @WebServlet 애노테이션을 추가한다.
   => 클라이언트에서 사용할 URL을 지정한다.
   => 즉 해당 URL로 요청이 들어오면 톰캣은 지정된 클래스의 
      service() 메서드를 호출한다. 

[톰캣 서버에 web01 프로젝트를 배치한다]
1. [Servers] 뷰에서 테스트 환경을 선택한다.
2. 컨텍스트 메뉴 -> [Add and Removes...] 메뉴 클릭
3. 프로젝트 선택 후 추가 버튼[>] 클릭 => [Finish] 버튼 클릭
4. 테스트 환경 실행 
   => [Console] 뷰에 오류가 있는지 확인할 것.
5. 웹 브라우저에서 HelloWorld 프로그램 실행 요청
   http://서버주소:포트번호/컨텍스트루트/프로그램URL이름
   예) 
   http://localhost:9999/web01/hello
   => 화면에 아무것도 출력하지 않으면 성공!
      서버 콘솔창을 확인하라!
  



















    
    