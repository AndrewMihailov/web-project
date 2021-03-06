<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>Admin-panel - Category-editor</title>
<%@ include file="/views/admin/static/head.jsp"%>
<script src="/furniture/resources/scr/admin/category.js"></script>
<c:set var="page_id" scope="session" value="6" />
</head>
<body>

	<div id="wrap">
		<%@ include file="/views/admin/static/header.jsp"%>
		<div id="content">
			<c:set var="action" value="add-category" />
			<c:if test="${edit}">
				<c:set var="action" value="edit-category" />
			</c:if>
			<form name="category" action="${action}" method="post">
				<c:if test="${edit}">
					<input hidden="true" name="id" value="${category.id}" />
				</c:if>
				<p>Name RU</p>
				<p><input type="text" name="nameRu" id="nameRu" value="${category.nameRu}" /></p>
				<span id="nameRu_error" class="error">Required to fill</span>
				
				<p>Name EN</p>
				<p><input type="text" name="nameEn" id="nameEn" value="${category.nameEn}" /></p>
				<span id="nameEn_error" class="error">Required to fill</span>
				
				<p>Parent category</p>
				<p>
					<select name="parent.id" id="parent">
						<c:set var="groupName" value="root" />
						<option value="null">Null</option>
						<c:forEach var="icategory" items="${categoryList}">
							<%-- <c:if test="${category.id ne icategory.id}">
								<option value="${icategory.id}"
									<c:if test="${category.parent.id eq icategory.id}">selected</c:if>>${icategory.nameRu} | ${icategory.nameEn}
								</option>
							</c:if> --%>
							
							<c:if test="${icategory.key ne null}">
								<c:set var="groupName" value="${icategory.key.nameRu} | ${icategory.key.nameEn}" />
							</c:if>
							<optgroup label="${groupName}">
								<c:forEach var="iicategory" items="${icategory.value}">
									<option value="${iicategory.id}" <c:if test="${category.parent.id eq iicategory.id}">selected</c:if>>
										${iicategory.nameRu} | ${iicategory.nameEn}
									</option>
								</c:forEach>
							</optgroup>
						</c:forEach>
					</select>
				</p>
				
				<input type="submit" value="Add" />
				<c:if test="${edit}">
					<a href="category-editor">Discard</a>
				</c:if>
			</form>

			<h3>All categories</h3>

			<table class="wide-table">
				<tr>
					<th>+</th>
					<th>Name RU</th>
					<th>Name EN</th>
					<th>Parent</th>
					<th>Controls</th>
				</tr>
				<c:forEach var="icategory" items="${categories}">
					<tr>
						<td><input type="checkbox" name="${icategory.id}" /></td>
						<td>${icategory.nameRu}</td>
						<td>${icategory.nameEn}</td>
						<td>
							<c:if test="${icategory.parent ne null}">
								${icategory.parent.nameRu} | ${icategory.parent.nameEn}
							</c:if>
						</td>
						<td><a href="category-editor?id=${icategory.id}">Edit</a> | <a href="delete-category?id=${icategory.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
			
			<p>
				Page:
				<c:forEach var="i" begin="1" end="${totalPages}">
					<a <c:if test="${i ne page}"> href="/furniture/admin/category-editor?page=${i}&perpage=${perpage}" </c:if>>${i}</a>
				</c:forEach>
			</p>
			<p>
				Per page:
				<select id="perpage">
					<option value="1" <c:if test="${perpage eq 1}">selected="selected"</c:if> >1</option>
					<option value="2" <c:if test="${perpage eq 2}">selected="selected"</c:if> >2</option>
					<option value="5" <c:if test="${perpage eq 5}">selected="selected"</c:if> >5</option>
					<option value="20" <c:if test="${perpage eq 20}">selected="selected"</c:if> >20</option>
				</select>
			</p>

		</div>
	</div>
</body>
</html>
