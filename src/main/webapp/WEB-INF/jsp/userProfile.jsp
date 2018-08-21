<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$.validator.addMethod('capitals', function(thing) {
							return thing.match(/[A-Z]/);
						});
						$("#changePassWordForm")
								.validate(
										{

											rules : {
												userName : {
													required : true
												},
												password : {
													required : true,
													minlength : 8,
													capitals : true,
												},
												confirmPassword : {
													required : true,
													equalTo : "#password"
												}
											},
											messages : {
												password : {
													minlength : "Password too short, make it at least 8 characters",
													capitals : "Field must contain a capital letter",
												},
												confirmPassword : {
													equalTo : "Passwords do not match"
												}
											},
											errorClass : "error"
										});
					});
</script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$.validator.addMethod('capitals', function(thing) {
							return thing.match(/[A-Z]/);
						});
						$("#changeDL")
								.validate(
										{

											rules : 
												password : {
													required : true,
													minlength : 8,
													capitals : true,
												},
												confirmPassword : {
													required : true,
													equalTo : "#password"
												}
											},
											messages : {
												password : {
													minlength : "Password too short, make it at least 8 characters",
													capitals : "Field must contain a capital letter",
												},
												confirmPassword : {
													equalTo : "Passwords do not match"
												}
											},
											errorClass : "error"
										});
					});
</script>



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

<div id="bothInputs">
<div class="blueBox">
	<p>Would you like to change your password?</p>
	<c:url value="/changePassword" var="formAction" />
	
	<form id="changePassWordForm" action="${formAction}" method="POST">

		<div id="newPasswordFromJSP">
			<label for="password">Enter your new password: </label> <input
				type="password" id="password" name="password">
		</div>


		<br>


		<div class="form-group">
			<label for="confirmPassword">Confirm your new password:</label> <input
				type="password" id="confirmPassword" name="confirmPassword"
				placeHolder="Re-Type Password" />
		</div>




		<input class="btn btn-success" id="formSubmitButton" type="submit"
			value="Change Password" />

	</form>

</div>



<br>
<br>

<div class="blueBox">
	<p>Your Driver's License is listed as
		"${currentUser.driversLicense}". Would you like to change it?</p>
	<c:url value="/changeDL" var="formAction" />


	<form id ="changeDL" action="${formAction}" method="POST">
		

			
			<div id="newDL">
				<label for="password">Enter Your New Driver's License: </label> <input
					type="text" name="password" id="password">
			</div>
			<div id="confirmNewDL">
				<label for="confirmPassword">Confirm Your New Driver's License: </label> <input
					type="text" name="confirmPassword" id="confirmPassword">
			</div>
			
			
		<!-- 		<div id="newDL">
				<label for="newDL">Enter Your New Driver's License: </label> <input
					type="text" name="newDL" id="newDL">
			</div>
			<div id="confirmNewDL">
				<label for="confirmNewDL">Confirm Your New Driver's License: </label> <input
					type="text" name="confirmNewDL" id="confirmNewDL">
			</div> -->
			
			
			<br>
			<input class="btn btn-success" id="formSubmitButton" type="submit"
			
				value="Change Driver's License Number" />
		
	</form>


</div>
</div>
<br>
<br>
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