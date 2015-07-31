<%@ page language="java" 
          contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8"%>
<%-- JSTL (JSP Standard Tag Library)
=> JSP에서 사용할 수 있는 확장 라이브러리.
=> API와 구현체를 다운로드 받아야 한다.
=> JSTL 사용법
   - 태그 라이브러리를 임포트한다.
<%@ taglib uri="라이브러리 네임스페이스" prefix="별명"%>
예)
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
          prefix="c"%>

=> JSTL 라이브러리 종류
1) Core:       http://java.sun.com/jsp/jstl/core (c)
   - 변수 생성 및 값 설정
   - 조건문 및 반복문
   - URL 관리
   - 기타
2) XML:        http://java.sun.com/jsp/jstl/xml (x)
   - XML 분석
   - 조건 및 반복문
   - 변환
3) I18N:       http://java.sun.com/jsp/jstl/fmt (fmt)
   - 메시지 포맷
   - 숫자 및 날짜 포맷
4) Database:   http://java.sun.com/jsp/jstl/sql (sql)
   - 데이터베이스 연결 설정 및 SQL 질의
5) Functions:  http://java.sun.com/jsp/jstl/functions (fn)
   - 문자열 다루는 함수들        
 --%>  
 
<%-- JSTL 사용 준비--%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
           prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안녕!</title>
</head>
<body>
<h1>c:out - 출력하기</h1>
<%-- 
<c:out value="출력할 데이터" default="기본 데이터"/>
<c:out value="출력할 데이터">기본 데이터</c:out>
--%>    
<%
pageContext.setAttribute("name", "홍길동");
%>
이름1: <c:out value="${name}" default="이름 없음"/><br>
이름2: <c:out value="${name2}" default="이름 없음"/><br>
이름3: <c:out value="${name3}">이름 없음</c:out><br>

<h1>c:set - 변수 만들기</h1>
<%--
var="변수명" 
value="값" 
scope="page|request|session|application"     
 --%>
<c:set var="age" value="20" scope="page"/>
<%-- pageContext.setAttribute("age", "20"); --%>
<c:set var="tel" scope="page">111-2222</c:set>
나이: ${age}<br>
전화: ${tel}<br>

<h1>c:remove</h1>
<%-- 보관소에 등록된 객체를 삭제한다.
var="삭제할 객체명"
scope="page|request|session|application"
 --%>
<h2>삭제 전</h2>
name: ${name}<br>
age: ${age}<br>
tel: ${tel}<br>

<h2>삭제 후</h2>
<c:remove var="name" scope="page"/>
<c:remove var="age" scope="page"/>
name: ${name}<br>
age: ${age}<br>
tel: ${tel}<br>

<%pageContext.removeAttribute("tel"); %>
tel: ${tel}<br>
</body>
</html>








