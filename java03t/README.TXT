[step01]
- 단순한 Client/Server 만들기

[step02]
- 여러 클라이언트 요청을 처리하기
- 문제점
  1) 한 번 연결이 되면 클라이언트에서 연결을 끊을 때까지
     계속 연결된 상태로 있다.
     => 서버 쪽 메모리 낭비.
  2) 클라이언트 요청을 순차적으로 처리한다.
     => 서버 자원을 최대로 활용할 수 없다.
     
[step03]
- 클라이언트 요청을 순차적으로 처리하는 문제 해결
  => 멀티 스레드 적용: BoardSkel 클래스 생성
  
[step04]
- 한 번 연결이 되면 클라이언트가 끊을 때까지 유지되는 문제
  => 속도가 떨어지더라도 좀 더 많은 클라이언트 요청 처리.
  => Connectionless 방식으로 전환
  
- 연결 방식
  1) Connectionful(stateful)
  연결 -> 요청 -> 응답 -> 요청 -> 응답 -> ... -> 끊기
  => 예) FTP, 아프리카TV, 채팅
  => 장점: 연결되어 있는 동안 클라이언트 정보를 계속 유지.
  => 단점: 메모리 낭비  
   
  2) Connectionless(Stateless)
  연결 -> 요청 -> 응답 -> 끊기 
  => 예) HTTP, 메신저    
  => 단점: 요청할 때마다 연결한다.
  => 장점: 더 많은 클라이언트 요청 처리.

 [step05]
 - C/S 환경을 BoardApp 프로젝트에 적용
 
 [step06]
 - BoardApp C/S를 웹 애플리케이션으로 전환하기
   1) 웹 애플리케이션 의존 라이브러리 추가
     apply plugin: 'war'
     ...
     providedCompile 'javax.servlet:javax.servlet-api:3.1.0'
   
   2) BoardServer 및 BoardSkel, BoardClient를 제거한다.
   3) 웹 애플리케이션 규칙에 따라 웹 브라우저의 요청을 
      받아서 처리할 클래스를 만든다. 
      => 스프링 프레임워크를 준비한다.
      => 요청에 해당하는 클래스를 찾아서 실행한다.
      => DispatcherServlet
   4) 의존 라이브러리 추출
      => build.gradle 파일에 다음 명령 추가
         task copyToLib(type: Copy) {
              into "$buildDir/output/libs"
              from configurations.runtime
         }
      => gradle build 수행 
         clean
         eclipse
         copyToLib
   4) 톰캣 서버에 배치
      => ${tomcat_home}/webapps/web01 폴더 생성
         * /web01 폴더를 웹 애플리케이션 루트라고 한다.
         * 다른 말로 컨텍스트 루트라고 한다.
      => ${contextRoot}/WEB-INF/classes 폴더 생성
      => 클래스 파일을 classes 폴더에 복사
      => ${contextRoot}/WEB-INF/lib 폴더 생성
         의존 라이브러리 파일을 lib 폴더에 복사
         serverlt-api는 제외한다.(이미 톰캣 서버에 있다.)
         
         








