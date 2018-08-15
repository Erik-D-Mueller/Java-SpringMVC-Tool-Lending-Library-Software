<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<script type="text/javascript">
	$(document).ready(function() {

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

<div class="noHeader" id="masterToolList">
	<h2>
		<span class="toolListHeader">List of All Members</span>
	</h2>

	<c:url value="/availableToolList" var="editCart"/>
	<form action="${editCart}" method="POST">

	<div id="toolTable">
		<table class="table table-striped table-hover table-bordered">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Member ID</th>
					<th scope="col">Member User Name</th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${memberList}" var="member">
					<tr>
						<td>${member.memberId}</td>
						<td>${member.userName}</td>
						<td><a href="${editCart}">edit cart</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
	</form>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />