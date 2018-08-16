<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<h1>Search currently checked out tools:</h1>


<div id="newReviewForm">
	<c:url value="/toolHistory" var="formAction" />
	<form action="${formAction}" method="POST">

		<div id="searchString">
			<label for="searchString">Enter search terms here: </label> <input
				type="text" name="searchString" id="searchString">
		</div>

		<c:if test="${charError==true}">
			<h4 style="color: red;">${charErrorMsg}</h4>
		</c:if>

		<div id="searchTypeDropBox">
			<label for="searchType">Search By: </label> <select name="searchType">
				<option value="driversLicense">driver's license</option>
				<option value="toolId">tool ID#</option>
				<option value="userName">user name</option>
			</select>
		</div>

		<div id="submitButtonDiv">
			<input id="formSubmitButton" type="submit" value="Search" />
		</div>
	</form>

</div>

<div id="toolTable">
	<table class="table table-striped table-hover table-bordered">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Individual Tool Id</th>
				<th scope="col">Tool Name</th>
				<th scope="col">User Name</th>
				<th scope="col">Date Checked Out</th>
				<th scope="col">Date Expected Back</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${reservations}" var="reservation">
				<tr>
					<td>${reservation.toolId}</td>
					<td>${reservation.toolName}</td>
					<td>${reservation.name}</td>
					<td>${reservation.from_date}</td>
					<td>${reservation.to_date}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />