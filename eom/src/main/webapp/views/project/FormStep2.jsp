<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트관리</title>
</head>
<body>
<h1>프로젝트 구성원</h1>
<form action="addStep2.do" method="post">
팀장: ${member.name}<br>
팀원: <textarea name="members" rows="5" cols="50">${members}</textarea><br>
<a href="addStep1.do">이전</a> <input type="submit" value="다음"><br>
</form>

<jsp:include page="../tailer.jsp"></jsp:include>

</body>
</html>