<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>Admin-panel - Contact-editor</title>
<%@ include file="/WEB-INF/views/admin/static/head.jsp"%>
<c:set var="page_id" scope="session" value="9" />
</head>
<body>

	<div id="wrap">
		<%@ include file="/WEB-INF/views/admin/static/header.jsp"%>
		<div id="content">
			<form name="contact" action="add-contact" method="post">
				<p>Type</p>
				<p><input type="text" name="type" id="type" /></p>
				<p>Fio</p>
				<p><input type="text" name="fio" id="fio" /></p>
				<p>Telephone number</p>
				<p><input type="text" name="telNumber" id="telNumber" /></p>
				<p>E-mail</p>
				<p><input type="text" name="email" id="email" /></p>
				<p>Address</p>
				<p><input type="text" name="address" id="address" /></p>
				
				<input type="submit" value="Add" />
			</form>

			<h3>All contacts</h3>

			<table class="wide-table">
				<tr>
					<th>+</th>
					<th>Type</th>
					<th>Fio</th>
					<th>Telephone number</th>
					<th>E-mail</th>
					<th>Address</th>
					<th>Controls</th>
				</tr>
				<c:forEach var="icontact" items="${contacts}">
					<tr>
						<td><input type="checkbox" name="${icontact.id}" /></td>
						<td>${icontact.type}</td>
						<td>${icontact.fio}</td>
						<td>${icontact.telNumber}</td>
						<td>${icontact.email}</td>
						<td>${icontact.address}</td>
						<td><a href="#" onclick="load(${icontact.id});">Edit</a>
						| <a href="delete-contact?id=${icontact.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</div>
</body>
</html>
