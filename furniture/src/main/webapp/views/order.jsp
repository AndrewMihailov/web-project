<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page pageEncoding="utf-8"%>
<html>
<head>
<title>Furniture - Orders</title>
<%@ include file="/views/static/head.jsp"%>
<script src="resources/scr/order.js"></script>
</head>
<body>

	<div id="wrap">
		<%@ include file="/views/static/header.jsp"%>
		<div id="content">
			<h2><spring:message code="title.order" /></h2>

			<form class="order" name="order" action="/furniture/make-order" method="post">
				<p><spring:message code="order.name" /></p>
				<input type="text" name="fio" />
				<p><spring:message code="order.phone" /></p>
				<input type="text" name="phone" />
				<p><spring:message code="order.address" /></p>
				<input type="text" name="address" />

				<p><spring:message code="order.product" /></p>
				<select name="product.id" id="product">
					<c:forEach var="icategory" items="${groupedProducts}">
						<c:if test="${icategory.value.size() ne 0}">
							<optgroup label="${icategory.key}">
								<c:forEach var="iproduct" items="${icategory.value}">
									<option value="${iproduct.id}"
										<c:if test="${photo.product.id eq iproduct.id}">selected</c:if>>${iproduct.name}</option>
								</c:forEach>
							</optgroup>
						</c:if>
					</c:forEach>
				</select> <a href="#" id="add"><spring:message code="order.add" /></a>

				<p><spring:message code="order.list" /></p>
				<table id="product-list">
					<tr>
						<th><spring:message code="order.list.name" /></th>
						<th width="100px"><spring:message code="order.list.price" /></th>
						<th width="100px"><spring:message code="order.list.delete" /></th>
					</tr>
				</table>
				
				<p><spring:message code="order.sum" /></p>
				<p id="total">0</p>
				<input type="submit" value="<spring:message code="order.order" />" />

			</form>

		</div>

	</div>
	<%@ include file="/views/static/footer.jsp"%>

</body>
</html>
