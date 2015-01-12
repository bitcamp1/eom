<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.eom.web.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
<title>회원관리</title>
</head>
<body>
<h1>회원정보변경</h1>
<form action='update.do' method='post'>
<table border='1'>
<tr>
	<th width='80'>이메일</th>
	<td><input type='text' name='email' value='${member.email}' readonly></td>
</tr>
<tr>
	<th>이름</th>
	<td><input type='text' name='name' value='${member.name}'></td>
</tr>
<tr>
	<th>전화</th>
	<td><input type='text' name='tel' value='${member.tel}'></td>
</tr>
<tr>
	<th>가입일</th>
	<td>${member.regDate}</td>
</tr>
</table>
<input type='submit' value='확인'>
</form>

<jsp:include page="../tailer.jsp"></jsp:include>

</body>
</html>








