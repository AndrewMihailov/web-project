<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>Admin-panel - Admin-editor</title>
<%@ include file="/views/admin/static/head.jsp"%>
<script src="/furniture/resources/scr/admin/admin.js"></script>
<c:set var="page_id" scope="session" value="2" />
</head>
<body>

	<div id="wrap">
		<%@ include file="/views/admin/static/header.jsp"%>
		<div id="content">
			<c:set var="action" value="add-admin" />
			<c:if test="${edit}">
				<c:set var="action" value="edit-admin" />
			</c:if>
			<form name="admin" action="${action}" method="post">
				<c:if test="${edit}">
					<input hidden="true" name="id" value="${admin.id}" />
				</c:if>
				<table>
					<tr>
						<td>Login</td>
						<td><input type="text" name="login" id="login" value="${admin.login}" /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="text" name="password" id="password" value="${admin.password}" /></td>
					</tr>
					<tr>
						<td>Role</td>
						<td><select name="role">
								<option value="ADMIN" <c:if test="${admin.role eq \"ADMIN\"}">selected</c:if> >Admin</option>
								<option value="SUPER" <c:if test="${admin.role eq \"SUPER\"}">selected</c:if> >Super admin</option>
						</select></td>
					</tr>
				</table>
				<input type="submit" value="Add" />
				<c:if test="${edit}">
					<a href="admin-editor">Discard</a>
				</c:if>
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
						<td><a href="admin-editor?id=${iadmin.id}">Edit</a>
						| <a href="delete-admin?id=${iadmin.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
			
			<p>
				Page:
				<c:forEach var="i" begin="1" end="${totalPages}">
					<a <c:if test="${i ne page}"> href="/furniture/admin/admin-editor?page=${i}&perpage=${perpage}" </c:if>>${i}</a>
				</c:forEach>
			</p>
			<p>
				Per page:
				<select id="perpage">
					<option value="1" <c:if test="${perpage eq 1}">selected="selected"</c:if> >1</option>
					<option value="2" <c:if test="${perpage eq 2}">selected="selected"</c:if> >2</option>
					<option value="5" <c:if test="${perpage eq 5}">selected="selected"</c:if> >5</option>
				</select>
			</p>

		</div>

	</div>
</body>
</html>
