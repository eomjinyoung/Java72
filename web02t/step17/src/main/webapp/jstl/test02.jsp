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
<h1>c:if</h1>
<%-- 
test="조건"
var="결과를 저장할 때 사용할 이름"
scope="page|request|session|application"
--%>    
<c:if test="${10 < 11}">
  10은 11보다 작다.<br>
</c:if>

<c:if test="${10 > 11}">
  10은 11보다 크다.<br>
</c:if>

<c:if test="${10 < 11}" var="result" scope="page">
  \${10 < 11} = ${result}<br>
</c:if>
${result}<br>
</body>
</html>








