<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="message.user.login.title" /></title>
</head>
<body>
	<h1>
		<spring:message code="message.user.login.title" />
	</h1>
	<a href="login.do?lang=en"> <spring:message
			code="message.user.login.language.en" /></a>&nbsp;&nbsp;
	<a href="login.do?lang=ko"><spring:message
			code="message.user.login.language.ko" /></a>
	<hr>
	<!-- MVC1 -->
	<!-- <form action="loginProc.jsp" method="post"> -->

	<!-- MVC2 -->
	<form action="login.do" method="post">
		<table border="1">
			<tr>
				<td><spring:message code="message.user.login.id" /></td>
				<!-- <td><input type="text" name="id" /></td> -->
				<td><input type="text" name="id" value="{userVO.id}" /></td>
			</tr>
			<tr>
				<td><spring:message code="message.user.login.password" /></td>
				<!-- <td><input type="password" name="password" /></td> -->
				<td><input type="password" name="password"
					value="{userVO.password}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="<spring:message code="message.user.login.loginBtn" />" /></td>
			</tr>

		</table>
	</form>
</body>
</html>