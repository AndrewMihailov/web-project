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
			<h2>Новости</h2>

			<c:forEach var="inews" items="${news}">
				<div class="news">
					<p class="date">
						<c:choose>
							<c:when test="${inews.date ne null}">${inews.date}</c:when>
							<c:otherwise>null</c:otherwise>
						</c:choose>
					</p>
					<p class="text"><a href="/furniture/news-page?id=${inews.id}">${inews.preview}</a></p>
				</div>
			</c:forEach>
		</div>

	</div>
	<%@ include file="/WEB-INF/views/static/footer.jsp"%>

</body>
</html>
