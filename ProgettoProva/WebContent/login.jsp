<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.uniroma3.siw.progetto.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="login.css">
<title>Login</title>
</head>
<body>
	<div class="container">
		<div class="row top-margin">
			<div class="col-md-4"></div>
			<div class="col-md-6">
				<div class="login-container">
					<h2 class="text-center">
						<img src="img/key.png" />
					</h2>
					<form class="login-form" action="admin/controllerLogin.do" method="POST">
						<input type="text" class="input" placeholder="username" /> <input
							type="password" class="input" placeholder="password" /> <input
							type="submit" class="input button" name="username" value="Login">
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
