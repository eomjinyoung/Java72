<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
           prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
  <meta charset='UTF-8'>
  <title>회원 목록</title>

  <jsp:include page="/Header.jsp"/>
  
  <style>
    table {
      border-collapse: collapse;
    }
    th, td {
      border: 1px solid black;
      padding: 5px;
    }
  </style>
</head>
<body>

<jsp:include page="/LoginInfo.jsp"/>
    
<h1>회원 목록</h1>
<p><a href='form.html'>새 회원</a></p>
<table>
  <tr>
    <th>번호</th> 
    <th>이름</th> 
    <th>이메일</th>
    <th>전화</th>
    <th>가입일</th>
  </tr>
<c:forEach var="member" items="${members}">  
  <tr>
    <td>${member.no}</td>
    <td><a href='detail.do?no=${member.no}'>${member.name}</a></td>
    <td>${member.email}</td>
    <td>${member.tel}</td>
    <td>${member.createDate}</td>
  </tr>
</c:forEach>
</table>

<div>
<c:choose>
  <c:when test="${not empty prevPageNo}">
    <a href='list.do?pageNo=${prevPageNo}&pageSize=${pageSize}'>이전</a>
  </c:when>
  <c:otherwise>이전</c:otherwise>
</c:choose>
<c:choose>
  <c:when test="${not empty nextPageNo}">
    <a href='list.do?pageNo=${nextPageNo}&pageSize=${pageSize}'>다음</a>
  </c:when>
  <c:otherwise>다음</c:otherwise>
</c:choose>
</div>

<jsp:include page="/Footer.jsp"/>

</body>
</html>
