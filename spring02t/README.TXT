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








