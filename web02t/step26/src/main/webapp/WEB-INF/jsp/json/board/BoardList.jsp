<%@ page language="java" 
          contentType="text/plain; charset=UTF-8"
          pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
           prefix="c"%>   
<c:set var="count" value="0"/>      
{
  "pageNo": ${pageNo},
  "isNextPage": ${isNextPage},
  "pageSize": ${pageSize},
  "data": [
<c:forEach var="board" items="${boards}"> 
  <c:if test="${count > 0}">,</c:if> 
    {
	    "no": ${board.no},
	    "title": "${board.title}",
	    "createDate": "${board.createDate}",
	    "viewCount": ${board.viewCount}
    }
  <c:set var="count" value="${count + 1}"/>
</c:forEach>
  ]
}           


          