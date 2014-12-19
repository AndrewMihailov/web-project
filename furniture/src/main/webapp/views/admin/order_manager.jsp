<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>Admin-panel - Order manager</title>
<%@ include file="/views/admin/static/head.jsp"%>
<c:set var="page_id" scope="session" value="10" />
</head>
<body>

	<div id="wrap">
		<%@ include file="/views/admin/static/header.jsp"%>
		<div id="content">
			<h2>Orders</h2>
			
			<table class="wide-table">
				<tr>
					<th>Controls</th>
					<th>FIO</th>
					<th>Address</th>
					<th>Phone</th>
					<th>Fulfilled</th>
					<th>Products</th>
				</tr>
				<c:forEach var="order" items="${orders}">
					<tr>
						<c:set var="size" value="${order.products.size() + 1}" />
						<td rowspan="${size}">
							<c:choose>
								<c:when test="${order.fulfilled}">
									<a href="fulfill-order?id=${order.id}&val=false">Rollback</a>
								</c:when>
								<c:otherwise>
									<a href="fulfill-order?id=${order.id}&val=true">Fulfill</a>
								</c:otherwise>
							</c:choose>
							| <a href="delete-order?id=${order.id}">Delete</a>
						</td>
						<td rowspan="${size}">${order.fio}</td>
						<td rowspan="${size}">${order.address}</td>
						<td rowspan="${size}">${order.phone}</td>
						<td rowspan="${size}">${order.fulfilled}</td>
					</tr>
					<c:forEach var="product" items="${order.products}" >
						<tr>
							<td>${product.product.nameRu}</td>
						</tr>
					</c:forEach>
				</c:forEach>
			</table>

		</div>
	</div>
</body>
</html>
