<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page pageEncoding="utf-8"%>
<html>
<head>
<title>Furniture - Products</title>
<%@ include file="/views/static/head.jsp"%>
</head>
<body>

	<div id="wrap">
		<%@ include file="/views/static/header.jsp"%>
		<div id="content">
			<h2><spring:message code="title.products" /></h2>

			<table class="products">
				<c:set var="i" value="0" />
				<tr>
				<c:forEach var="iproduct" items="${products}">
					<c:if test="${i eq 8}">
						${"</tr><tr>"}
						<c:set var="i" value="0" />
					</c:if>
					<c:set var="i" value="${i + 1}" />

					<td onclick="location.href='/furniture/product-page?id=${iproduct.id}';">
						<c:if
							test="${iproduct.image ne \"\" && iproduct.image ne null}">
							<img class="small-img"
								src="display-product-img-${iproduct.id}.jpg" />
						</c:if>
						<div class="clear"></div>
						<p>${iproduct.price}Р</p>
						<p>${iproduct.name}</p>
					</td>
				</c:forEach>
				</tr>
			</table>
		</div>

	</div>
	<%@ include file="/views/static/footer.jsp"%>

</body>
</html>
