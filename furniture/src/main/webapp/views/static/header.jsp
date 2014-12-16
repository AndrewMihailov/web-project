<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div id="header">

	<a href="/furniture"><img src="resources/css/img/logimg.png" /></a> <a
		href="/furniture/admin/">Admin panel</a>
	<span style="float: right">
		<a href="?lang=en">en</a> | <a href="?lang=ru">ru</a>
	</span>

	<ul id="menu">
		<li><a href="/furniture/"><spring:message code="menu.home" /></a></li>
		<li><a href="/furniture/news"><spring:message code="menu.news" /></a></li>
		<li><a href="/furniture/"><spring:message code="menu.about" /></a>
			<ul>
				<li><a href="/furniture/"><spring:message code="menu.offers" /></a></li>
			</ul></li>
		<li><a href="/furniture/products"><spring:message code="menu.products" /></a></li>
		<li><a href="/furniture/order"><spring:message
					code="menu.order" /></a></li>
		<li><a href="/furniture/"><spring:message code="menu.contacts" /></a></li>
	</ul>

</div>