<%@page import="net.bitacademy.java72.domain.Member"%>
<%@ page language="java" 
          contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8"%>
<%-- Expression Language
=> 점(.)과 대괄호([])를 이용하여 객체의 프로퍼티나 
   맵, 리스트, 배열의 값을 쉽게 꺼내는 기술.
=> 기본 문법
   ${객체명.프로퍼티명.프로퍼티명.프로퍼티명}
   ${객체명[프로퍼티명]}
 --%>
<%
Member member = new Member();
member.setNo(1);
member.setName("홍길동");
member.setEmail("hong@test.com");
member.setTel("111-1111");

request.setAttribute("member", member);
%>           
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안녕!</title>
</head>
<body>
번호: ${requestScope.member.no}<br>
이름: ${requestScope.member.name}<br>
이메일: ${requestScope.member.email}<br>
전화: ${requestScope.member.tel}<br>
</body>
</html>









