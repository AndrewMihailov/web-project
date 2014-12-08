<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="header">

	<div id="menu">
		<ul>
			<li><a
				<c:if test="${page_id eq 1}">
					class="current"
				</c:if>
				href="/furniture/admin/home">Home</a></li>
			<c:if test="${admin_role eq \"SUPER\" }">
				<li><a
					<c:if test="${page_id eq 2}">
					class="current"
				</c:if>
					href="/furniture/admin/admin-editor">Admin editor</a></li>
			</c:if>
			<li><a
				<c:if test="${page_id eq 3}">
					class="current"
				</c:if>
				href="/furniture/admin/news-editor">News editor</a></li>
			<li><a
				<c:if test="${page_id eq 4}">
					class="current"
				</c:if>
				href="/furniture/admin/offers-editor">Offers editor</a></li>
			<li><a
				<c:if test="${page_id eq 5}">
					class="current"
				</c:if>
				href="/furniture/admin/product-editor">Product editor</a></li>
			<li><a
				<c:if test="${page_id eq 6}">
					class="current"
				</c:if>
				href="/furniture/admin/category-editor">Category editor</a></li>
			<li><a
				<c:if test="${page_id eq 7}">
					class="current"
				</c:if>
				href="/furniture/admin/designer-editor">Designer editor</a></li>
			<li><a
				<c:if test="${page_id eq 8}">
					class="current"
				</c:if>
				href="/furniture/admin/photo-editor">Photo editor</a></li>
			<li><a
				<c:if test="${page_id eq 9}">
					class="current"
				</c:if>
				href="/furniture/admin/contact-editor">Contact editor</a></li>
		</ul>
	</div>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h4>
			${pageContext.request.userPrincipal.name} |
			<c:url value="/login?logout" var="logoutUrl" />
			<a href="${logoutUrl}">Log Out</a>
		</h4>
	</c:if>

	<%-- <div th:if="${#httpServletRequest.remoteUser != null}">
		<p th:text="${#httpServletRequest.remoteUser}">sample_user</p>
	</div>
	<form th:action="@{/logout}" method="post">
		<input type="submit" value="Log out" />
	</form> --%>

</div>