<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>Admin-panel - Product-editor</title>
<%@ include file="/WEB-INF/views/admin/static/head.jsp"%>
<c:set var="page_id" scope="session" value="5" />
</head>
<body>

	<div id="wrap">
		<%@ include file="/WEB-INF/views/admin/static/header.jsp"%>
		<div id="content">
			<form name="product" action="add-product" method="post">
				<p>Category</p>
				<p>
					<select name="category.id">
						<c:forEach var="icategory" items="${categories}">
							<option value="${icategory.id}">${icategory.name}</option>
						</c:forEach>
					</select>
				</p>
				<p>Name</p>
				<p><input type="text" name="name" /></p>
				<p>Description</p>
				<p>
					<textarea rows="5" cols="100" name="description"></textarea>
				</p>
				<p>Image</p>
				<p><input type="file" name="image" /></p>
				
				<p>Designer</p>
				<p>
					<select name="designer.id">
						<c:forEach var="idesigner" items="${designers}">
							<option value="${idesigner.id}">${idesigner.fio}</option>
						</c:forEach>
					</select>
				</p>
				
				<input type="submit" value="Add" />
			</form>

			<h3>All products</h3>

			<table class="wide-table">
				<tr>
					<th>+</th>
					<th>Category</th>
					<th>Name</th>
					<th>Description</th>
					<th>Image</th>
					<th>Designer</th>
					<th>Controls</th>
				</tr>
				
				<c:forEach var="iproduct" items="${products}">
					<tr>
						<td><input type="checkbox" name="${iproduct.id}" /></td>
						<td>${iproduct.category.name}</td>
						<td>${iproduct.name}</td>
						<td>${iproduct.description}</td>
						<td>${iproduct.image}</td>
						<td>${iproduct.designer.fio}</td>
						<td><a>Edit</a> | <a href="delete-product?id=${iproduct.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</div>
</body>
</html>
