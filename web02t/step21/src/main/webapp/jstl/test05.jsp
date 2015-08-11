<%@ page language="java" 
          contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8"%>
<%-- 반복문 --%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
           prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안녕!</title>
</head>
<body>
<h1>c:forTokens</h1>
<%-- 
items="aaa,bbb,ccc,ddd,eee"
var="항목의 이름"
delims="구분자"
--%>    
<%
pageContext.setAttribute("names",
    "홍길동,임꺽정,유관순,안중근,윤봉길");
%>
<ul>
<c:forTokens var="name" items="${names}" delims=",">
  <li>${name}</li>
</c:forTokens>
</ul>

<%
pageContext.setAttribute("querystring",
    "no=2&title=aaaa&content=bbbb&writer=okok");
%>
<ul>
<c:forTokens var="p" items="${querystring}" 
              delims="&">
  <li>${p}</li>
</c:forTokens>
</ul>
</body>
</html>








