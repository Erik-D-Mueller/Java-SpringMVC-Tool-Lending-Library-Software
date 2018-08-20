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
<p> Below is a list of tools you have checked out </p>
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