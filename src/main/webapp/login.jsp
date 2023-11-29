<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="icon" type="image/x-icon" href="images/short-cut.svg">
<title>Sign in Form</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<div class="main">

		<!-- Sing in  Form -->
		<section class="sign-in">
			<div class="container">
				<div class="signin-content">
					<div class="signin-image">
						<figure>
							<img src="images/signin-image.jpg" alt="sing up image">
						</figure>
						<a href="registration.jsp" class="signup-image-link">Create an
							account</a>
					</div>

					<div class="signin-form">
						<h2 class="form-title">Sign in</h2>
						<form method="post" action="login" class="register-form"
							id="login-form">
							<div class="form-group">
								<label for="username"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="email" id="email"
									placeholder="Your email or Username" value="<%= request.getAttribute("google_email")%>"/>
							</div>
							<div class="form-group">
								<label for="password"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="password" id="password"
									placeholder="Password" value="<%= request.getAttribute("google_password")%>"/>
							</div>
							<input type="hidden" id="status" value="<%= request.getAttribute("status")%>">
							<input type="hidden" id="status" name="picture" value="<%= request.getAttribute("picture")%>">
							<div class="form-group">
								<label for="postion"><i class="zmdi zmdi-lock-outline"></i></label>
								<select   name="postion" style="border:none;width:120px;height:25px; margin-left:20px;">
					        		<option value="adminDrh">admin DRH</option>
					        		<option value="chefDrh">chef drh</option>
					        		<option value="stagiaire">stagiaire</option>
					        	</select>
							</div>
							<div class="form-group">
								<a href="forgotPassword.jsp">Forgot Password?</a>
							</div>
							<div class="form-group form-button">
								<input type="submit" name="signin" id="signin"
									class="form-submit" value="Log in" />
							</div>
						</form>
						<div class="social-login">
							<span class="social-label">Or login with</span>
							<ul class="socials">
								<li><a href="#"><i
										class="display-flex-center zmdi zmdi-facebook"></i></a></li>
								<li><a href="#"><i
										class="display-flex-center zmdi zmdi-twitter"></i></a></li>
								<li><a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8081/Login_registration_j2ee/LoginGoogleHandler&response_type=code
		   &client_id=273113573870-45u4eu77is37qg753rj0slgrdng9g539.apps.googleusercontent.com&approval_prompt=force"><i
										class="display-flex-center zmdi zmdi-google"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</section>

	</div>

	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	
	<script type="text/javascript">
		var status = document.getElementById("status").value;
		if(status == "failed")
		{
			swal("Sorry","Your mail or password are incorrect","error");
		}
		if(status == "resetSuccess")
		{
			swal("gongrats","your password reseted successfully","success");
		}
		if(status == "resetFailed")
		{
			swal("Sorry","Your  password not reseted successfully","error");
		}
	</script>
	
</script>
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>