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
					<select name="category">
						<option value="1">Category1</option>
						<option value="0">Category2</option>
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
					<th>Controls</th>
				</tr>
				<tr>
					<td><input type="checkbox" name="1" /></td>
					<td>category1</td>
					<td>Name1</td>
					<td>Description1</td>
					<td>image1</td>
					<td><a>Edit</a> | <a>Delete</a></td>
				</tr>
			</table>

		</div>
	</div>
</body>
</html>
