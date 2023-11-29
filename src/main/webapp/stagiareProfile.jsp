<%
if(session.getAttribute("name")==null)
{
	response.sendRedirect("login.jsp");
}
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/stagiare.css" rel="stylesheet">
<link rel="icon" type="image/x-icon" href="images/short-icon.ico">
</head>
<body>
	
	
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<div class="container emp-profile">
            <form method="post">
                <div class="row">
                    <div class="col-md-4">
                        <div class="profile-img">
                            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS52y5aInsxSm31CvHOFHWujqUx_wWTS9iM6s7BAm21oEN_RiGoog" alt=""/>
                            <div class="file btn btn-lg btn-primary">
                                Change Photo
                                <input type="file" name="file"/>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="profile-head">
                                    <h5>
                                        Kshiti Ghelani
                                    </h5>
                                    <h6>
                                        Web Developer and Designer
                                    </h6>
                                    <p class="proile-rating">RANKINGS : <span>8/10</span></p>
                            <ul class="nav nav-tabs" id="myTab" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">About</a>
                                </li>
                                
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-2">
                     <a class="profile-logout-btn" href="logout">Logout</a>
                    </div>
                   
                   
                  
                </div>
                <div class="row">
                    <div class="col-md-4">
                    <input type="submit" class="profile-edit-btn" name="btnAddMore" value="Edit Profile"/>
                    <a type="submit" class="profile-edit-btn" name="GenerateAtterstation">Generer l'attestation de stage</a>
                        <div class="profile-work">
                            <p>WORK LINK</p>
                            <a href="">Website Link</a><br/>
                            <a href="">Bootsnipp Profile</a><br/>
                            <a href="">Bootply Profile</a>
                            <p>SKILLS</p>
                            <a href="">Web Designer</a><br/>
                            <a href="">Web Developer</a><br/>
                            <a href="">WordPress</a><br/>
                            <a href="">WooCommerce</a><br/>
                            <a href="">PHP, .Net</a><br/>
                        </div>
                    </div>
		   
		 
                    <div class="col-md-8">
                        <div class="tab-content profile-tab" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label >User Id</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p name="userId">Kshiti123</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label >Name</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p name="name">Kshiti Ghelani</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Email</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>kshitighelani@gmail.com</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Phone</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>123 456 7890</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Profession</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>Web Developer and Designer</p>
                                            </div>
                                        </div>
                            </div>
                            
                                <div class="row">
                                    <div class="col-md-12">
                                        <label>Your Bio</label><br/>
                                        <p>Your detail description</p>
                                    </div>
                                    <form method="post" action="generatePdf">
									    <!-- Add other form fields as needed -->
									    <input type="hidden" name="name" value="<%= request.getParameter("name") %>">
									    <input type="hidden" name="userId" value="<%= request.getParameter("userId") %>">
									    <input type="hidden" name="email" value="<%= request.getParameter("email") %>">
									    <input type="hidden" name="phone" value="<%= request.getParameter("phone") %>">
									    <input type="hidden" name="profession" value="<%= request.getParameter("profession") %>">
									    <!-- Add other form fields as needed -->
									
									    <!-- Add a button to trigger PDF generation -->
									    <input type="submit" value="Generate Attestation" class="profile-edit-btn" name="GenerateAttestation">
									</form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>           
        </div>
        
</body>
</html>