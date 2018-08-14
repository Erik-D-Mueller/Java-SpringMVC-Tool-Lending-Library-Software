<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<script type="text/javascript">
	$(document).ready(function () {
	
		$("form").validate({
			
			rules : {
				userName : {
					required : true
				},
				password : {
					required : true
				}
			},
			messages : {			
				confirmPassword : {
					equalTo : "Passwords do not match"
				}
			},
			errorClass : "error"
		});
	});
</script>


<h1>Search for a Tool!</h1>


<div id="toolTable">
<table class="table table-striped table-hover table-bordered">
<thead class="thead-dark">
<tr>
	<th scope="col" >Individual Tool id</th>
	<th scope="col">Tool Name</th>
	<th scope="col">Tool Description</th>
</tr>
</thead>

<tbody>
	<c:forEach items="${reservedTools}" var="tool" >
		<tr>
			<td>${tool.toolId}</td>
			<td>${tool.name}</td>
			<td>${tool.description}</td>
		</tr>
	</c:forEach>
</tbody>
</table>

</div>



<c:import url="/WEB-INF/jsp/footer.jsp" />