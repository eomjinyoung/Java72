<%@ page language="java" 
          contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8"%>
<%-- URL 생성기 --%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
           prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안녕!</title>
</head>
<body>
<h1>c:url</h1>
<h2>사용 전</h2>
<a href='http://www.zdnet.co.kr/news/news_view.asp?artice_id=20150731070147&lo=z36'>ZDNET:샤오미</a>

<h2>사용 후</h2>
<%--
value="기본 URL"
var="URL을 생성한 후 저장할 때 사용할 이름"

<c:param name="파라미터명" value="값"/>
 --%>

<c:url var="zdnetlink" 
  value="http://www.zdnet.co.kr/news/news_view.asp">
  <c:param name="artice_id" value="20150731070147"/>
  <c:param name="lo" value="z36"/>
</c:url>  
<a href='${zdnetlink}'>ZDNET:샤오미</a>
</body>
</html>








