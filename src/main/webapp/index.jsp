<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
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
</style>
</head>
<body>
	<div class="jumbotron">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">WebSiteName</a>
			<ul class="nav navbar-nav">
				<li class="active"><a href="index.jsp">Home</a></li>
				<li><a href="register.jsp">Sign Up</a></li>
				<li><a href="login.jsp">Login</a></li>
				<li><a href="changepassword.jsp">Change Password</a></li>
				<li><a href="contact.jsp">Contact Us</a></li>
			</ul>
		</div>
	</div>
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
