<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	잘못 입력했습니다.<br>
	<a href="${pageContext.request.contextPath }/gb/deleteForm?no=${param.no }">다시 입력하기</a>
	<!-- 따로 만들면 비밀번호 틀리시 화면 안나오는 오류 보완가능. -->
</body>
</html>