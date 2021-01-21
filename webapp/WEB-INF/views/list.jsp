<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>등록해 주세요</h1>
		
		<form action="/guestbook4/gb/add" method="post">
		<table border="3" >
			<tr>													<!-- 값이 없어도 value는 써야함 -->
				<td bgcolor="EEEEEE" align="center" >이름</td>
				<td ><input type="text" name ="name" value=""></td>
				<td bgcolor="EEEEEE">비밀번호</td>
				<td><input type="text" name ="password" value=""></td>
			</tr>
			
			<tr>
				<td colspan="4" ><textarea  name="content"></textarea></td>
			</tr>
			
			<tr>
				<td  bgcolor="EEEEEE" colspan="4" ><button type = "submit">확인</button></td>
			</tr>
			
		</table>
		<br>
	
	</form>
	<h2>리스트</h2>
	<!-- 삭제 코드 -->
		<c:forEach items="${gbList}" var="gbVo">
		<table border="2">
			<tr>
				<td>${gbVo.no }</td>
				<td>${gbVo.name }</td>
				<td>${gbVo.regdate }</td>
				
			</tr>
			<tr>
				<td colspan="4">${gbVo.content }</td>
			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath }/gb/deleteForm?no=${gbVo.no }">삭제</a></td>
			</tr>
		</table>
		<br>
	
		</c:forEach>
		
		
		
</body>
</html>