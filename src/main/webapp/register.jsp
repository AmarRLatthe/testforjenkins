<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#birthDate").attr('name').datepicker();
	});
</script>
<style>
@import
	url('https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css')
	;

section {
	padding: 60px 0;
}

section .section-title {
	text-align: center;
	color: #007b5e;
	margin-bottom: 50px;
	text-transform: uppercase;
}

#footer {
	background: #007b5e !important;
}

#footer h5 {
	padding-left: 10px;
	border-left: 3px solid #eeeeee;
	padding-bottom: 6px;
	margin-bottom: 20px;
	color: #ffffff;
}

#footer a {
	color: #ffffff;
	text-decoration: none !important;
	background-color: transparent;
	-webkit-text-decoration-skip: objects;
}

#footer ul.social li {
	padding: 3px 0;
}

#footer ul.social li a i {
	margin-right: 5px;
	font-size: 25px;
	-webkit-transition: .5s all ease;
	-moz-transition: .5s all ease;
	transition: .5s all ease;
}

#footer ul.social li:hover a i {
	font-size: 30px;
	margin-top: -10px;
}

#footer ul.social li a, #footer ul.quick-links li a {
	color: #ffffff;
}

#footer ul.social li a:hover {
	color: #eeeeee;
}

#footer ul.quick-links li {
	padding: 3px 0;
	-webkit-transition: .5s all ease;
	-moz-transition: .5s all ease;
	transition: .5s all ease;
}

#footer ul.quick-links li:hover {
	padding: 3px 0;
	margin-left: 5px;
	font-weight: 700;
}

#footer ul.quick-links li a i {
	margin-right: 5px;
}

#footer ul.quick-links li:hover a i {
	font-weight: 700;
}

@media ( max-width :767px) {
	#footer h5 {
		padding-left: 0;
		border-left: transparent;
		padding-bottom: 0px;
		margin-bottom: 10px;
	}
}

.footer {
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	height: 15%;
	background-color: red;
	color: white;
	text-align: center;
}

body {
	background-size: cover;
}

*[role="form"] {
	max-width: 530px;
	padding: 15px;
	margin: 0 auto;
	border-radius: 0.3em;
	background-color: #f2f2f2;
}

*[role="form"] h2 {
	font-family: 'Open Sans', sans-serif;
	font-size: 40px;
	font-weight: 600;
	color: #000000;
	margin-top: 5%;
	text-align: center;
	text-transform: uppercase;
	letter-spacing: 4px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="jumbotron">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">WebSiteName</a>
			<ul class="nav navbar-nav">
				<li class="active"><a href="index.jsp">Home</a></li>
				<li><a href="register.jsp">Sign Up</a></li>
				<li><a href="login.jsp">Login</a></li>
				<li><a href="contact.jsp">Contact Us</a></li>
			</ul>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-sm-4">
			<img class="img-responsive" alt="" width="500" height="1000" src="https://www.chronicle.com/blogs/linguafranca/files/2018/11/job-interview.jpg">
			</div>
			<div class="col-sm-8">
				<form class="form-horizontal" role="form" method="post"
					action="register.do">
					<h3 align="center">Candidate Registration</h3>
					<div class="form-group">
						<label for="email" class="col-sm-3 control-label">Email* </label>
						<div class="col-sm-9">
							<input type="email" name="email" placeholder="Email"
								class="form-control" name="email"> <span color="red">${InvalidEmail}</span>
						</div>
					</div>
					<div class="form-group">
						<label for="phoneNumber" class="col-sm-3 control-label">Phone
							number </label>
						<div class="col-sm-9">
							<input type="phoneNumber" name="phoneNumber"
								placeholder="Phone number" class="form-control">
							<!--  <span
						class="help-block">Your phone number won't be disclosed
						anywhere </span>-->
							<span color="red">${InvalidPhoneNo}</span>
						</div>
					</div>
					<div class="form-group">
						<label for="firstName" class="col-sm-3 control-label">First
							Name</label>
						<div class="col-sm-9">
							<input type="text" name="name" placeholder="First Name"
								class="form-control" autofocus>
						</div>
					</div>
					<div class="form-group">
						<label for="birthDate" class="col-sm-3 control-label">Date
							of Birth*</label>
						<div class="col-sm-9">
							<input type="date" name="birthDate" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label for="Height" class="col-sm-3 control-label">Job
							Code</label>
						<div class="col-sm-9">
							<select name="jobCode" class="form-control">
								<option>Select</option>
								<option>SSE-12FE</option>
								<option>SAE-45TE</option>
								<option>FRE-56UT</option>
								<option>AAE-12TU</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="experience" class="col-sm-3 control-label">Experience</label>
						<div class="col-sm-9">
							<input type="number" name="experience"
								placeholder="Enter your total experience here"
								class="form-control">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-9 col-sm-offset-3">
							<span class="help-block">*Required fields</span>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-9 col-sm-offset-3">
							<span class="help-block">${duplicateemail}</span>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-9 col-sm-offset-3">
							<span class="help-block">${RegisterSuccessful}</span>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-9 col-sm-offset-3">
							<span class="help-block">${RegisterUnsuccessful}</span>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-9 col-sm-offset-3">
							<input type="submit" class="btn btn-primary"></input> <input
								type="reset" class="btn btn-primary"></input>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<br>
	<br>
	<section id="footer">
	<div class="container">
		<div class="row text-center text-xs-center text-sm-left text-md-left">
			<div class="col-xs-12 col-sm-4 col-md-4">
				<h5>Quick links</h5>
				<ul class="list-unstyled quick-links">
					<li><a href=""><i class="fa fa-angle-double-right"></i>Home</a></li>
					<li><a href=""><i class="fa fa-angle-double-right"></i>About</a></li>
					<li><a href=""><i class="fa fa-angle-double-right"></i>FAQ</a></li>
					<li><a href=""><i class="fa fa-angle-double-right"></i>Get
							Started</a></li>
					<li><a href=""><i class="fa fa-angle-double-right"></i>Videos</a></li>
				</ul>
			</div>
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 mt-2 mt-sm-5">
					<ul class="list-unstyled list-inline social text-center">
						<li class="list-inline-item"><a href="javascript:void();"><i
								class="fa fa-facebook"></i></a></li>
						<li class="list-inline-item"><a href="javascript:void();"><i
								class="fa fa-twitter"></i></a></li>
						<li class="list-inline-item"><a href="javascript:void();"><i
								class="fa fa-instagram"></i></a></li>
						<li class="list-inline-item"><a href="javascript:void();"><i
								class="fa fa-google-plus"></i></a></li>
						<li class="list-inline-item"><a href="javascript:void();"
							target="_blank"><i class="fa fa-envelope"></i></a></li>
					</ul>
				</div>
				</hr>
			</div>
			<div class="row">
				<div
					class="col-xs-12 col-sm-12 col-md-12 mt-2 mt-sm-2 text-center text-white">
					<p>
						<u><a href="https://www.nationaltransaction.com/">National
								Transaction Corporation</a></u> is a Registered MSP/ISO of Elavon, Inc.
						Georgia [a wholly owned subsidiary of U.S. Bancorp, Minneapolis,
						MN]
					</p>
					<p class="h6">
						&copy All right Reversed.<a class="text-green ml-2"
							href="https://www.sunlimetech.com" target="_blank">Sunlimetech</a>
					</p>
				</div>
				</hr>
			</div>
		</div>
	</section>
</body>
</html>