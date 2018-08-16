<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />


	<h1>
		This is your cart
	</h1>

	<c:url value="/checkoutConfirmation" var="formAction" />
	<form action="${formAction}" method="POST">
		<div id="submitButtonDiv">
			<input id="formSubmitButton" type="submit" value="Check out cart" />
		</div>
	</form>


<c:import url="/WEB-INF/jsp/footer.jsp" />