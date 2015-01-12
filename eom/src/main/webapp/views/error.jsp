<%@ page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="error" 
	class="java.lang.Exception" 
	scope="request"/>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>시스템 오류!</title>
</head>
<body>
<h1>오류내용:</h1>
<pre>
<%
error.printStackTrace(new PrintWriter(out));
%>
</pre>
</body>
</html>