<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>Admin-panel - Photo-editor</title>
<%@ include file="/WEB-INF/views/admin/static/head.jsp"%>
<c:set var="page_id" scope="session" value="8" />
</head>
<body>

	<div id="wrap">
		<%@ include file="/WEB-INF/views/admin/static/header.jsp"%>
		<div id="content">
			<form name="photo" action="add-photo" method="post">
				<p>Product</p>
				<p>
					<select name="product.id" id="product">
						<c:forEach var="icategory" items="${groupedProducts}">
							<c:if test="${icategory.value.size() ne 0}">
								<optgroup label="${icategory.key}">
									<c:forEach var="iproduct" items="${icategory.value}">
										<option value="${iproduct.id}">${iproduct.name}</option>
									</c:forEach>
								</optgroup>
							</c:if>
						</c:forEach>
					</select>
				</p>
				<p>Image</p>
				<p>
					<input type="file" name="image" />
				</p>
				<p>Description</p>
				<p>
					<textarea rows="5" cols="100" name="description"></textarea>
				</p>
				<p>Width</p>
				<p>
					<input type="text" name="width" id="width" />
				</p>
				<p>Height</p>
				<p>
					<input type="text" name="height" id="height" />
				</p>

				<input type="submit" value="Add" />
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
						<td>${iphoto.image}</td>
						<td>${iphoto.description}</td>
						<td>${iphoto.width}</td>
						<td>${iphoto.height}</td>
						<td><a>Edit</a> | <a href="delete-photo?id=${iphoto.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</div>
</body>
</html>
