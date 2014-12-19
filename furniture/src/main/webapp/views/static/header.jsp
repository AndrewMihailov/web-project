<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div id="header">

	<span style="float: right">
		<a href="?lang=en">en</a> | <a href="?lang=ru">ru</a>
	</span>

	<a href="/furniture"><img src="resources/css/img/logimg.png" /></a> <a
		href="/furniture/admin/">Admin panel</a>

	<ul id="menu">
		<li><a href="/furniture/"><spring:message code="menu.home" /></a></li>
		<li><a href="/furniture/news"><spring:message code="menu.news" /></a></li>
		<li><a href="/furniture/"><spring:message code="menu.about" /></a>
			<ul>
				<li><a href="/furniture/offers"><spring:message code="menu.offers" /></a></li>
				<li><a href="/furniture/contacts"><spring:message code="menu.contacts" /></a></li>
				<li><a href="/furniture/path"><spring:message code="title.path" /></a></li>
			</ul></li>
		<li><a href="/furniture/products"><spring:message code="menu.products" /></a>
		
			<ul>
				<c:forEach var="i" items="${menuCategories}">
					<li>
						<c:set var="catName" value="${pageContext.response.locale eq \"ru\" ? i.key.nameRu : i.key.nameEn}" />
						<a href="/furniture/products?id=${i.key.id}">${catName}</a>
						<c:if test="${i.value.size() > 0}">
							<ul>
								<c:forEach var="j" items="${i.value}">
									<li>
										<c:set var="catName" value="${pageContext.response.locale eq \"ru\" ? j.nameRu : j.nameEn}" />
										<a href="/furniture/products?id=${j.id}">${catName}</a>
									</li>
								</c:forEach>
							</ul>
						</c:if>
					</li>
				</c:forEach>
			</ul>
		
		</li>
		<li><a href="/furniture/order"><spring:message
					code="menu.order" /></a></li>
					
	</ul>

</div>