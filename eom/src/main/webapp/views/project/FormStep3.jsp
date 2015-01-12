<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트관리</title>
</head>
<body>
<h1>프로젝트 등록</h1>
<form action="addStep3.do" method="post">
<input type="hidden" name="step" value="3">
제목: ${newProject.title}<br>
설명: <textarea rows="5" cols="50" readonly>${newProject.description}</textarea><br>
시작일: ${newProject.startDate}<br>
종료일: ${newProject.endDate}<br>
팀장: ${member.name}<br>
팀원: <textarea rows="5" cols="50" readonly>${members}</textarea><br>
<a href="addStep2.do">이전</a> <input type="submit" value="등록"><br>
</form>

<jsp:include page="../tailer.jsp"></jsp:include>

</body>
</html>