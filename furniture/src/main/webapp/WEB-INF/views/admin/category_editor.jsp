<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>Admin-panel - Category-editor</title>
<%@ include file="/WEB-INF/views/admin/static/head.jsp"%>
<c:set var="page_id" scope="session" value="6" />
</head>
<body>

	<div id="wrap">
		<%@ include file="/WEB-INF/views/admin/static/header.jsp"%>
		<div id="content">
			<form name="category" action="add-category" method="post">
				<p>Name</p>
				<p><input type="text" name="name" /></p>
				
				<input type="submit" value="Add" />
			</form>

			<h3>All categories</h3>

			<table class="wide-table">
				<tr>
					<th>+</th>
					<th>Name</th>
					<th>Controls</th>
				</tr>
				<c:forEach var="icategory" items="${categories}">
					<tr>
						<td><input type="checkbox" name="${icategory.id}" /></td>
						<td>${icategory.name}</td>
						<td><a>Edit</a> | <a href="delete-category?id=${icategory.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</div>
</body>
</html>
