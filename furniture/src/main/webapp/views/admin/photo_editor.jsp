<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>Admin-panel - Photo-editor</title>
<%@ include file="/views/admin/static/head.jsp"%>
<script src="/furniture/resources/scr/admin/photo.js"></script>
<c:set var="page_id" scope="session" value="8" />
</head>
<body>

	<div id="wrap">
		<%@ include file="/views/admin/static/header.jsp"%>
		<div id="content">
			<c:set var="action" value="add-photo" />
			<c:if test="${edit}">
				<c:set var="action" value="edit-photo" />
			</c:if>
			<p>Category</p>
			<p>
				<select name="category.id" id="category">
					<c:set var="groupName" value="root" />
					<c:forEach var="icategory" items="${categories}">
						<c:if test="${icategory.key ne null}">
							<c:set var="groupName" value="${icategory.key.nameRu} | ${icategory.key.nameEn}" />
						</c:if>
						<optgroup label="${groupName}">
							<c:forEach var="iicategory" items="${icategory.value}">
								<option value="${iicategory.id}" <c:if test="${product.category.id eq iicategory.id}">selected</c:if>>
									${iicategory.nameRu} | ${iicategory.nameEn}
								</option>
							</c:forEach>
						</optgroup>
					</c:forEach>
				</select>
				<a href="#" id="load_products">Load products</a>
			</p>
			<form name="photo" action="${action}" method="post" enctype="multipart/form-data">
				<c:if test="${edit}">
					<input hidden="true" name="id" value="${photo.id}" />
				</c:if>
				
				<p>Product</p>
				<p>
					<select name="product.id" id="product">
						<c:if test="${photo ne null}">
							<option value="${photo.product.id}">${photo.product.nameRu} | ${photo.product.nameEn}</option>
						</c:if>
					</select>
					<span id="product_error" class="error">Required selection</span>
				</p>
				
				<p>Image <c:if test="${edit}">
					<input type="checkbox" name="keepimg" id="keepimg" checked="checked" />
						Keep current (newly selected will be ignored)
					</c:if>
				</p>
				<p>
					<input type="file" name="image1" id="image1" value="${photo.image}" />
					<span id="image1_error" class="error">Image required</span>
				</p>
				<p>Description RU</p>
				<p>
					<textarea rows="5" cols="100" name="descriptionRu">${photo.descriptionRu}</textarea>
				</p>
				<p>Description EN</p>
				<p>
					<textarea rows="5" cols="100" name="descriptionEn">${photo.descriptionEn}</textarea>
				</p>
				<p>Width</p>
				<p>
					<input type="text" name="width" id="width" value="${photo.width}" />
				</p>
				<p>Height</p>
				<p>
					<input type="text" name="height" id="height" value="${photo.height}" />
				</p>

				<input type="submit" value="Add" />
				<c:if test="${edit}">
					<a href="photo-editor">Discard</a>
				</c:if>
			</form>

			<h3>All photos</h3>

			<table class="wide-table">
				<tr>
					<th>+</th>
					<th>Product</th>
					<th>Image</th>
					<th>Description</th>
					<th>Width</th>
					<th>Height</th>
					<th>Controls</th>
				</tr>
				<c:forEach var="iphoto" items="${photos}">
					<tr>
						<td rowspan="2"><input type="checkbox" name="${iphoto.id}" /></td>
						<td rowspan="2">${iphoto.product.nameRu} | ${iphoto.product.nameEn}</td>
						<td rowspan="2">
							<img width="128px" height="128px" src="display-photo-${iphoto.id}.jpg" />
						</td>
						<td>${iphoto.descriptionRu}</td>
						<td rowspan="2">${iphoto.width}</td>
						<td rowspan="2">${iphoto.height}</td>
						<td rowspan="2"><a href="photo-editor?id=${iphoto.id}">Edit</a> | <a href="delete-photo?id=${iphoto.id}">Delete</a></td>
					</tr>
					<tr>
						<td>${iphoto.descriptionEn}</td>
					</tr>
				</c:forEach>
			</table>
			
			<p>
				Page:
				<c:forEach var="i" begin="1" end="${totalPages}">
					<a <c:if test="${i ne page}"> href="/furniture/admin/photo-editor?page=${i}&perpage=${perpage}" </c:if>>${i}</a>
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
