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
<h1>c:forEach</h1>
<%-- 
items="배열|Collection|Iterator|Enumeration|Map|CSV"
var="항목의 이름"
begin="시작인덱스"
end="끝 인덱스"
--%>    
<h2>배열</h2>
<%
pageContext.setAttribute("names", 
    new String[]{"홍길동","임꺽정",
        "유관순","안중근","윤봉길"});
%>
<ul>
<c:forEach var="name" items="${names}">
  <li>${name}</li>
</c:forEach>
</ul>

<h2>배열: 1 ~ 3</h2>
<ul>
<c:forEach var="name" items="${names}"
            begin="1" end="3">
  <li>${name}</li>
</c:forEach>
</ul>

<h2>배열: 1 ~ </h2>
<ul>
<c:forEach var="name" items="${names}"
            begin="1">
  <li>${name}</li>
</c:forEach>
</ul>

<h2>배열: ~ 3 </h2>
<ul>
<c:forEach var="name" items="${names}"
            end="3">
  <li>${name}</li>
</c:forEach>
</ul>

<h2>단순 반복</h2>
<ul>
<c:forEach var="i" begin="3" end="9">
  <li>${i}</li>
</c:forEach>
</ul>
</body>
</html>








