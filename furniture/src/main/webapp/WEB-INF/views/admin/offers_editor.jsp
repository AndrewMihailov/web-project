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
				<p>Preview</p>
				<p>
					<textarea rows="5" cols="100" name="prewiev"></textarea>
				</p>

				<p>Full text</p>
				<p>
					<textarea rows="10" cols="100" name="text"></textarea>
				</p>
				<p>Category</p>
				<p>
					<select name="category">
						<option value="1">Category1</option>
						<option value="0">Category2</option>
					</select>
				</p>
				<input type="submit" value="Add" />
			</form>

			<h3>All offers</h3>

			<table class="wide-table">
				<tr>
					<th>+</th>
					<th>Preview</th>
					<th>Text</th>
					<th>Category</th>
					<th>Controls</th>
				</tr>
				<tr>
					<td><input type="checkbox" name="1" /></td>
					<td>preview1</td>
					<td>text1</td>
					<td>category1</td>
					<td><a>Edit</a> | <a>Delete</a></td>
				</tr>
			</table>

		</div>
	</div>
</body>
</html>
