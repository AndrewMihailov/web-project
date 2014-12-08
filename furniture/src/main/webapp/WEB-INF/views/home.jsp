<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page pageEncoding="utf-8"%>
<html>
<head>
<title>Furniture - Home</title>
<%@ include file="/WEB-INF/views/static/head.jsp"%>
</head>
<body>

	<div id="wrap">
		<%@ include file="/WEB-INF/views/static/header.jsp"%>
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
					<h2>Последние новости</h2>
					<c:forEach var="inews" items="${news}">
						<div class="news">
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
					<h2>Информация о компании</h2>
					<div class="info">
						<p>Профессионалы мебельной фабрики ИЗГОТОВЛЕНИЕ МЕБЕЛИ уже
							более 10 лет занимаются производством и продажей мебели на
							территории Крыма (Севастополь, Симферополь). За это время нами
							наработан опыт в сфере продаж, позволяющий удовлетворить самые
							взыскательные запросы потребителей.</p>
						<p>В о снове своей работы мы, как одни из лидеров среди
							производителей мебели, ориентируемся на необходимость, с одной
							стороны, предлагать достаточный ассортимент товара без потери его
							качества, применяя современные дизайнерские разработки для всех
							категорий покупателей, с другой, обеспечивать качественный
							сервис.</p>
					</div>
				</div>
				<div id="right" class="column">
					<h2>Акции</h2>
					
					<c:forEach var="ioffer" items="${offers}">
						<div class="offer">
							<p class="text">${ioffer.preview}</p>
							<p class="text">
								Скидки на категорию ${ioffer.category.name} размером ${ioffer.size}%
							</p>
						</div>
					</c:forEach>
				</div>
			</div>

		</div>

	</div>
	<%@ include file="/WEB-INF/views/static/footer.jsp"%>

</body>
</html>
