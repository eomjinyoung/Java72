<%@ page language="java" 
          contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8"%>
<%-- 다른 서버의 페이지 가져오기 --%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
           prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안녕!</title>
</head>
<body>
<h1>c:import</h1>
<h2>바로 뿌리기</h2>
<textarea rows="10" 
cols="60"><c:import url="http://www.naver.com"/></textarea>

<h2>가져온 데이터를 변수에 저장하기</h2>
<c:import var="daumData" url="http://www.daum.net"/>
<textarea rows="10" cols="60">${daumData}</textarea>
</body>
</html>








