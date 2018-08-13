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

<div id="masterToolList">
<h2>Master Tool List</h2>

<div id="toolTable">
<table class="table table-striped">
<thead class="thead-dark">
<tr>
	<th scope="col" >Individual Tool id</th>
	<th scope="col">Tool Name</th>
	<th scope="col">Tool Description</th>
	<th scope="col">Reservation From-Date</th>
	<th scope="col">Reservation To-date</th>
	
</tr>
</thead>

<tbody>
<%-- <c:for each var="tool" toolsByToolId="${toolsByToolIdList}"> --%>
<tr>
<td>tool.tool_id</td>
<td>tool.tool_name</td>
<td>tool.tool_description</td>
<td>tool.tool_id</td>
<td>tool.tool_name</td>
</tr>

<tr>
<td>tool.tool_id</td>
<td>tool.tool_name</td>
<td>tool.tool_description</td>
<td>tool.tool_id</td>
<td>tool.tool_name</td>
</tr>

<tr>
<td>tool.tool_id</td>
<td>tool.tool_name</td>
<td>tool.tool_description</td>
<td>tool.tool_id</td>
<td>tool.tool_name</td>
</tr>

<%-- </c:for> --%>
</tbody>
</table>

</div>
</div>






<c:import url="/WEB-INF/jsp/footer.jsp" />