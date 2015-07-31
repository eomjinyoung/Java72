<%@page import="net.bitacademy.java72.domain.Member"%>
<%@ page language="java" 
          contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8"%>
<%-- Expression Language
=> ServletContext 보관소에서 객체 꺼내기
 --%>
<%
Member member = new Member();
member.setNo(1);
member.setName("홍길동");
member.setEmail("hong@test.com");
member.setTel("111-1111");

application.setAttribute("member", member);

%>           
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안녕!</title>
</head>
<body>
번호: ${applicationScope.member.no}<br>
이름: ${sessionScope.member.name}<br>
이메일: ${pageScope.member.email}<br>
전화: ${requestScope.member.tel}<br>
</body>
</html>









