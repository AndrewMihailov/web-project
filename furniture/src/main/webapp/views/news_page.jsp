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
			<div class="news">
				<h2>${news.title}</h2>
				<p class="date">${news.date}</p>
				<c:if test="${news.image ne \"\" && news.image ne null}">
					<img class="img" src="display-news-img-${news.id}.jpg" />
				</c:if>
				<p>${news.text}</p>
				<div class="clear"></div>
			</div>
		</div>

	</div>
	<%@ include file="/views/static/footer.jsp"%>

</body>
</html>
