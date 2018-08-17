<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Tool Library</title>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://cdn.jsdelivr.net/jquery.validation/1.15.0/jquery.validate.min.js"></script>
<script
	src="http://cdn.jsdelivr.net/jquery.validation/1.15.0/additional-methods.js "></script>
<script
	src="https://cdn.jsdelivr.net/jquery.timeago/1.4.1/jquery.timeago.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<c:url var="cssHref" value="/css/styles.css" />
<link rel="stylesheet" type="text/css" href="${cssHref}">

<script type="text/javascript">
	$(document).ready(function() {
		$("time.timeago").timeago();

		$("#logoutLink").click(function(event) {
			$("#logoutForm").submit();
		});

		var pathname = window.location.pathname;
		$("nav a[href='" + pathname + "']").parent().addClass("active");

	});
</script>

</head>
<body>
	<header>
		<c:url var="homePageHref" value="/" />
		<c:url var="imgSrc" value="/img/PowerDrills.jpg" />
	</header>
	<div class="jumbotron jumbotron-billboard">
	  <div class="img"></div>
	    <div class="container">
	        <div class="row">
	            <div class="col-lg-12">
	              <h2>Tool Library</h2>
	                <p>
	                    Please take a look at our collection of tools!
	                </p>
	            </div>
	        </div>
	    </div>
	</div>
</div>
	<c:url var="homePageHref" value="/" />
	<c:url var="toolSearchHref" value="/toolHistory" />
	<c:url var="toolMasterHref" value="/completeToolList" />
	<c:url var="availableToolHref" value="/availableToolList" />
	<c:url var="checkedOutToolsHref" value="/checkedOutTools" />
	<c:url var="viewCartHref" value="/viewCart" />
	<c:url var="memberListHref" value="/memberList" />
	
	
	<nav class="navbar navbar-default navbar-expand-lg navbar-light bg-light">

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="nav navbar-nav">
				<li class="nav-item"><a class="nav-link" href="${homePageHref}">Home</a></li>
				<li><a href="${toolSearchHref}">Tool Search</a></li>

				<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Tool Lists </a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a href="${toolMasterHref}">Tool Master List</a> </li>
						<li><a href="${availableToolHref}">Available Tools</a> </li>
						<li class="dropdown-item nav-item" ><a href="${checkedOutToolsHref}">Currently Checked Out</a></li>
					</ul>
				</li>
				<li><a href="${viewCartHref}">View Cart</a></li>
				<li><a href="${memberListHref}">Member List</a></li>

				<c:if test="${not empty currentUser}">
					<c:url var="dashboardHref" value="/users/${currentUser}" />
					<li><a href="${dashboardHref}">Private Messages</a></li>
					<c:url var="newMessageHref"
						value="/users/${currentUser}/messages/new" />
					<li><a href="${newMessageHref}">New Message</a></li>
					<c:url var="sentMessagesHref"
						value="/users/${currentUser}/messages" />
					<li><a href="${sentMessagesHref}">Sent Messages</a></li>
					<c:url var="changePasswordHref"
						value="/users/${currentUser}/changePassword" />
					<li><a href="${changePasswordHref}">Change Password</a></li>
				</c:if>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${empty currentUser}">
						<c:url var="newUserHref" value="/users/new" />
						<li><a href="${newUserHref}">Sign Up</a></li>
						<c:url var="loginHref" value="/login" />
						<li><a href="${loginHref}">Log In</a></li>
					</c:when>
					<c:otherwise>
						<c:url var="logoutAction" value="/logout" />
						<form id="logoutForm" action="${logoutAction}" method="POST">
							<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
						</form>
						<li><a id="logoutLink" href="#">Log Out</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</nav>
	<c:if test="${not empty currentUser}">
		<p id="currentUser">Current User: ${currentUser}</p>
	</c:if>
	<div class="container">