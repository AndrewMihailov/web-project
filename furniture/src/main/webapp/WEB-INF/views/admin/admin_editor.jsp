<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>Admin-panel - Admin-editor</title>
<%@ include file="/WEB-INF/views/admin/static/head.jsp"%>
<c:set var="page_id" scope="session" value="2" />
</head>
<body>

	<div id="wrap">
		<%@ include file="/WEB-INF/views/admin/static/header.jsp"%>
		<div id="content">
			<form name="admin" action="add-admin" method="post">
				<table>
					<tr>
						<td>Login</td>
						<td><input type="text" name="login" id="login" /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="text" name="password" id="password" /></td>
					</tr>
					<tr>
						<td>Role</td>
						<td><select name="role">
								<option value="ADMIN">Admin</option>
								<option value="SUPER">Super admin</option>
						</select></td>
					</tr>
				</table>
				<input type="submit" value="Add" />
			</form>

			<h3>All users</h3>

			<table class="wide-table">
				<tr>
					<th>+</th>
					<th>Login</th>
					<th>Password</th>
					<th>Role</th>
					<th>Controls</th>
				</tr>
				<c:forEach var="iadmin" items="${admins}">
					<tr>
						<td><input type="checkbox" name="${iadmin.id}" /></td>
						<td>${iadmin.login}</td>
						<td>${iadmin.password}</td>
						<td>${iadmin.role}</td>
						<td><a href="#" onclick="load(${iadmin.id});">Edit</a>
						| <a href="delete-admin?id=${iadmin.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>

		</div>

	</div>
</body>
</html>
