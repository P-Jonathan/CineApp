<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<spring:url value="/resources" var="urlPublic" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="">
<title>Creacion de Horarios</title>

<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
</head>

<body>

	<jsp:include page="./../includes/menu.jsp" />

	<div class="container theme-showcase" role="main">

		<h3 class="blog-title">
			<span class="label label-success">Datos del Horario</span>
		</h3>

		<form:form action="${pageContext.request.contextPath}/horarios/${action}"
			method="POST" modelAttribute="horario">
			<div class="row">
				<form:hidden path="id" />
				<div class="col-sm-3">
					<div class="form-group">
						<label for="idPelicula" class="control-label">Pelicula</label>
						<form:select path="pelicula.id" class="form-control">
							<form:options items="${peliculas}" itemValue="id"
								itemLabel="titulo" />
						</form:select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="fecha">Fecha</label>
						<form:input type="text" class="form-control" path="fecha"
							id="fecha" required="required" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="hora">Hora</label>
						<form:input type="text" class="form-control" path="hora" id="hora"
							placeholder="Formato: HH:mm Ejemplo 21:30" required="required" />
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="sala" class="control-label">Sala</label>
						<form:select items="${salas}" id="sala" path="sala"
							class="form-control" />
					</div>
				</div>

				<div class="col-sm-3">
					<div class="form-group">
						<label for="precio">Precio</label>
						<form:input type="text" class="form-control" path="precio"
							id="precio" required="required" />
					</div>
				</div>

			</div>

			<spring:hasBindErrors name="horario">
				<div class="alert alert-danger" role="alert">
					Por favor corrija los siguientes errores:
					<ul>
						<c:forEach var="error" items="${errors.allErrors}">
							<li><spring:message message="${error}" /></li>
						</c:forEach>
					</ul>
				</div>
			</spring:hasBindErrors>

			<form:button type="submit" class="btn btn-danger">Guardar</form:button>

		</form:form>

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
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
		$(function() {
			$("#fecha").datepicker({
				dateFormat : 'dd-mm-yy'
			});
		});
	</script>
</body>
</html>
