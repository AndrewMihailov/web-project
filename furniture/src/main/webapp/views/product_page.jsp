<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page pageEncoding="utf-8"%>
<html>
<head>
<title>Furniture - News</title>
<%@ include file="/views/static/head.jsp"%>
<script src="resources/scr/slideshow_manual.js"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="resources/css/slideshow_manual.css" />" />
</head>
<body>

	<div id="wrap">
		<%@ include file="/views/static/header.jsp"%>
		<div id="content">
			<div class="product">
				<c:set var="catName" value="${pageContext.response.locale eq \"ru\"?product.category.nameRu:product.category.nameEn}" />
				<c:set var="prName" value="${pageContext.response.locale eq \"ru\"?product.nameRu:product.nameEn}" />
				<c:set var="prDescr" value="${pageContext.response.locale eq \"ru\"?product.descriptionRu:product.descriptionEn}" />
				<h2>${prName}</h2>
				<table class="product-info">
					<tr>
						<th><spring:message code="product.category" /></th>
						<td>${catName}</td>
					</tr>
					<tr>
						<th><spring:message code="product.designer" /></th>
						<td>${product.designer.fio}</td>
					</tr>
					<tr>
						<th><spring:message code="product.price" /></th>
						<td>${product.price}Р</td>
					</tr>
				</table>

				<p>${prDescr}</p>
				<br />

				<div id="slideshow">
					<span id="prev"><spring:message code="control.prev" /></span>
					<span id="next"><spring:message code="control.next" /></span>
					
					<div id="slider" class="slider_wrap">
					
						<c:forEach var="iphoto" items="${photos}">
							<div class="slide">
								<p><img src="display-photo-${iphoto.id}.jpg" width="${iphoto.width}" height="${iproduct.height}" /></p>
								<c:set var="photoDescr" value="${pageContext.response.locale eq \"ru\"?iphoto.descriptionRu:iphoto.descriptionEn}" />
								<p>${photoDescr}</p>
							</div>
						</c:forEach>
					
					</div>
				</div>
			</div>
		</div>

	</div>
	<%@ include file="/views/static/footer.jsp"%>

</body>
</html>
