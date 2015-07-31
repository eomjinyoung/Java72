<%@ page import="net.bitacademy.java72.domain.Board"%>
<%@ page import="java.util.List"%>
<%@ page language="java" 
          contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8"%>
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

<h1>게시물 목록(by JSP)</h1>
<p><a href='form.html'>새 글</a></p>
<table>
  <tr>
    <th>번호</th> 
    <th>제목</th> 
    <th>등록일</th>
    <th>조회수</th>
  </tr>
<jsp:useBean id="boards" 
  type="java.util.List<Board>"
  scope="request"/>
<%
/*
List<Board> boards = 
  (List<Board>)request.getAttribute("boards");
*/
for (Board board : boards) {%>
  <tr>
    <td><%=board.getNo()%></td>
    <td><a href='detail.do?no=<%=board.getNo()%>'><%=
    board.getTitle()%></a></td>
    <td><%=board.getCreateDate()%></td>
    <td><%=board.getViewCount()%></td>
  </tr>
<%}%>  
</table>

<jsp:include page="/Footer.jsp"/>

</body>
</html>







          