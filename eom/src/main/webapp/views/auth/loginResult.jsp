<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" 
	class="com.eom.web.vo.Member"
	scope="session"/>
<%
if (member != null && member.getEmail() != null) {
	response.sendRedirect(
		request.getContextPath() + "/");
	return;
}%>
<html>
<head>
	<meta http-equiv="Refresh" content="1;url=login.do">
</head>
<body>
<p>사용자 아이디 또는 암호가 일치하지 않습니다!</p>
</body>
</html>