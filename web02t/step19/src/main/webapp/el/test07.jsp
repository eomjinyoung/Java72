<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="net.bitacademy.java72.domain.Member"%>
<%@ page language="java" 
          contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8"%>
<%-- 값 꺼내기
   
 --%>
      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안녕!</title>
</head>
<body>
<h1>배열에서 값 꺼내기</h1>
<%
pageContext.setAttribute("scores", new int[]{100,90,80});
%>
${scores[2]}<br>
${scores[1]}<br>
${scores[0]}<br>

<h1>List에서 값 꺼내기</h1>
<%
List<String> names = new ArrayList<String>();
names.add("홍길동");
names.add("임꺽정");
pageContext.setAttribute("names", names);
%>
${names[0]}<br>
${names[1]}<br>

<h1>Map에서 값 꺼내기</h1>
<%
Map<String,String> map = new HashMap<String,String>();
map.put("s01", "홍길동");
map.put("s02", "임꺽정");
pageContext.setAttribute("map", map);
%>
${map.s01}<br>
${map["s01"]}<br>
${map.s02}<br>
${map["s02"]}<br>

<h1>값 객체에서 값 꺼내기</h1>
<%
Member member = new Member();
member.setNo(1);
member.setName("홍길동");
member.setEmail("hong@test.com");
member.setTel("111-1111");
pageContext.setAttribute("member", member);
%>
${member.no}<br>
${member["name"]}<br>
${member.email}<br>
${member['tel']}<br>
</body>
</html>









