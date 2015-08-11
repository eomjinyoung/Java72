<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>로그인 폼</title>
<style type='text/css'>
#main {
  background-color: yellow;
  width: 260px;
  padding: 0px 20px 10px 20px; 
  margin: 0px auto;
}
</style>
</head>
<body>
<div id='main'>
<h1>로그인</h1>
<form action='login.do' method='post'>
<table>
<tr>
  <th>이메일</th>
  <td><input type='text' name='email' value='${email}'></td>
</tr>
<tr>
  <th>암호</th>
  <td><input type='password' name='password'></td>
</tr>
<tr>
  <th></th>
  <td><input type='checkbox' name='saveEmail'>
    이메일 기억하기
  </td>
</tr>
<tr>
  <th></th>
  <td><button type='submit'>로그인</button></td>
</tr>
</table>
</form>
</div>
</body>
</html>
