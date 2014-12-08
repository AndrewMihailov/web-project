<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>Admin-panel - Designer-editor</title>
<%@ include file="/WEB-INF/views/admin/static/head.jsp"%>
<c:set var="page_id" scope="session" value="7" />
</head>
<body>

	<div id="wrap">
		<%@ include file="/WEB-INF/views/admin/static/header.jsp"%>
		<div id="content">
			<form name="designer" action="add-designer" method="post">
				<p>Name</p>
				<p><input type="text" name="fio" /></p>
				
				<input type="submit" value="Add" />
			</form>

			<h3>All designers</h3>

			<table class="wide-table">
				<tr>
					<th>+</th>
					<th>Name</th>
					<th>Controls</th>
				</tr>
				<c:forEach var="idesigner" items="${designers}">
					<tr>
						<td><input type="checkbox" name="${idesigner.id}" /></td>
						<td>${idesigner.fio}</td>
						<td><a>Edit</a> | <a href="delete-designer?id=${idesigner.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</div>
</body>
</html>
