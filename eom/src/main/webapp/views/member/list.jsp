<%@ page import="com.eom.web.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원관리</title>
</head>
<body>
<h1>회원목록</h1>
<a href='newForm.do'>새회원</a>
<table border='1'>
<tr>
	<th width='200'>이메일</th>
	<th width='100'>이름</th>
	<th width='200'>전화</th>
</tr>
<c:forEach var="member" items="${requestScope.list}">
<tr>
	<td><a href='detail.do?email=${member.email}'>${member.email}</a></td>
	<td>${member.name}</td>
	<td>${member.tel}</td>
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








