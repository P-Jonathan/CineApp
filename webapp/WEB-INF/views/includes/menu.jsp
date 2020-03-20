<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!-- Fixed navbar -->
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${pageContext.request.contextPath}">My
				CineSite</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<sec:authorize access="hasAnyAuthority('GERENTE')">
					<li><a href="${pageContext.request.contextPath}/peliculas/paginate?page=0">Peliculas</a></li>
					<li><a href="${pageContext.request.contextPath}/noticias/">Noticias</a></li>
					<li><a href="${pageContext.request.contextPath}/horarios/paginate?page=0">Horarios</a></li>
					<li><a href="${pageContext.request.contextPath}/banners/">Banners</a></li>
					<li><a href="${pageContext.request.contextPath}/contacto/">Contacto</a></li>
					<li><a href="${pageContext.request.contextPath}/acerca">Acerca</a></li>
					<li><a href="${pageContext.request.contextPath}/admin">Administracion</a></li>
					<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
				</sec:authorize>
				<sec:authorize access="hasAnyAuthority('EDITOR')">
					<li><a href="${pageContext.request.contextPath}/peliculas/paginate?page=0">Peliculas</a></li>
					<li><a href="${pageContext.request.contextPath}/noticias/">Noticias</a></li>
					<li><a href="${pageContext.request.contextPath}/horarios/paginate?page=0">Horarios</a></li>
					<li><a href="${pageContext.request.contextPath}/contacto/">Contacto</a></li>
					<li><a href="${pageContext.request.contextPath}/acerca">Acerca</a></li>
					<li><a href="${pageContext.request.contextPath}/admin">Administracion</a></li>
					<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
				</sec:authorize>
				<sec:authorize access="isAnonymous()">
					<li><a href="${pageContext.request.contextPath}/contacto/">Contacto</a></li>
					<li><a href="${pageContext.request.contextPath}/acerca">Acerca</a></li>
					<li><a href="${pageContext.request.contextPath}/login">Login</a></li>
				</sec:authorize>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>