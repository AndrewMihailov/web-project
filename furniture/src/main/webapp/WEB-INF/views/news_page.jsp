<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page pageEncoding="utf-8"%>
<html>
<head>
<title>Furniture - News</title>
<%@ include file="/WEB-INF/views/static/head.jsp"%>
</head>
<body>

	<div id="wrap">
		<%@ include file="/WEB-INF/views/static/header.jsp"%>
		<div id="content">
			<div class="news">
				<p class="date">${news.date}</p>
				<p>${news.text}</p>
			</div>
		</div>

	</div>
	<%@ include file="/WEB-INF/views/static/footer.jsp"%>

</body>
</html>
