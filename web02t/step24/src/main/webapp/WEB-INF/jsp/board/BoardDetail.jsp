<%@ page language="java" 
          contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset='UTF-8'>
  <title>게시물 상세보기</title>
  <jsp:include page="/Header.jsp"/>
  <style>
    table {
      border-collapse: separate;
    }
    th {
      background-color: lightgray;
      padding: 5px;
    }
  </style>
</head>
<body>

<jsp:include page="/LoginInfo.jsp"/>

<h1>게시물 상세보기(with EL)</h1>
<form action='update.do' 
      method='post' enctype='multipart/form-data'>
<table>
<tr>
  <th>번호</th>
  <td><input type='text' readonly 
        name='no' value='${board.no}'></td>
</tr>
<tr>
  <th>제목</th>
  <td><input type='text' 
        name='title' value='${board.title}'></td>
</tr>
<tr>
  <th>내용</th>
  <td><textarea name='content' rows='5' 
        cols='50'>${board.content }</textarea></td>
</tr>
<tr>
  <th>암호</th>
  <td><input type='password' name='password'></td>
</tr>
<tr><th>조회수</th><td>${board.viewCount}</td></tr>
<tr><th>등록일</th><td>${board.createDate}</td></tr>
<tr>
  <th>첨부파일</th>
  <td><a href='../files/${board.attachFile1}'
      >${board.attachFile1}</a>
      <input type='file' name='file1'></td>
</tr>
<tr>
  <th></th>
  <td>
    <input type='submit' value='변경'>
    <a href='delete.do?no=${board.no}'>삭제</a></td>
</tr>
</table>
</form>
<p><a href='list.do'>목록</a><p>

<jsp:include page="/Footer.jsp"/>

</body>
</html>
          