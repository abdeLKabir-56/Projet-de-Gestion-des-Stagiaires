<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
<div style="border: 1 solid black; margin-left: 20%; margin-top: 80px; width: 60%;">
    <center>
        <h1>User Management</h1>
        <h2>
         <a href="new" style="text-decoration:none; color:white;" class="btn btn-primary">Add New stagiaire </a>
         &nbsp;&nbsp;&nbsp;
         <a href="list" style="text-decoration:none; color:white;" class="btn btn-primary">liste des stagiaire </a>
         
        </h2>
 </center>
    <div align="center">
  <c:if test="${user != null}">
   <form action="update" method="post">
        </c:if>
        <c:if test="${user == null}">
   <form action="insert" method="post">
        </c:if>
        
             <h2>
              <c:if test="${user != null}">
               Edit stagiaire 
              </c:if>
              <c:if test="${user == null}">
               Add New stagiaire 
              </c:if>
             </h2>
            
          <c:if test="${user != null}">
           <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
          </c:if>            

        <div class="form-group row mb-2">
            <label for="nom" class="col-sm-2 col-form-label">Stagiaire Nom: </label>
            <div class="col-sm-10">
                <input type="text" name="nom" size="45" class="form-control" value="<c:out value='${user.nom}' />" />
            </div>
        </div>

        <div class="form-group row mb-2">
            <label for="prenom" class="col-sm-2 col-form-label">Stagiaire Prenom: </label>
            <div class="col-sm-10">
                <input type="text" name="prenom" size="45" class="form-control" value="<c:out value='${user.prenom}' />" />
            </div>
        </div>

        <div class="form-group row mb-2">
            <label for="CIN" class="col-sm-2 col-form-label">Stagiaire CIN: </label>
            <div class="col-sm-10">
                <input type="text" name="CIN" size="45" class="form-control" value="<c:out value='${user.CIN}' />" />
            </div>
        </div>

        <div class="form-group row mb-2">
            <label for="etablissment" class="col-sm-2 col-form-label">Stagiaire Etablissment: </label>
            <div class="col-sm-10">
                <input type="text" name="etablissment" size="45" class="form-control" value="<c:out value='${user.etablissment}' />" />
            </div>
        </div>

        <div class="form-group row mb-2">
            <label for="filiere" class="col-sm-2 col-form-label">Stagiaire Filiere: </label>
            <div class="col-sm-10">
                <input type="text" name="filiere" size="45" class="form-control" value="<c:out value='${user.filiere}' />" />
            </div>
        </div>

        <div class="form-group row mb-2">
            <label for="adresse" class="col-sm-2 col-form-label">Stagiaire Adresse: </label>
            <div class="col-sm-10">
                <input type="text" name="adresse" size="45" class="form-control" value="<c:out value='${user.adresse}' />" />
            </div>
        </div>

        <div class="form-group row mb-2">
            <label for="numero_tele" class="col-sm-2 col-form-label">Stagiaire Numero Tele: </label>
            <div class="col-sm-10">
                <input type="text" name="numero_tele" size="45" class="form-control" value="<c:out value='${user.numero_tele}' />" />
            </div>
        </div>

        <div class="form-group row mb-2">
            <label for="stage" class="col-sm-2 col-form-label">Stagiaire Stage: </label>
            <div class="col-sm-10">
                <input type="text" name="stage" size="45" class="form-control" value="<c:out value='${user.stage}' />" />
            </div>
        </div>

        <input type="submit" value="Save" class="btn btn-primary mt-2 mb-2" />

    </form>
    </div>
</div>
</body>
</html>
