<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<h1>${user.name}</h1>

<div class="row">
	<div class="col-sm-4"></div>
	<div class="col-sm-4">
		<c:url var="formAction" value="/login" />

		<form method="POST" action="${formAction}">
			<input type="hidden" name="destination" value="${param.destination}" />
			<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />

			<div class="form-group">
				<label for="userName">User Name</label> <input type="text"
					class="form-control" id="username" aria-describedby="emailHelp"
					name="userName" placeHolder="User Name" />
			</div>

			<div class="form-group">
				<label for="password">Password</label> <input type="password"
					class="form-control" id="password" name="password"
					placeHolder="Password" />
			</div>

			<button type="submit" class="btn btn-primary" id="login-btn">Login</button>
		</form>

	</div>
	<div class="col-sm-4"></div>
</div>

<c:if test="${loginFail==true}">
	<div class="row" id="login-error">
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
			<h7 class="error">&#9888 Your username or password doesn't match
				what we have on file. Try signing in again.</h7>
		</div>
		<div class="col-sm-4"></div>
	</div>
</c:if>
<c:import url="/WEB-INF/jsp/footer.jsp" />