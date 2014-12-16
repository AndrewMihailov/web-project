<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<html>
<head>
<title>Admin-panel - Login</title>
</head>
<body>

	<div id="content">
		<c:url value="/login" var="loginUrl" />
		<form action="${loginUrl}" method="post">
			<fieldset>
				<legend>Log in, please</legend>
				<c:if test="${param.error ne null}">
					<p>Login attempt error</p>
				</c:if>
				<c:if test="${param.logout ne null}">
					<p>You have been logged out</p>
				</c:if>
				<p>
					<label for="username">Username</label> <input type="text"
						id="username" name="username" />
				</p>
				<p>
					<label for="password">Password</label> <input type="password"
						id="password" name="password" />
				</p>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<button type="submit" class="btn">Log in</button>
			</fieldset>
		</form>
	</div>

</body>
</html>
