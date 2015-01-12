<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트관리</title>
</head>
<body>
<h1>프로젝트 기본정보</h1>
<form action="addStep1.do" method="post">
제목: <input type="text" name="title" value="${newProject.title}"><br>
설명: <textarea name="description" rows="5" cols="50">${newProject.description}</textarea><br>
시작일: <input type="text" name="startDate" value="${newProject.startDate}"><br>
종료일: <input type="text" name="endDate" value="${newProject.endDate}"><br>
<input type="submit" value="다음"><br>
</form>

<jsp:include page="../tailer.jsp"></jsp:include>

</body>
</html>