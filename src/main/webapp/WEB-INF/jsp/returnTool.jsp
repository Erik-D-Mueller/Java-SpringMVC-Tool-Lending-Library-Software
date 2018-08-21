<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />



<c:if test="${InvalidID!=NULL}">
<c:if test="${InvalidID}">
<h3>Invalid Tool Number, please try again</h3>
</c:if>
</c:if>
<h4>Please enter the tool id number to return:</h4>


<div>
	<c:url value="/returnConfirmation" var="formAction" />
	<form action="${formAction}" method="POST">

		<div>
			<label for="returnTool" id="toolId"> Tool Id: </label> 
			<input type="text" name="toolId" id="toolId" required>
		</div>

		<div>
			<input id="formSubmitButton" type="submit" value="Submit" class = "btn btn-success"/>
		</div>
	</form>

</div>


<c:import url="/WEB-INF/jsp/footer.jsp" />