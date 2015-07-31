<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" 
          contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8"%>
<%-- 
JSP의 구성요소: 
=> 템플릿 데이터, JSP 액션 태그, 스크립트릿(scriptlet), 
   표현식(expression element), 선언문(declaration element),
   지시문(directive element)

6. JSP 액션 태그: jsp:useBean 태그
1) 특정 보관소에서 객체를 꺼낸다.
<jsp:useBean id="키" 
  type="꺼낸 객체를 저장할 레퍼런스의 타입"
  scope="page|request|session|application"/>
=> 예)
<jsp:useBean id="boards" 
  type="java.util.List<Board>"
  scope="request"/>

java.util.List<Board> boards = 
  (java.util.List<Board>)request.getAttribute("boards");          
--%>
<%
List<String> nameList = new ArrayList<String>();
nameList.add("홍길동");
nameList.add("임꺽정");
nameList.add("유관순");

request.setAttribute("names", nameList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안녕!</title>
</head>
<body>
<h1>이름 목록</h1>
<jsp:useBean id="names" 
    type="java.util.List<String>"
    scope="request"/>
<%
/* 위의 태그는 다음 자바 코드와 같다.
List<String> names = 
  (List<String>) request.getAttribute("names");
*/
for (String name: names) { %>
==> <%=name%><br>
<%} %>

<%-- 해당 객체가 존재하지 않으면 예외 발생! --%>
<%-- 
<jsp:useBean id="names2" 
    type="java.util.List<String>"
    scope="request"/>
--%>
</body>
</html>






