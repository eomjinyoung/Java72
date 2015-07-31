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
2) class 속성의 사용
=> 보관소에 객체가 들어 있지 않다면 객체를 생성할 수 있다.
=> 단 객체를 생성할 때 사용할 클래스를 지정해야 한다. 
<jsp:useBean id="키" 
  type="꺼낸 객체를 저장할 레퍼런스의 타입"
  class="객체를 만들 때 사용할 클래스"
  scope="page|request|session|application"/>
=> 예)
<jsp:useBean id="names" 
  type="java.util.List<String>"
  class="java.util.Array"
  scope="request"/>

위의 코드는 다음 자바 코드와 같다.
java.util.List<String> names = 
  (java.util.List<String>)request.getAttribute("names");
if (names == null) {
  names = new java.util.Array();
  request.setAttribute("names", names);
}
          
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
    class="java.util.ArrayList"
    scope="request"/>
<%
for (String name: names) { %>
==> <%=name%><br>
<%} %>
<hr>
<%-- 해당 객체가 존재하지 않으면,
 class 속성에 지정된 객체를 생성한다. --%>
<jsp:useBean id="names2" 
    type="java.util.List<String>"
    class="java.util.ArrayList"
    scope="request"/>
<%
/*
java.util.List<String> names2 = 
  (java.util.List<String>)request.getAttribute("names2");
if (names2 == null) {
	names2 = new java.util.Array();
	request.setAttribute("names2", names2);
}
*/

names2.add("홍길동");
names2.add("오호라");
for (String s : names2) {%>
----> <%=s%><br>
<%}%>

<hr>

<%--
class 속성이 있을 때, type 속성을 생략할 수 있다.
 --%>
<jsp:useBean id="names3" 
    class="java.util.ArrayList"
    scope="request"/> 
<%
/*
java.util.ArrayList names3 = 
  (java.util.ArrayList)request.getAttribute("names3");
if (names3 == null) {
  names3 = new java.util.Array();
  request.setAttribute("names3", names3);
}
*/
names3.add("유관순");
names3.add("안중근");
for (Object s : names3) {%>
----> <%=s%><br>
<%}%>   
    
</body>
</html>






