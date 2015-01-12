<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.eom.web.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
<title>회원관리</title>
</head>
<body>
<h1>회원정보</h1>
<table border='1'>
<tr>
	<th>이메일</th>
	<td>${member.email}</td>
</tr>
<tr>
	<th>이름</th>
	<td>${member.name}</td>
</tr>
<tr>
	<th>전화</th>
	<td>${member.tel}</td>
</tr>
<tr>
	<th>가입일</th>
	<td><fmt:formatDate value="${member.regDate}" pattern="yyyy-MM-dd"/></td>
</tr>
</table>

<h2>참여 프로젝트</h2>
<ul>
<c:forEach var="project" items="${projects}">
	<li>${project.title}(
		<fmt:formatDate value="${project.startDate}" pattern="yyyy-MM-dd"/> ~ 
		<fmt:formatDate value="${project.endDate}" pattern="yyyy-MM-dd"/>)</li>
</c:forEach>	
</ul>

<a href='delete.do?email=${member.email}'>삭제</a>
<a href='updateForm.do?email=${member.email}'>변경</a>

<jsp:include page="../tailer.jsp"></jsp:include>

</body>
</html>








