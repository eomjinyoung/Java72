<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table border='1'>
<tr>
  <th>제목</th> 
  <td>${param.title}</td>
</tr>
<tr>
  <th>내용</th>
  <td><textarea 
    rows='5' cols='50'>${param.content}</textarea></td>
</tr>
</table>