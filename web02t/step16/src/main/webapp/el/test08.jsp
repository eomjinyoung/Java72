<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="net.bitacademy.java72.domain.Member"%>
<%@ page language="java" 
          contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8"%>
<%-- 연산자의 사용
   
 --%>
      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안녕!</title>
</head>
<body>
<h1>산술 연산자</h1>
\${10 + 20} = ${10 + 20}<br>
\${10 - 20} = ${10 - 20}<br>
\${10 * 20} = ${10 * 20}<br>
\${10 / 20} = ${10 / 20}<br>
\${10 % 20} = ${10 % 20}<br>
\${10 div 20} = ${10 div 20}<br>
\${10 mod 20} = ${10 mod 20}<br>

<h1>논리 연산자</h1>
\${true && false} = ${true && false}<br>
\${true || false} = ${true || false}<br>
\${!true} = ${!true}<br> 
\${true and false} = ${true and false}<br>
\${true or false} = ${true or false}<br>
\${not true} = ${not true}<br>

<h1>관계 연산자</h1>
\${10 == 11} = ${10 == 11}<br>
\${10 != 11} = ${10 != 11}<br>
\${10 < 11} = ${10 < 11}<br>
\${10 <= 11} = ${10 <= 11}<br>
\${10 > 11} = ${10 > 11}<br>
\${10 >= 11} = ${10 >= 11}<br>
\${10 eq 11} = ${10 eq 11}<br>
\${10 ne 11} = ${10 ne 11}<br>
\${10 lt 11} = ${10 lt 11}<br>
\${10 le 11} = ${10 le 11}<br>
\${10 gt 11} = ${10 gt 11}<br>
\${10 ge 11} = ${10 ge 11}<br>

<h1>empty 연산자</h1>
<p>값이 비어있거나 null 경우를 검사하는 연산자이다.</p>
<%
pageContext.setAttribute("name", "홍길동");
%>
\${empty name} = ${empty name}<br>
\${empty name2} = ${empty name2}<br>
</body>
</html>



















