<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/resources/" var="urlPublic" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Listado de Peliculas</title>

<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">

</head>

<body>


	<jsp:include page="./../includes/menu.jsp" />


	<div class="container theme-showcase" role="main">

		<jsp:include page="./../includes/alertMessages.jsp"></jsp:include>

		<h3>Listado de Peliculas</h3>

		<a href="${pageContext.request.contextPath}/peliculas/create"
			class="btn btn-success" role="button" title="Nueva Pelicula">Nueva</a><br>
		<br>

		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">
				<tr>
					<th>Titulo</th>
					<th>Genero</th>
					<th>Clasificacion</th>
					<th>Duracion</th>
					<th>Fecha Estreno</th>
					<th>Estatus</th>
					<th>Opciones</th>
				</tr>
				<c:forEach items="${peliculas.content}" var="pelicula">
					<tr>
						<td>${pelicula.titulo}</td>
						<td>${pelicula.genero}</td>
						<td>${pelicula.clasificacion}</td>
						<td>${pelicula.duracion}</td>
						<td><fmt:formatDate value="${pelicula.fechaEstreno}"
								pattern="dd-MM-yyyy" /></td>
						<td><c:choose>
								<c:when
									test="${pelicula.estatus == 'Activa' || pelicula.estatus == 'activa'}">
									<span class="label label-success">${pelicula.estatus}</span>
								</c:when>
								<c:otherwise>
									<span class="label label-danger">${pelicula.estatus}</span>
								</c:otherwise>
							</c:choose></td>
						<td><a
							href="${pageContext.request.contextPath}/peliculas/edit/${pelicula.id}"
							class="btn btn-success btn-sm" role="button" title="Edit"><span
								class="glyphicon glyphicon-pencil"></span></a> <a
							href="${pageContext.request.contextPath}/peliculas/delete/${pelicula.id}"
							class="btn btn-danger btn-sm" role="button" title="Eliminar"
							onclick="return confirm('¿Esta seguro?')"><span
								class="glyphicon glyphicon-trash"></span></a></td>
					</tr>
				</c:forEach>
			</table>

			<nav aria-label="">
				<ul class="pager">
					<c:if test="${actualPage > 0}">
						<li><a
							href="${pageContext.request.contextPath}/peliculas/paginate?page=${actualPage - 1}">Anterior</a></li>
					</c:if>
					<c:if test="${actualPage < maxPage}">
						<li><a
							href="${pageContext.request.contextPath}/peliculas/paginate?page=${actualPage + 1}">Siguiente</a></li>
					</c:if>
				</ul>
			</nav>

		</div>

		<hr class="featurette-divider">

		<jsp:include page="./../includes/footer.jsp" />

	</div>
	<!-- /container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
	<script>

	setTimeout(() => {
		const alerts = document.querySelectorAll(".pelicula-insert-alert");
		const messages = document.querySelector("#messages");
		for(const alert of alerts) {
		    messages.removeChild(alert);
		}
	}, 5000);
	
	</script>
</body>
</html>
