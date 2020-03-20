<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/resources" var="urlPublic" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CineSite | Bienvenido</title>
<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
</head>

<body>
	<jsp:include page="/WEB-INF/views/includes/menu.jsp" />

	<div class="container theme-showcase" role="main">

		<!-- Marketing messaging -->
		<div class="container marketing">

			<h3>Listado de Peliculas</h3>

			<hr class="featurette-divider">

			<div class="row">

				<div class="col-sm-12 blog-main">
					<c:forEach items="${noticias}" var="noticia">
						<div class="blog-post">
							<h3 class="blog-post-title">${noticia.titulo}</h3>

							<p class="blog-post-meta">
								<span class="label label-danger">Publicado: <fmt:formatDate
										value="${noticia.fecha}" pattern="dd-MM-yyyy" />
								</span>
							</p>
							<p>${noticia.detalle}</p>

							<div class="btn-toolbar" role="toolbar">
								<div class="btn-group justify-content-between" role="group">
									<a
										href="${pageContext.request.contextPath}/noticias/edit/${noticia.id}"
										class="btn btn-info">Editar</a> <a
										href="${pageContext.request.contextPath}/noticias/delete/${noticia.id}"
										class="btn btn-danger"
										onclick="return confirm('¿Esta seguro de borrar esta noticia?')">Borrar</a>
								</div>
							</div>
							<hr class="featurette-divider">
						</div>
					</c:forEach>

					<a href="${pageContext.request.contextPath}/noticias/create"
						class="btn btn-block btn-success">Crear noticia</a>
				</div>
			</div>

		</div>

		<jsp:include page="/WEB-INF/views/includes/footer.jsp" />

	</div>
	<!-- /container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
