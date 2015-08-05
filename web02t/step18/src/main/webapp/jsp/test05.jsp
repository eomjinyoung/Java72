<%@ page language="java" 
          contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8"%>
<%-- 
JSP의 구성요소: 
=> 템플릿 데이터, JSP 액션 태그, 스크립트릿(scriptlet), 
   표현식(expression element), 선언문(declaration element),
   지시문(directive element)

5. 선언문: 서블릿 클래스에 멤버(변수,메서드)를 추가할 때 사용.
=> <%! 변수나 메서드 선언 %>
=> 선언된 자바 코드는 클래스 선언 밑에 복사된다.
   => 스태틱 변수와 메서드, 인스턴스 변수와 메서드,
      스택틱 블록, 인스턴스 블록
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안녕!</title>
</head>
<body>
10 + 20 = <%= plus(10, 20) %>
</body>
</html>
<%!
private int plus(int a, int b) {
  return a + b;
}
%>





