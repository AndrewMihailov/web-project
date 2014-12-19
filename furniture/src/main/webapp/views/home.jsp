<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page pageEncoding="utf-8"%>
<html>
<head>
<title>Furniture - Home</title>
<%@ include file="/views/static/head.jsp"%>
<script src="resources/scr/slideshow_auto.js"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="resources/css/slideshow.css" />" />
</head>
<body>

	<div id="wrap">
		<%@ include file="/views/static/header.jsp"%>
		<div id="content">

			<div id="slideshow">
				<div id="slidesContainer">
					<div class="slide">
						<img alt="" src="resources/photo/1.jpg" />
					</div>
					<div class="slide">
						<img alt="" src="resources/photo/2.jpg" />
					</div>
					<div class="slide">
						<img alt="" src="resources/photo/3.jpg" />
					</div>
					<div class="slide">
						<img alt="" src="resources/photo/4.jpg" />
					</div>
				</div>
			</div>

			<div id="container">
				<div id="center" class="column">
					<h2><spring:message code='title.lastNews' /></h2>
					<c:forEach var="inews" items="${news}">
						<div class="news-col">
							<p class="date">
								<c:choose>
									<c:when test="${inews.date ne null}">${inews.date}</c:when>
									<c:otherwise>null</c:otherwise>
								</c:choose>
							</p>
							<p class="text">${inews.preview}</p>
						</div>
					</c:forEach>
				</div>
				<div id="left" class="column">
					<h2><spring:message code='title.about' /></h2>
					<div class="info">
						<p><spring:message code='text.aboutCompany' /></p>
					</div>
				</div>
				<div id="right" class="column">
					<h2><spring:message code='title.offers' /></h2>
					
					<c:forEach var="ioffer" items="${offers}">
						<div class="offer">
							<p class="text">${ioffer.text}</p>
							<p class="text">
								<c:set var="catName" value="${pageContext.response.locale eq \"ru\"?ioffer.category.nameRu:ioffer.category.nameEn}" />
								<spring:message code='text.sales' arguments="${catName}, ${ioffer.size}" />
							</p>
						</div>
					</c:forEach>
				</div>
			</div>

		</div>

	</div>
	<%@ include file="/views/static/footer.jsp"%>

</body>
</html>
