<%@ page language="java" 
          contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8"%>
<%-- 조건문 --%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
           prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안녕!</title>
</head>
<body>
<h1>c:choose</h1>
<%-- 
switch case와 유사하다.
--%>    
<c:set var="age" value="15"/>
<c:choose>
  <c:when test="${age > 0 && age < 14}">
    어린이입니다.<br>
  </c:when>
  <c:when test="${age >= 14 && age < 19}">
    청소년입니다.<br>
  </c:when>
  <c:otherwise>
    성인입니다.<br>
  </c:otherwise>
</c:choose>
</body>
</html>








