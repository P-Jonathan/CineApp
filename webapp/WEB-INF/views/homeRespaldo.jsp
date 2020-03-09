<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido a Cine App</title>
<spring:url value="/resources" var="urlPublic" />
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="${urlPublic}/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<div class="card my-1">
			<div class="card-header">Bienvenido a la pagina Principal</div>
			<div class="card-body">
				<div class="card-title">
					<h5>Catalogo de peliculas</h5>
				</div>
				<table class="table table-striped table-bordered table-hover">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Titulo</th>
							<th scope="col">Duracion</th>
							<th scope="col">Clasificacion</th>
							<th scope="col">Genero</th>
							<th scope="col">Imagen</th>
							<th scope="col">Fecha de Estreno</th>
							<th scope="col">Estatus</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${peliculas}" var="pelicula">
							<tr>
								<th scope="row">${pelicula.id}</th>
								<td>${pelicula.titulo}</td>
								<td>${pelicula.duracion}min</td>
								<td>${pelicula.clasificacion}</td>
								<td>${pelicula.genero}</td>
								<td><img src="${urlPublic}/${pelicula.imagen}"
									width="100px" /></td>
								<td><fmt:formatDate value="${pelicula.fechaEstreno}"
										pattern="MM/dd/yy" /></td>
								<td><c:choose>
										<c:when test="${pelicula.estatus == 'Activa'}">
											<span class="badge badge-success">ACTIVA</span>
										</c:when>
										<c:otherwise>
											<span class="badge badge-danger">INACTIVA</span>
										</c:otherwise>
									</c:choose></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>