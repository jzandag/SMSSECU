<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="../common/taglibs.jsp"%>

<c:choose>
	<c:when test="${empty userSessionObj}">
		<c:redirect url="/clinical/login"/>
	</c:when>
	<c:otherwise>
		<c:redirect url="/clinical/error/404"/>		
	</c:otherwise>
</c:choose>