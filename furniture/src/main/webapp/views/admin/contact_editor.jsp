<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>Admin-panel - Contact-editor</title>
<%@ include file="/views/admin/static/head.jsp"%>
<script src="/furniture/resources/scr/admin/contact.js"></script>
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
				<p>Language</p>
				<input type="text" name="lang" value="${contact.lang}" />
				<p>Type</p>
				<input type="text" name="type" id="type" value="${contact.type}" />
				<span id="type_error" class="error">Required to fill</span>
				<p>Fio</p>
				<input type="text" name="fio" id="fio" value="${contact.fio}" />
				<span id="fio_error" class="error">Required to fill</span>
				<p>Telephone number</p>
				<input type="text" name="telNumber" id="telNumber"
					value="${contact.telNumber}" />
				<span id="telNumber_error" class="error">Incorrect phone format</span>
				<p>E-mail</p>
				<input type="text" name="email" id="email" value="${contact.email}" />
				<span id="email_error" class="error">Incorrect email format</span>
				<p>Address</p>
				<input type="text" name="address" id="address"
					value="${contact.address}" />
				<span id="address_error" class="error">Required to fill</span>
				<p>
					<input type="submit" value="Add" />
				</p>
				<c:if test="${edit}">
					<a href="contact-editor">Discard</a>
				</c:if>
			</form>

			<h3>All contacts</h3>

			<table class="wide-table">
				<tr>
					<th>+</th>
					<th>Lang</th>
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
						<td>${icontact.lang}</td>
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
			
			<p>
				Page:
				<c:forEach var="i" begin="1" end="${totalPages}">
					<a <c:if test="${i ne page}"> href="/furniture/admin/contact-editor?page=${i}&perpage=${perpage}" </c:if>>${i}</a>
				</c:forEach>
			</p>
			<p>
				Per page:
				<select id="perpage">
					<option value="1" <c:if test="${perpage eq 1}">selected="selected"</c:if> >1</option>
					<option value="2" <c:if test="${perpage eq 2}">selected="selected"</c:if> >2</option>
					<option value="5" <c:if test="${perpage eq 5}">selected="selected"</c:if> >5</option>
				</select>
			</p>

		</div>
	</div>
</body>
</html>
