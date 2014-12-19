<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page pageEncoding="utf-8"%>
<html>
<head>
<title>Furniture - Offers</title>
<%@ include file="/views/static/head.jsp"%>
</head>
<body>

	<div id="wrap">
		<%@ include file="/views/static/header.jsp"%>
		<div id="content">
			<h2>
				<spring:message code="title.offers" />
			</h2>

			<c:forEach var="ioffer" items="${offers}">
				<div class="in-list-material offer">
					<p class="text">${ioffer.text}</p>
					<c:set var="catName" value="${pageContext.response.locale eq \"ru\"?ioffer.category.nameRu:ioffer.category.nameEn}"></c:set>
					<p class="text"><spring:message code='text.sales' arguments="${catName}, ${ioffer.size}" /></p>
				</div>
			</c:forEach>
		</div>

	</div>
	<%@ include file="/views/static/footer.jsp"%>

</body>
</html>
