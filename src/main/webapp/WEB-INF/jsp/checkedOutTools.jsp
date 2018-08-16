<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:import url="/WEB-INF/jsp/header.jsp" />


<div class="noHeader" id="masterToolList">
	<h2>
		<span class="toolListHeader">Currently Checked Out Tools</span>
	</h2>

	<div id="toolTable">
		<table class="table table-striped table-hover table-bordered">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Tool id</th>
					<th scope="col">Tool Name</th>
					<th scope="col">Expected Return Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allCheckedOutTools}" var="tool">
					<tr>
						<td>${tool.toolId}</td>
						<td>${tool.toolName}</td>
						<td>${tool.to_date}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />