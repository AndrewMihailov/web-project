<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>Admin-panel - Category-editor</title>
<%@ include file="/views/admin/static/head.jsp"%>
<c:set var="page_id" scope="session" value="6" />
</head>
<body>

	<div id="wrap">
		<%@ include file="/views/admin/static/header.jsp"%>
		<div id="content">
			<c:set var="action" value="add-category" />
			<c:if test="${edit}">
				<c:set var="action" value="edit-category" />
			</c:if>
			<form name="category" action="${action}" method="post">
				<c:if test="${edit}">
					<input hidden="true" name="id" value="${category.id}" />
				</c:if>
				<p>Name</p>
				<p><input type="text" name="name" value="${category.name}" /></p>
				
				<input type="submit" value="Add" />
				<c:if test="${edit}">
					<a href="category-editor">Discard</a>
				</c:if>
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
						<td><a href="category-editor?id=${icategory.id}">Edit</a> | <a href="delete-category?id=${icategory.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</div>
</body>
</html>
