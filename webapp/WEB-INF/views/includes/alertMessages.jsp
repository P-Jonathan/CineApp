<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${message != null}">
	<div id="messages">
		<div class="alert alert-success alert-message" role="alert">
			<strong>${message}</strong>
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</div>
	<script>

	setTimeout(() => {
		const alerts = document.querySelectorAll(".alert-message");
		const messages = document.querySelector("#messages");
		for(const alert of alerts) {
		    messages.removeChild(alert);
		}
	}, 5000);
	
	</script>
</c:if>