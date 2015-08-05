<%@ page language="java" 
          contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8"%>
<%-- 
JSP의 구성요소: 
=> 템플릿 데이터, JSP 액션 태그, 스크립트릿(scriptlet), 
   표현식(expression element), 선언문(declaration element),
   지시문(directive element)

4. 표현식: 소스 코드에 생성될 출력문을 간단히 만드는 방법.
=> 예전방식: <%out.print(board.getNo());%>
=> 표현식: <%=board.getNo()%>

--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안녕!</title>
</head>
<body>
<%
String name = "홍길동";
int age = 20;
%>
<h1>신상 정보</h1>
이름: <%out.print(name);%><br>
나이: <%out.print(age);%><br>
------------------------------<br>
이름: <%=name%><br> <%-- out.print(name); --%>
나이: <%=age%><br> <%--out.print(age); --%>
</body>
</html>





