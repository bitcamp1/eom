<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
System.out.println("loginForm.jsp....");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
<h1>로그인</h1>
<form action="login.do" method="post">
이메일: <input type="text" name="email" value="${email}"><br>
암호: <input type="text" name="password"><br>
<input type="checkbox" name="saveEmail" ${checked} >이메일 저장<br>
<input type="submit" value="로그인">
</form>
</body>
</html>