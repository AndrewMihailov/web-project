<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page pageEncoding="utf-8"%>
<html>
<head>
<title>Furniture - Contacts</title>
<%@ include file="/views/static/head.jsp"%>
</head>
<body>

	<div id="wrap">
		<%@ include file="/views/static/header.jsp"%>
		<div id="content">
			<h2>
				<spring:message code="title.contacts" />
			</h2>

			<c:forEach var="icontact" items="${contacts}">
				<div class="in-list-material">
					<h3>${icontact.type}</h3>
					<p>${icontact.fio}</p>
					<p>${icontact.telNumber}</p>
					<p>${icontact.email}</p>
					<p>${icontact.address}</p>
				</div>
			</c:forEach>

		</div>

	</div>
	<%@ include file="/views/static/footer.jsp"%>

</body>
</html>
