<%@page import="net.bitacademy.java72.domain.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" 
          contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset='UTF-8'>
  <title>게시물 목록</title>
<%
RequestDispatcher rd = 
request.getRequestDispatcher("/header");
rd.include(request, response);
%>
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
<%
rd = request.getRequestDispatcher("/loginInfo");
rd.include(request, response);
%>
<h1>게시물 목록(by JSP)</h1>
<p><a href='form.html'>새 글</a></p>
<table>
  <tr>
    <th>번호</th> 
    <th>제목</th> 
    <th>등록일</th>
    <th>조회수</th>
  </tr>
<%
List<Board> boards = 
  (List<Board>)request.getAttribute("boards");
for (Board board : boards) {
  out.println("<tr>"
      + "<td>" 
      + board.getNo() 
      + "</td>"
      + "<td><a href='detail.do?no="
      + board.getNo()
      + "'>"
      + board.getTitle()
      + "</a></td>"
      + "<td>"
      + board.getCreateDate()
      + "</td>"
      + "<td>"
      + board.getViewCount()
      + "</td>"
      + "</tr>");
}
%>  
</table>
<%
rd = request.getRequestDispatcher("/footer");
rd.include(request, response);
%>
</body>
</html>







          