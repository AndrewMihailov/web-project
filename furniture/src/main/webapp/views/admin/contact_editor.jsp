<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>Admin-panel - Contact-editor</title>
<%@ include file="/views/admin/static/head.jsp"%>
<c:set var="page_id" scope="session" value="9" />
</head>
<body>

	<div id="wrap">
		<%@ include file="/views/admin/static/header.jsp"%>
		<div id="content">
			<c:set var="action" value="add-contact" />
			<c:if test="${edit}">
				<c:set var="action" value="edit-contact" />
			</c:if>
			<form name="contact" action="${action}" method="post">
				<c:if test="${edit}">
					<input hidden="true" name="id" value="${contact.id}" />
				</c:if>
				<p>Type</p>
				<p>
					<input type="text" name="type" id="type" value="${contact.type}" />
				</p>
				<p>Fio</p>
				<p>
					<input type="text" name="fio" id="fio" value="${contact.fio}" />
				</p>
				<p>Telephone number</p>
				<p>
					<input type="text" name="telNumber" id="telNumber"
						value="${contact.telNumber}" />
				</p>
				<p>E-mail</p>
				<p>
					<input type="text" name="email" id="email" value="${contact.email}" />
				</p>
				<p>Address</p>
				<p>
					<input type="text" name="address" id="address"
						value="${contact.address}" />
				</p>

				<input type="submit" value="Add" />
				<c:if test="${edit}">
					<a href="contact-editor">Discard</a>
				</c:if>
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
						<td><a href="contact-editor?id=${icontact.id}">Edit</a> | <a
							href="delete-contact?id=${icontact.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</div>
</body>
</html>
