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
			<h2><spring:message code="title.news" /></h2>

			<c:forEach var="inews" items="${news}">
				<div class="in-list-material">
					<h3>
						<a href="/furniture/news-page?id=${inews.id}">${inews.title}</a>
					</h3>
					<p class="date">
						<c:choose>
							<c:when test="${inews.date ne null}">${inews.date}</c:when>
							<c:otherwise>null</c:otherwise>
						</c:choose>
					</p>
					<c:if test="${inews.image ne \"\" and inews.image ne null}">
						<img class="small-img" src="display-news-img-${inews.id}.jpg" />
					</c:if>
					<p class="text">${inews.preview}</p>
					<div class="clear"></div>
				</div>
			</c:forEach>
			
			<p>
				Page:
				<c:forEach var="i" begin="1" end="${totalPages}">
					<a <c:if test="${i ne page}"> href="/furniture/news?page=${i}&perpage=${perpage}" </c:if>>${i}</a>
				</c:forEach>
			</p>
		</div>

	</div>
	<%@ include file="/views/static/footer.jsp"%>

</body>
</html>
