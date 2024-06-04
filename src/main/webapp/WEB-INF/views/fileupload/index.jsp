<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일업로드</title>
</head>
<body>
	<ul>
		<li><a href='<c:url value="/upload/new"/>'>업로드</a></li>
		<li><a href='<c:url value="/upload/list"/>'>파일 전체 목록</a></li>
		<li><a href='<c:url value="/upload/list/bigdata"/>'>빅데이터 디렉토리 목록</a></li>
		<li><a href='<c:url value="/upload/gallary"/>'>갤러리</a></li>
	</ul>
</body>
</html>