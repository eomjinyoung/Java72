<%@ page language="java" 
          contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8"%>
<%-- 파라미터와 리다이렉트 --%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
           prefix="c"%>    
<c:choose>
  <c:when test="${param.age < 19}">
    <c:redirect url="http://www.naver.com"/>
  </c:when>
  <c:when test="${param.age >= 19 && param.age < 30}">
    <c:redirect url="http://www.daum.net"/>
  </c:when>
  <c:otherwise>
    <c:redirect url="http://www.google.com"/>
  </c:otherwise>
</c:choose>







