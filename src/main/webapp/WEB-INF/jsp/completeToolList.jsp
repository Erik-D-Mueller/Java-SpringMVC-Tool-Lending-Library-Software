<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<div class="noHeader" id="masterToolList">
	
	<h2>
		<span class="toolListHeader">Master Tool List</span>
	</h2>

	<div class="table-responsive" id="toolTable">
		<table
			class="table table-striped table-hover table-bordered">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Tool Id</th>
					<th scope="col">Tool Name</th>
					<th scope="col">Tool Description</th>
					<th scope="col">Is Tool Available</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${allTools}" var="tool">
					<tr>
						<td>${tool.toolId}</td>
						<td>${tool.toolName}</td>
						<td>${tool.toolDescription}</td>
						<c:choose>
						

							<c:when test="${tool.available}">
								<!-- <td style="background-color: #38e241; text-align: center">Available</td> -->
								<td style="background-color: #5cb85c; text-align: center">Available</td>								
							</c:when>
							
							<c:otherwise>
								<!-- <td style="background-color: #3388dd; text-align: center">Checked Out</td> -->
								<td style="background-color: #acc6ef; text-align: center">Checked Out</td>
							</c:otherwise>
							
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />