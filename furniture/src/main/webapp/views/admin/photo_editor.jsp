<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>Admin-panel - Photo-editor</title>
<%@ include file="/views/admin/static/head.jsp"%>
<c:set var="page_id" scope="session" value="8" />
</head>
<body>

	<div id="wrap">
		<%@ include file="/views/admin/static/header.jsp"%>
		<div id="content">
			<c:set var="action" value="add-photo" />
			<c:if test="${edit}">
				<c:set var="action" value="edit-photo" />
			</c:if>
			<form name="photo" action="${action}" method="post" enctype="multipart/form-data">
				<c:if test="${edit}">
					<input hidden="true" name="id" value="${photo.id}" />
				</c:if>
				<p>Product</p>
				<p>
					<select name="product.id" id="product">
						<c:forEach var="icategory" items="${groupedProducts}">
							<c:if test="${icategory.value.size() ne 0}">
								<optgroup label="${icategory.key}">
									<c:forEach var="iproduct" items="${icategory.value}">
										<option value="${iproduct.id}" <c:if test="${photo.product.id eq iproduct.id}">selected</c:if> >${iproduct.name}</option>
									</c:forEach>
								</optgroup>
							</c:if>
						</c:forEach>
					</select>
				</p>
				
				<p>Image <c:if test="${edit}"><input type="checkbox" name="keepimg" />Keep current (newly selected will be ignored)</c:if></p>
				<p>
					<input type="file" name="image1" value="${photo.image}" />
				</p>
				<p>Description</p>
				<p>
					<textarea rows="5" cols="100" name="description">${photo.description}</textarea>
				</p>
				<p>Width</p>
				<p>
					<input type="text" name="width" id="width" value="${photo.width}" />
				</p>
				<p>Height</p>
				<p>
					<input type="text" name="height" id="height" value="${photo.height}" />
				</p>

				<input type="submit" value="Add" />
				<c:if test="${edit}">
					<a href="photo-editor">Discard</a>
				</c:if>
			</form>

			<h3>All photos</h3>

			<table class="wide-table">
				<tr>
					<th>+</th>
					<th>Product</th>
					<th>Image</th>
					<th>Description</th>
					<th>Width</th>
					<th>Height</th>
					<th>Controls</th>
				</tr>
				<c:forEach var="iphoto" items="${photos}">
					<tr>
						<td><input type="checkbox" name="${iphoto.id}" /></td>
						<td>${iphoto.product.name}</td>
						<td>
						<img width="128px" height="128px" src="display-photo-${iphoto.id}.jpg" />
						</td>
						<td>${iphoto.description}</td>
						<td>${iphoto.width}</td>
						<td>${iphoto.height}</td>
						<td><a href="photo-editor?id=${iphoto.id}">Edit</a> | <a href="delete-photo?id=${iphoto.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</div>
</body>
</html>
