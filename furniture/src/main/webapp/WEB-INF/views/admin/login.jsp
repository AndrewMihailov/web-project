<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<html xmlns:th="http://www.thymeleaf.org"
	xmlns:tiles="http://www.thymeleaf.org">
<head>
<title>Admin-panel - Login</title>
</head>
<body>

	<%-- <%@ include file="/WEB-INF/views/admin/static/header.jsp"%> --%>

	<%-- <div tiles:fragment="content">
		<form name="f" th:action="@{/login}" method="post">
			<fieldset>
				<legend>Please Login</legend>
				<div th:if="${param.error}" class="alert alert-error">Invalid
					username and password.</div>
				<div th:if="${param.logout}" class="alert alert-success">You
					have been logged out.</div>
				<label for="username">Username</label> <input type="text"
					id="username" name="username" /> <label for="password">Password</label>
				<input type="password" id="password" name="password" />
				<div class="form-actions">
					<button type="submit" class="btn">Log in</button>
				</div>
			</fieldset>
		</form>
	</div> --%>

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
