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
				<li><a href="${pageContext.request.contextPath}/peliculas/paginate?page=0">Peliculas</a></li>
				<li><a href="${pageContext.request.contextPath}/banners/">Banners</a></li>
				<li><a href="${pageContext.request.contextPath}/noticias/">Noticias</a></li>
				<li><a href="${pageContext.request.contextPath}/contacto/">Contacto</a></li>
				<li><a href="${pageContext.request.contextPath}/horarios/">Horarios</a></li>
				<li><a href="${pageContext.request.contextPath}/acerca">Acerca</a></li>
				<li><a href="#">Login</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>