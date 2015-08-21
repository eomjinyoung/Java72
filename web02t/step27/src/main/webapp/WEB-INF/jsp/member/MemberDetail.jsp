<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset='UTF-8'>
  <title>회원 상세보기</title>

  <jsp:include page="/Header.jsp"/>
  
  <style>
    .photo {
      height: 150px;
    }
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
    
<h1>회원 상세보기</h1>
<form action='update.do'  method='post' enctype='multipart/form-data'>
<table>
<tr>
  <th>번호</th>
  <td><input type='text' readonly name='no' value='${member.no}'></td></tr>
<tr>
  <th>이름</th>
  <td><input type='text' name='name' value='${member.name}'></td></tr>
<tr>
  <th>이메일</th>
  <td><input type='text' name='email' value='${member.email}'></td></tr>
<tr>
  <th>전화</th>
  <td><input type='text' name='tel' value='${member.tel}'></td></tr>
<tr>
  <th>가입일</th>
  <td>${member.createDate}</td></tr>
<tr>
  <th>암호</th>
  <td><input type='password' name='password'></td></tr>
<tr>
  <th>사진</th>
  <td><img class='photo' src='../files/${member.photo}'><input type='file' name='file1'></td></tr>
<tr>
  <th></th>
  <td><input type='submit' value='변경'><a href='delete.do?no=${member.no}'>삭제</a></td></tr>
</table>
</form>
<p><a href='list.do'>목록</a><p>

<jsp:include page="/Footer.jsp"/>

</body>
</html>
