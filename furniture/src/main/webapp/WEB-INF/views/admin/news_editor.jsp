<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>Admin-panel - News-editor</title>
<%@ include file="/WEB-INF/views/admin/static/head.jsp"%>
<c:set var="page_id" scope="session" value="3" />
</head>
<body>

	<div id="wrap">
		<%@ include file="/WEB-INF/views/admin/static/header.jsp"%>
		<div id="content">
			<form name="news" action="add-news" method="post">
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

			<h3>All news</h3>

			<table class="wide-table">
				<tr>
					<th>+</th>
					<th>Preview</th>
					<th>Text</th>
					<th>Controls</th>
				</tr>
				<c:forEach var="inews" items="${news}">
					<tr>
						<td><input type="checkbox" name="${inews.id}" /></td>
						<td>${inews.preview}</td>
						<td>${inews.text}</td>
						<td><a>Edit</a> | <a>Delete</a></td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</div>
</body>
</html>
