<%@ page language="java" 
          contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8"%>
<%-- JSP 주석
=> JSP 엔진이 클래스를 만들 때 제거한다.

JSP의 구성요소: 
=> 템플릿 데이터, JSP 액션 태그, 스크립트릿(scriptlet), 
   표현식(expression element), 선언문(declaration element),
   지시문(directive element)

2. 스크립트릿(script + let(작은 조각) = scriptlet)  
=> 자바 코드를 삽입할 때 사용하는 태그다.
=> <% 자바 코드 %>
=> 작성된 순서대로 _jspService() 안에 복사된다.
--%>
<!DOCTYPE html>
<html>
<head>
<%
int a = 0;
%>
<meta charset="UTF-8">
<title>안녕!</title>
</head>
<%
a = 20;
%>
<body>
<h1>안녕하세요!</h1>
a = <%out.println(a);%>
</body>
</html>





