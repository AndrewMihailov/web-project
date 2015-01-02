<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>Admin-panel - Offers-editor</title>
<%@ include file="/views/admin/static/head.jsp"%>
<script src="/furniture/resources/scr/admin/offer.js"></script>
<c:set var="page_id" scope="session" value="4" />
</head>
<body>

	<div id="wrap">
		<%@ include file="/views/admin/static/header.jsp"%>
		<div id="content">
			<c:set var="action" value="add-offer" />
			<c:if test="${edit}">
				<c:set var="action" value="edit-offer" />
			</c:if>
			<form name="offer" action="${action}" method="post">
				<c:if test="${edit}">
					<input hidden="true" name="id" value="${offer.id}" />
				</c:if>
				
				<p>Language</p>
				<select name="lang">
					<option value="ru" <c:if test="${offer.lang eq \"ru\"}">selected</c:if> >RU</option>
					<option value="en" <c:if test="${offer.lang eq \"en\"}">selected</c:if> >EN</option>
				</select>
				<p>Category</p>
				<p>
					<select name="category.id">
						<c:forEach var="icategory" items="${categories}">
							<option value="${icategory.id}" <c:if test="${offer.category.id eq icategory.id}">selected</c:if> >${icategory.nameRu} | ${icategory.nameEn}</option>
						</c:forEach>
					</select>
				</p>

				<p>Size</p>
				<p>
					<input type="text" name="size" id="size" value="${offer.size}" />
					<span id="size_error" class="error">Must be number</span>
				</p>

				<p>Full text</p>
				<p>
					<textarea rows="10" cols="100" name="text">${offer.text}</textarea>
				</p>

				<input type="submit" value="Add" />
				<c:if test="${edit}">
					<a href="offers-editor">Discard</a>
				</c:if>
			</form>

			<h3>All offers</h3>

			<table class="wide-table">
				<tr>
					<th>+</th>
					<th>Lang</th>
					<th>Category</th>
					<th>Size</th>
					<th>Text</th>
					<th>Controls</th>
				</tr>
				<c:forEach var="ioffer" items="${offers}">
					<tr>
						<td><input type="checkbox" name="${ioffer.id}" /></td>
						<td>${ioffer.lang}</td>
						<td>${ioffer.category.nameRu} | ${ioffer.category.nameEn}</td>
						<td>${ioffer.size}</td>
						<td>${ioffer.text}</td>
						<td><a href="offers-editor?id=${ioffer.id}">Edit</a> | <a
							href="delete-offer?id=${ioffer.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
			
			<p>
				Page:
				<c:forEach var="i" begin="1" end="${totalPages}">
					<a <c:if test="${i ne page}"> href="/furniture/admin/offers-editor?page=${i}&perpage=${perpage}" </c:if>>${i}</a>
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
