<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="com.eom.web.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트관리</title>
</head>
<body>
<h1>프로젝트목록</h1>
<a href='addStep1.do'>새 프로젝트</a>
<table border='1'>
<tr>
	<th width='20'>번호</th>
	<th width='200'>프로젝트명</th>
	<th width='100'>시작일</th>
	<th width='100'>종료일</th>
	
</tr>
<c:forEach var="project" items="${list}">
<tr>
	<td>${project.no}
	<td><a href='detail.do?no=${project.no}'>${project.title}</a></td>
	<td>${project.startDateString}</td>
	<td>${project.endDateString}</td>
</tr>
</c:forEach>
</table>
<p>
<c:if test="${pageNo > 1}">
<a href="list.do?pageNo=${pageNo-1}">[이전]</a> 
</c:if>
<c:if test="${pageNo < pageCount}">
<a href="list.do?pageNo=${pageNo+1}">[다음]</a>
</c:if>
</p>

<jsp:include page="../tailer.jsp"></jsp:include>

</body>
</html>








