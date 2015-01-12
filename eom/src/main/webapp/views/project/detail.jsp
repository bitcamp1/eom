<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
<title>프로젝트관리</title>
</head>
<body>
<h1>프로젝트정보</h1>
<table border='1'>
<tr>
	<th>번호</th>
	<td>${project.no}</td>
</tr>
<tr>
	<th>제목</th>
	<td>${project.title}</td>
</tr>
<tr>
	<th>설명</th>
	<td><textarea rows='5' cols='50'>${project.description}</textarea></td>
</tr>
<tr>
	<th>시작일</th>
	<td>${project.startDateString}</td>
</tr>
<tr>
	<th>종료일</th>
	<td>${project.endDateString}</td>
</tr>
</table>

<h2>멤버들</h2>
<ul>
<c:forEach var="member" items="${project.members}">
	<li>${member.name}(${member.email})</li>
</c:forEach>
</ul>


<a href='delete.do?no=${project.no}'>삭제</a>
<a href='update.do?no=${project.no}'>변경</a>

<jsp:include page="../tailer.jsp"></jsp:include>

</body>
</html>








