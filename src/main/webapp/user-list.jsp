<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<!-- Boxicons -->
	<link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
	<!-- My CSS -->
	
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
		<title>User Management Application</title>
	<script type="text/javascript">
	const data = {
			  labels: [
			    'Red',
			    'Blue',
			    'Yellow'
			  ],
			  datasets: [{
			    label: 'My First Dataset',
			    data: [300, 50, 100],
			    backgroundColor: [
			      'rgb(255, 99, 132)',
			      'rgb(54, 162, 235)',
			      'rgb(255, 205, 86)'
			    ],
			    hoverOffset: 4
			  }]
			};
	</script>
	<link rel="stylesheet" type="text/css" href="css/dash.css">
</head>
<body>


	<!-- SIDEBAR -->
	<section id="sidebar">
		<a href="#" class="brand">
			<i class='bx bxs-smile'></i>
			<span class="text">admin dashboard</span>
		</a>
		<ul class="side-menu top">
			<li class="active">
				<a href="#">
					<i class='bx bxs-dashboard' ></i>
					<span class="text">Dashboard</span>
				</a>
			</li>
			<li>
				<a href="#stagiaires-table">
					<i class='bx bxs-shopping-bag-alt' ></i>
					<span class="text">Stagiaires</span>
				</a>
			</li>
			<li>
				<a href="#">
					<i class='bx bxs-doughnut-chart' ></i>
					<span class="text">statistiques</span>
				</a>
			</li>
			<li>
				<a href="new">
					<i class='bx bxs-message-dots' ></i>
					<span class="text">Add New User</span>
				</a>
			</li>
			<li>
				<a href="list">
					<i class='bx bxs-group' ></i>
					<span class="text">List All Users</span>
				</a>
			</li>
		</ul>
		<ul class="side-menu">
			<li>
				<a href="#">
					<i class='bx bxs-cog' ></i>
					<span class="text">Settings</span>
				</a>
			</li>
			<li>
				<a href="logout" class="logout">
					<i class='bx bxs-log-out-circle' ></i>
					<span class="text">Logout</span>
				</a>
			</li>
		</ul>
	</section>
	<!-- SIDEBAR -->



	<!-- CONTENT -->
	<section id="content">
		<!-- NAVBAR -->
		<nav>
			<i class='bx bx-menu' ></i>
			<a href="#" class="nav-link">Categories</a>
			<form action="search" id="search" method="post">
				<div class="form-input">
					<input type="search" placeholder="Search..." name="searchInput">
					<button type="submit" class="search-btn"><i class='bx bx-search' ></i></button>
				</div>
			</form>
			<input type="checkbox" id="switch-mode" hidden>
			<label for="switch-mode" class="switch-mode"></label>
			<a href="#" class="notification">
				<i class='bx bxs-bell' ></i>
				<span class="num">8</span>
			</a>
			<a href="#" class="profile">
				<img src="<%= request.getAttribute("picture")%>">
			</a>
		</nav>
		<!-- NAVBAR -->

		<!-- MAIN -->
		<main>
			<div class="head-title">
				<div class="left">
					<h1>Dashboard</h1>
					<ul class="breadcrumb">
						<li>
							<a href="#">Dashboard</a>
						</li>
						<li><i class='bx bx-chevron-right' ></i></li>
						<li>
							<a class="active" href="#">Home</a>
						</li>
					</ul>
				</div>
				<a href="generate-pdf" class="btn-download">
					<i class='bx bxs-cloud-download' ></i>
					<span class="text">Download PDF</span>
				</a>
			</div>

			<ul class="box-info">
				<li>
					<i class='bx bxs-calendar-check' ></i>
					<span class="text">
						<h3><%= request.getAttribute("count") %></h3>
						<p>stagiares</p>
					</span>
				</li>
				<li>
					<i class='bx bxs-group' ></i>
					<span class="text">
						<h3>1</h3>
						<p>stages</p>
					</span>
				</li>
				<li>
					<i class='bx bxs-dollar-circle' ></i>
					<span class="text">
						<h3>6</h3>
						<p>encadrant</p>
					</span>
				</li>
			</ul>


			<div class="table-data" id="stagiaires-table">
    <div class="order">
        <div class="head">
            <h3>Liste des Stagiaires</h3>
            <i class='bx bx-search'></i>
            <a href="#search" style="text-decoration:none; color:gray;">
                <i class='bx bx-filter'></i>
            </a>
            <a href="new" style="text-decoration:none; color:gray;">
                <i class='bx bxs-message-square-add'></i>
            </a>
        </div>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Prenom</th>
                    <th>CIN</th>
                    <th>Etablissment</th>
                    <th>Filiere</th>
                    <th>Adresse</th>
                    <th>Numero Tele</th>
                    <th>Stage</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listStagiaire}" var="stagiaire">
                    <tr>
                        <td><c:out value="${stagiaire.id}" /></td>
                        <td><span class="status completed"><c:out value="${stagiaire.nom}" /></span></td>
                        <td><c:out value="${stagiaire.prenom}" /></td>
                        <td><c:out value="${stagiaire.CIN}" /></td>
                        <td><c:out value="${stagiaire.etablissment}" /></td>
                        <td><c:out value="${stagiaire.filiere}" /></td>
                        <td><c:out value="${stagiaire.adresse}" /></td>
                        <td><c:out value="${stagiaire.numero_tele}" /></td>
                        <td><c:out value="${stagiaire.stage}" /></td>
                        <td>
                            <a href="edit?id=<c:out value='${stagiaire.id}' />"><i class="fa-regular fa-pen-to-square"></i></a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="delete?id=<c:out value='${stagiaire.id}' />"><i class="fa-solid fa-trash"></i></a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="view?id=<c:out value='${stagiaire.id}' />"><i class="fa-solid fa-eye"></i></a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

				
				<!--<div class="todo">
					<div class="head">
						<h3>Todos</h3>
						<i class='bx bx-plus' ></i>
						<i class='bx bx-filter' ></i>
					</div>
					<ul class="todo-list">
						<li class="completed">
							<p>Todo List</p>
							<i class='bx bx-dots-vertical-rounded' ></i>
						</li>
						<li class="completed">
							<p>Todo List</p>
							<i class='bx bx-dots-vertical-rounded' ></i>
						</li>
						<li class="not-completed">
							<p>Todo List</p>
							<i class='bx bx-dots-vertical-rounded' ></i>
						</li>
						<li class="completed">
							<p>Todo List</p>
							<i class='bx bx-dots-vertical-rounded' ></i>
						</li>
						<li class="not-completed">
							<p>Todo List</p>
							<i class='bx bx-dots-vertical-rounded' ></i>
						</li>
					</ul>
				</div>
			</div>-->
		</main>
		<!-- MAIN -->
	</section>
	<!-- CONTENT -->
	

	<script src="script.js"></script>
</body>
</html>