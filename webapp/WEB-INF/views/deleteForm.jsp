<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>																
	<form action="${pageContext.request.contextPath }/gb/delete" method="post">
		비밀번호<input type="text" name="password">
		<input type="hidden" name="no"  value= "${param.no}">
		
		<button type="submit">확인</button>
	</form>
	
	<a href="${pageContext.request.contextPath }/gb/list">메인으로 돌아가기</a>
	
</body>
</html>