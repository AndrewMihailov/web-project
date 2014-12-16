<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page pageEncoding="utf-8"%>
<html>
<head>
<title>Furniture - News</title>
<%@ include file="/views/static/head.jsp"%>
</head>
<body>

	<div id="wrap">
		<%@ include file="/views/static/header.jsp"%>
		<div id="content">
			<div class="product">
				<h2>${product.name}</h2>
				<table class="product-info">
					<tr>
						<th>Категория</th>
						<td>${product.category.name}</td>
					</tr>
					<tr>
						<th>Дизайнер</th>
						<td>${product.designer.fio}</td>
					</tr>
					<tr>
						<th>Цена</th>
						<td>${product.price}Р</td>
					</tr>
					<tr>
						<th>Фото</th>
						<td><a href="photos?product_id=${product.id}">ссылка</a></td>
					</tr>
				</table>

				<p>${product.description}</p>

				<c:if test="${product.image ne \"\" && product.image ne null}">
					<img class="img" src="display-product-img-${product.id}.jpg" />
				</c:if>
			</div>
		</div>

	</div>
	<%@ include file="/views/static/footer.jsp"%>

</body>
</html>
