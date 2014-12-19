<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>Admin-panel - Category-editor</title>
<%@ include file="/views/admin/static/head.jsp"%>
<script src="/furniture/resources/scr/admin/category.js"></script>
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
				<p>Name RU</p>
				<p><input type="text" name="nameRu" id="nameRu" value="${category.nameRu}" /></p>
				<span id="nameRu_error" class="error">Required to fill</span>
				
				<p>Name EN</p>
				<p><input type="text" name="nameEn" id="nameEn" value="${category.nameEn}" /></p>
				<span id="nameEn_error" class="error">Required to fill</span>
				
				<p>Parent category</p>
				<p>
					<select name="parent.id" id="parent">
						<option value="null">Null</option>
						<c:forEach var="icategory" items="${categories}">
							<c:if test="${category.id ne icategory.id}">
							<option value="${icategory.id}"
								<c:if test="${category.parent.id eq icategory.id}">selected</c:if>>${icategory.nameRu} | ${icategory.nameEn}</option>
							</c:if>
						</c:forEach>
					</select>
				</p>
				
				<input type="submit" value="Add" />
				<c:if test="${edit}">
					<a href="category-editor">Discard</a>
				</c:if>
			</form>

			<h3>All categories</h3>

			<table class="wide-table">
				<tr>
					<th>+</th>
					<th>Name RU</th>
					<th>Name EN</th>
					<th>Parent</th>
					<th>Controls</th>
				</tr>
				<c:forEach var="icategory" items="${categories}">
					<tr>
						<td><input type="checkbox" name="${icategory.id}" /></td>
						<td>${icategory.nameRu}</td>
						<td>${icategory.nameEn}</td>
						<td>
							<c:if test="${icategory.parent ne null}">
								${icategory.parent.nameRu} | ${icategory.parent.nameEn}
							</c:if>
						</td>
						<td><a href="category-editor?id=${icategory.id}">Edit</a> | <a href="delete-category?id=${icategory.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</div>
</body>
</html>
