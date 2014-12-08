<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>Admin-panel - Offers-editor</title>
<%@ include file="/WEB-INF/views/admin/static/head.jsp"%>
<c:set var="page_id" scope="session" value="4" />
</head>
<body>

	<div id="wrap">
		<%@ include file="/WEB-INF/views/admin/static/header.jsp"%>
		<div id="content">
			<form name="offer" action="add-offer" method="post">
				<p>Category</p>
				<p>
					<select name="category.id">
						<c:forEach var="icategory" items="${categories}">
							<option value="${icategory.id}">${icategory.name}</option>
						</c:forEach>
					</select>
				</p>

				<p>Size</p>
				<p>
					<input type="text" name="size" id="size" />
				</p>

				<p>Preview</p>
				<p>
					<textarea rows="5" cols="100" name="preview"></textarea>
				</p>

				<p>Full text</p>
				<p>
					<textarea rows="10" cols="100" name="text"></textarea>
				</p>

				<input type="submit" value="Add" />
			</form>

			<h3>All offers</h3>

			<table class="wide-table">
				<tr>
					<th>+</th>
					<th>Category</th>
					<th>Size</th>
					<th>Preview</th>
					<th>Text</th>
					<th>Controls</th>
				</tr>
				<c:forEach var="ioffer" items="${offers}">
					<tr>
						<td><input type="checkbox" name="${ioffer.id}" /></td>
						<td>${ioffer.category.name}</td>
						<td>${ioffer.size}</td>
						<td>${ioffer.preview}</td>
						<td>${ioffer.text}</td>
						<td><a href="#" onclick="load(${ioffer.id});">Edit</a> | <a
							href="delete-offer?id=${ioffer.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</div>
</body>
</html>
