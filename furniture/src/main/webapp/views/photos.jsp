<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page pageEncoding="utf-8"%>
<html>
<head>
<title>Furniture - Photos</title>
<%@ include file="/views/static/head.jsp"%>
</head>
<body>

	<div id="wrap">
		<%@ include file="/views/static/header.jsp"%>
		<div id="content">
			<h2>Фото продукта</h2>

			<c:forEach var="iphoto" items="${photos}">
				<div class="in-list-material">
					<p><img src="display-photo-${iphoto.id}.jpg" width="${iphoto.width}" height="${iproduct.height}" /></p>
					<p>${iphoto.description}</p>
				</div>
			</c:forEach>
		</div>

	</div>
	<%@ include file="/views/static/footer.jsp"%>

</body>
</html>
