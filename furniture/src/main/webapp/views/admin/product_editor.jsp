<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>Admin-panel - Product-editor</title>
<%@ include file="/views/admin/static/head.jsp"%>
<c:set var="page_id" scope="session" value="5" />
</head>
<body>

	<div id="wrap">
		<%@ include file="/views/admin/static/header.jsp"%>
		<div id="content">
			<c:set var="action" value="add-product" />
			<c:if test="${edit}">
				<c:set var="action" value="edit-product" />
			</c:if>
			<form name="product" action="${action}" method="post"
				enctype="multipart/form-data">
				<c:if test="${edit}">
					<input hidden="true" name="id" value="${product.id}" />
				</c:if>
				<p>Category</p>
				<p>
					<select name="category.id">
						<c:forEach var="icategory" items="${categories}">
							<option value="${icategory.id}"
								<c:if test="${product.category.id eq icategory.id}">selected</c:if>>${icategory.name}</option>
						</c:forEach>
					</select>
				</p>
				<p>Name</p>
				<p>
					<input type="text" name="name" value="${product.name}" />
				</p>
				<p>Description</p>
				<p>
					<textarea rows="5" cols="100" name="description">${product.description}</textarea>
				</p>
				<p>Price</p>
				<p>
					<input type="text" name="price" value="${product.price}" />
				</p>
				<p>
					Image
					<c:if test="${edit}">
						<input type="checkbox" name="keepimg" />Keep current (newly selected will be ignored)</c:if>
				</p>
				<p>
					<input type="file" name="image1" value="${product.image}" />
				</p>

				<p>Designer</p>
				<p>
					<select name="designer.id">
						<c:forEach var="idesigner" items="${designers}">
							<option value="${idesigner.id}"
								<c:if test="${product.designer.id eq idesigner.id}">selected</c:if>>${idesigner.fio}</option>
						</c:forEach>
					</select>
				</p>

				<input type="submit" value="Add" />
				<c:if test="${edit}">
					<a href="product-editor">Discard</a>
				</c:if>
			</form>

			<h3>All products</h3>

			<table class="wide-table">
				<tr>
					<th>+</th>
					<th>Category</th>
					<th>Name</th>
					<th>Description</th>
					<th>Price</th>
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
						<td>${iproduct.price}</td>
						<td><c:if
								test="${iproduct.image ne \"\" && iproduct.image ne null}">
								<img width="128px" height="128px"
									src="display-product-img-${iproduct.id}.jpg" />
							</c:if></td>
						<td>${iproduct.designer.fio}</td>
						<td><a href="product-editor?id=${iproduct.id}">Edit</a> | <a
							href="delete-product?id=${iproduct.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</div>
</body>
</html>