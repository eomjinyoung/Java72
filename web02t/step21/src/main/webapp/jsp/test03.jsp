<%@ page language="java" 
          contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8"%>
<%-- JSP 주석
=> JSP 엔진이 클래스를 만들 때 제거한다.

JSP의 구성요소: 
=> 템플릿 데이터, JSP 액션 태그, 스크립트릿(scriptlet), 
   표현식(expression element), 선언문(declaration element),
   지시문(directive element)

3. JSP 액션 태그: forward, include 
=> 특별한 JSP 전용 태그
=> 특정 자바 코드를 생성한다.
<jsp:forward> --> forwarding 자바 코드를 생성한다.
<jsp:include> --> including 자바 코드를 생성한다.

--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안녕!</title>
<jsp:include page="/jsp/header.jsp"/>
</head>
<body>
<h1>인클루드 테스트</h1>
<p>본문</p>
<jsp:include page="/jsp/footer.jsp"/>
</body>
</html>





