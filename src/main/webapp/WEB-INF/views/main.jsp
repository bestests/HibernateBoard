<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main</title>
</head>
<body>
	<h1>Main</h1>
	<hr />
	<c:choose>
		<c:when test="${ list eq null }">
			<h3>등록된 게시글이 없습니다.</h3>
		</c:when>
		<c:otherwise></c:otherwise>
	</c:choose>
</body>
</html>