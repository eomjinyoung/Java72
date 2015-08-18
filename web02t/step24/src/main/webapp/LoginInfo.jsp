<%@page import="net.bitacademy.java72.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Member member = (Member)session.getAttribute("member");
String contextRootPath = request.getContextPath();
%>    
<div id='loginInfo'>
<%
if (member == null) {
  out.println("<a href='"
      + contextRootPath
      + "/auth/login.do'>로그인</a>");
} else {
  out.println("  <span id='loginName'>"
      + member.getName() 
      + "</span>\n");
  out.println("  <a href='"
      + contextRootPath
      + "/auth/logout.do'>로그아웃</a>");
}
%>
</div>
