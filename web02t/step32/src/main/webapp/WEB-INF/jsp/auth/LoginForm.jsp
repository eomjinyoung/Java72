<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>로그인 폼</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<style type='text/css'>
body {
  font-size: small;
}

#main {
  width: 400px;
  margin: 0px auto;
}

.form-group label {

}

h1 {
  text-align: center;
}
</style>
</head>
<body>
<div id='main'>
<h1>로그인</h1>
<form action='login.do' method='post' class="form-horizontal">
  <div class="form-group">
    <label for="email" class="col-sm-2 control-label">이메일</label>
    <div class="col-sm-10">
      <input type="email" name='email' class="form-control" 
            id="email" placeholder="Email">
    </div>
  </div>

  <div class="form-group">
    <label for="password" class="col-sm-2 control-label">암호</label>
    <div class="col-sm-10">
      <input type="password" name='password' class="form-control" 
        id="password" placeholder="Password">
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
          <input type="checkbox" name='saveEmail'> 이메일 기억하기
        </label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">로그인</button>
    </div>
  </div>
</form>
</div>
</body>
</html>
