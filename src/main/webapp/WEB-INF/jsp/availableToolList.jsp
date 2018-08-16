<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<div class="noHeader" id="masterToolList">
	<h2>
		<span class="toolListHeader">Currently Available Tools</span>
	</h2>

	<h2>${memberName}</h2>

	<c:url value="/viewCart" var="formAction" />
	<form action="${formAction}" method="GET">

		<div id="toolTable">
			<table class="table table-striped table-hover table-bordered">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Individual Tool id</th>
						<th scope="col">Tool Name</th>
						<th scope="col">Tool Description</th>
						<c:if test="${member != null}">
							<th>Check box to select item</th>
						</c:if>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${availableTools}" var="tool">
						<tr id="divIDNo${tool.toolId}">
							<td>${tool.toolId}</td>
							<td>${tool.name}</td>
							<td>${tool.description}</td>
							<td>
								<c:if test="${member != null}">
									<div id="submitButtonDiv">
										<input id="formSubmitButton" type="submit" value="Add to Cart" />
									</div>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<c:url value="/viewCart" var="formAction" />
		
	</form>

</div>






<c:import url="/WEB-INF/jsp/footer.jsp" />