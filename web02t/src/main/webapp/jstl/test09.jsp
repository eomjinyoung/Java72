<%@page import="java.util.Date"%>
<%@ page language="java" 
          contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8"%>
<%-- 날짜 형식 다루기 --%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
           prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" 
           prefix="fmt"%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안녕!</title>
</head>
<body>
<h1>날짜 객체(java.util.Date) 만들기 </h1>
<%-- 
value="문자열 날짜 데이터"
pattern="날짜 데이터의 문자열 형식"
var="저장소에 저장할 때 사용할 이름"
--%>
<fmt:parseDate var="date1" 
      value="${param.date}" 
      pattern="yyyy-MM-dd"/>
<%
Date mydate = (Date)pageContext.getAttribute("date1");
out.println(mydate);
%>

<h1>날짜 객체를 원하는 형식의 문자열로 만들기</h1>
<fmt:formatDate value="${date1}" pattern="MM/dd/yyyy"/>
</body>
</html>








