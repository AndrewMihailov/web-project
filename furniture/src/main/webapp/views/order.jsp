<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page pageEncoding="utf-8"%>
<html>
<head>
<title>Furniture - Orders</title>
<%@ include file="/views/static/head.jsp"%>
<script src="/furniture/resources/scr/validate_assistant.js"></script>
<script src="resources/scr/order.js"></script>
<script type="text/javascript">
locale='${pageContext.response.locale}';
</script>
</head>
<body>

	<div id="wrap">
		<%@ include file="/views/static/header.jsp"%>
		<div id="content">
			<h2><spring:message code="title.order" /></h2>

			<form class="order" name="order" action="/furniture/make-order" method="post">
				<p><spring:message code="order.name" /></p>
				<input type="text" name="fio" id="fio" />
				<span class="error" id="fio_error"><spring:message code='error.notFilled' /></span>
				<p><spring:message code="order.phone" /></p>
				<input type="text" name="phone" id="phone" />
				<span class="error" id="phone_error"><spring:message code='error.wrongPhone' /></span>
				<p><spring:message code="order.address" /></p>
				<input type="text" name="address" id="address" />
				<span class="error" id="address_error"><spring:message code='error.notFilled' /></span>

				
				<p><spring:message code="order.category" /></p>
				<p>
					<select name="category.id" id="category">
						<c:forEach var="icategory" items="${categories}">
							<option value="${icategory.id}">
								<c:set var="catName" value="${pageContext.response.locale eq \"ru\"?icategory.nameRu:icategory.nameEn}" />
								${catName}
							</option>
						</c:forEach>
					</select>
					<a href="#" id="load_products"><spring:message code="order.loadProducts" /></a>
				</p>
				<p><spring:message code="order.product" /></p>
				<p>
					<select name="product.id" id="product">
					</select>
					<span id="product_error" class="error">Required selection</span>
				</p>
				
				<a href="#" id="add"><spring:message code="order.add" /></a>

				<p><spring:message code="order.list" /></p>
				<table id="product-list">
					<tr>
						<th><spring:message code="order.list.name" /></th>
						<th width="100px"><spring:message code="order.list.price" /></th>
						<th width="100px"><spring:message code="order.list.delete" /></th>
					</tr>
				</table>
				<p class="error" id="list_error"><spring:message code='error.emptyList' /></p>
				<p><spring:message code="order.sum" /></p>
				<p id="total">0</p>
				<input type="submit" value="<spring:message code="order.order" />" />

			</form>

		</div>

	</div>
	<%@ include file="/views/static/footer.jsp"%>

</body>
</html>
