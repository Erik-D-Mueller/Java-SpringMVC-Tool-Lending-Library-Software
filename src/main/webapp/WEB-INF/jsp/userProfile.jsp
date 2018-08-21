<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />


<h2>
	<span class="toolListHeader">Your Profile</span>
</h2>

<c:if test="${currentUser.role == 'LIBRARIAN'}">
	<p>You're logged in as a librarian.</p>
</c:if>
<c:if test="${currentUser.role == 'MEMBER'}">
	<p>You're logged in as a member.</p>
</c:if>
<br>

<p>Your password is ${currentUser.password}.</p>
<c:url value="/changePassword" var="formAction" />
<form action="${formAction}" method="POST">
	<div id="newPasswordFromJSP">
		<label for="searchString">Enter Your New Password: </label> <input
			type="text" name="newPasswordFromJSP" id="newPasswordFromJSP">
	</div>
	<input class="btn btn-success" id="formSubmitButton" type="submit"
		value="Change Password" />
</form>

<p>Your Driver's License is DRIVER'S LICENSE</p>
<c:url value="/changeDL" var="formAction" />
<form action="${formAction}" method="POST">
	<div id="changeDL">
		<div id="newDL">
			<label for="newDL">Enter Your New Driver's License: </label> <input
				type="text" name="newDL" id="newDL">
		</div>
		<input class="btn btn-success" id="formSubmitButton" type="submit"
			value="Change Driver's License Number" />
	</div>
</form>


<p>Below is a list of tools you have checked out</p>


<div class="table-responsive" id="toolTable">
	<table class="table table-striped table-hover table-bordered">
		<thead class="thead-dark">
			<c:if test="${currentUser != null}">
				<tr>
					<th scope="col">Tool Id</th>
					<th scope="col">Tool Name</th>
					<th scope="col">Date Borrowed</th>
					<th scope="col">Expected Return</th>
				</tr>
			</c:if>
		</thead>

		<tbody>
			<c:if test="${currentUser != null}">
				<c:forEach items="${listOfTools}" var="tool">
					<tr id="divIDNo${tool.toolId}">
						<td>${tool.toolId}</td>
						<td>${tool.toolName}</td>
						<td>${tool.checkoutDate}</td>
						<td>${tool.returnDate}</td>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />