<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page pageEncoding="utf-8"%>
<html>
<head>
<title>Furniture - Path</title>
<%@ include file="/views/static/head.jsp"%>
</head>
<body>

	<div id="wrap">
		<%@ include file="/views/static/header.jsp"%>
		<div id="content">
			<h2><spring:message code="title.path" /> </h2>
			<p style="margin: 0 auto;padding-top:40px;">
				<script type="text/javascript" charset="utf-8" src="//api-maps.yandex.ru/services/constructor/1.0/js/?sid=tEo62h6Jb_ghpIp7gVhiyrQhwsHxhgdk&width=595&height=309"></script>
			</p>
		</div>

	</div>
	<%@ include file="/views/static/footer.jsp"%>

</body>
</html>
