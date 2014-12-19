<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>Admin-panel - News-editor</title>
<%@ include file="/views/admin/static/head.jsp"%>
<script src="/furniture/resources/scr/admin/news.js"></script>
<c:set var="page_id" scope="session" value="3" />
</head>
<body>

	<div id="wrap">
		<%@ include file="/views/admin/static/header.jsp"%>
		<div id="content">
			<c:set var="action" value="add-news" />
			<c:if test="${edit}">
				<c:set var="action" value="edit-news" />
			</c:if>
			<form name="news" action="${action}" method="post"
				enctype="multipart/form-data">
				<c:if test="${edit}">
					<input hidden="true" name="id" value="${news.id}" />
				</c:if>
				<p>Language</p>
				<select name="lang">
					<option value="ru" <c:if test="${news.lang eq \"ru\"}">selected</c:if> >RU</option>
					<option value="en" <c:if test="${news.lang eq \"en\"}">selected</c:if> >EN</option>
				</select>
				<p>Title</p>
				<input type="text" name="title" id="title" value="${news.title}" />
				<span id="title_error" class="error">Required to fill</span>
				<p>Preview</p>
				<textarea rows="5" cols="100" name="preview" id="preview">${news.preview}</textarea>
				<span id="preview_error" class="error">Required to fill</span>
				<p>Full text</p>
				<textarea rows="10" cols="100" name="text" id="text">${news.text}</textarea>
				<span id="text_error" class="error">Required to fill</span>
				<p>
					Image
					<c:if test="${edit}">
						<input type="checkbox" name="keepimg" checked="checked" />Keep current (newly selected will be ignored)
					</c:if>
				</p>
				<input type="file" name="image1" value="${news.image}" />
				<p>
					<input type="submit" value="Add" />
				</p>
				<c:if test="${edit}">
					<a href="news-editor">Discard</a>
				</c:if>
			</form>

			<h3>All news</h3>

			<table class="wide-table">
				<tr>
					<th>+</th>
					<th>Lang</th>
					<th>Title</th>
					<th>Date</th>
					<th>Preview</th>
					<th>Text</th>
					<th>Image</th>
					<th>Controls</th>
				</tr>
				<c:forEach var="inews" items="${newss}">
					<tr>
						<td><input type="checkbox" name="${inews.id}" /></td>
						<td>${inews.lang}</td>
						<td>${inews.title}</td>
						<td>${inews.date}</td>
						<td>${inews.preview}</td>
						<td>${inews.text}</td>
						<td><c:if
								test="${inews.image ne \"\" && inews.image ne null}">
								<img width="128px" src="display-news-img-${inews.id}.jpg" />
							</c:if></td>
						<td><a href="news-editor?id=${inews.id}">Edit</a> | <a
							href="delete-news?id=${inews.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</div>
</body>
</html>
