<%@page import="net.bitacademy.java72.domain.Member"%>
<%@ page language="java" 
          contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8"%>
<%-- Expression Language
=> PageContext 보관소에서 객체 꺼내기
=> 객체를 찾지 못했다고 해서 
   NullPointException 오류를 발생시키지는 않는다. 
   => 단지 빈 문자열 출력
 --%>
<%
Member member = new Member();
member.setNo(1);
member.setName("홍길동");
member.setEmail("hong@test.com");
member.setTel("111-1111");

pageContext.setAttribute("member", member);

%>           
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안녕!</title>
</head>
<body>
번호: ${pageScope.member.no}<br>
이름: ${pageScope.member.name}<br>
이메일: ${pageScope.member.email}<br>
전화: ${requestScope.member.tel}<br>
</body>
</html>









