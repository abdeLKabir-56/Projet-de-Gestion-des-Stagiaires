<%
if(session.getAttribute("name")==null)
{
	response.sendRedirect("login.jsp");
}
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Students data</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>

<body>
    <div class="container">
        <div class="row my-4">
            <div class="table-responsive mt-4">
                <div class="table-wrapper">
                    <div class="table-title top-50">
                        
                        <div class="col-sm-3">
                            <i class="fa fa-user ml-3 btn btn-info"></i>
                        </div>
                        <div class="row">
                            <div class="col-sm-12 d-flex flex-row d-flex flex-row justify-content-between">
                                <h2>Etudiant Details</h2>
                                <div class="col-sm-3">
                                    <a class=" btn btn-info add-new mr-0" href="<?php echo URL_BASE; ?>add"><i class="fa fa-plus"></i> Add New</a>
                                </div>
                                <div class="col-sm-3">
                                    <form method="post" class="d-flex flex-row">
                                        <input type="text" name="search" class="form-control" id="search" placeholder="Search">
                                        <button class=" btn btn-info add-sm" name="find" type="submit"><i class="fas fa-search"></i></button>
                                    </form>
                                </div>
                                <div class="col-sm-2">
                                    <form method="post" class="d-flex flex-row" enctype="multipart/form-data">
                                        <input type="file" name="add_by_exel" class="form-control" id="add_by_exel">
                                        <button class=" btn btn-info add-sm" name="import" type="submit"><i class="fa-solid fa-file-import"></i></button>
                                    </form>
                                </div>
                                <div class="col-sm-1">
                                    <a class=" btn btn-info add-new mr-0 mr-2"  href="logout">logout </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <table class="table table-bordered border-1">
                        <thead>
                            <tr>
                                <th>CNE</th>
                                <th>nom et prenom </th>
                                <th>email</th>
                                <th>numero de telephone</th>
                                <th>statue</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                          
                                    <td class="d-flex flex-row justify-content-around">
                                        <form method="post" action="update">
                                            <input type="hidden" name="id" value="">
                                            <button type="submit" class="btn btn-sm btn-warning"><i class="fa fa-edit"></i></button>
                                        </form>
                                        <form method="post" action="delete">
                                            <input type="hidden" name="id" value="">
                                            <button type="submit" class="btn btn-sm btn-danger"><i class="fa fa-trash"></i></button>
                                        </form>
                                        <form method="post" action="profile">
                                            <input type="hidden" name="id" value="">
                                            <button type="submit" class="btn btn-sm btn-info"><i class="fa-solid fa-user" style="color: #fff;"></i></button>
                                        </form>
                                    </td>
                                </tr>
                            
                        </tbody>
                    </table>
                    <div class="col-sm-1 d-flex flex-row justify-content-center align-items-center">
                        <a class=" btn btn-info" href="#">export data </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>
