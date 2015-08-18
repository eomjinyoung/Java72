<%@ page language="java" 
          contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
           prefix="c"%>         
<!DOCTYPE html>
<html>
<head>
  <meta charset='UTF-8'>
  <title>게시물 목록</title>
  
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

<h1>게시물 목록(by JSP with EL, JSTL)</h1>
<p><a href='form.html'>새 글</a></p>
<table>
  <tr>
    <th>번호</th> 
    <th>제목</th> 
    <th>등록일</th>
    <th>조회수</th>
  </tr>
<c:forEach var="board" items="${boards}">
  <tr>
    <td>${board.no}</td>
    <td><a href='detail.do?no=${board.no}'>${board.title}</a></td>
    <td>${board.createDate}</td>
    <td>${board.viewCount}</td>
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







          