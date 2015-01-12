<%@ page language="java" 
	contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Thread.sleep(5000);
int a = 10;
if (a == 11) {
	throw new Exception("오호라.. 일부러 예외..");
}
%>    
안녕하세요^^.