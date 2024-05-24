<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Ressources</title>
    <style>
        /* header and footer */
        #active{
            color: #FF6900;
            font-weight: bold;
        }
        .nav-item a:hover{
            color: #FF6900;
        }
        #btnNewProject:hover{
            background-color: #FF6900;
        }
        .list-unstyled li a {
            color: white;
            text-decoration: none;
        }
        /* ********************************** */
    </style>
</head>
<body>
<%@ include file="navbar.jsp"%>
<div class="card-body m-3 p-5">
    <h1 class="card-title text-center fw-bold" style="color: #FF6900">Ressources for Task</h1>
</div>

<div class="row gap-5 mb-5 m-0">
    <c:forEach var="ressource" items="${ressources}">
    <div class="card mx-auto d-flex flex-row align-items-between" style="width: 80%;background-color: #FF6900;">
        <div class=" mx-auto d-flex flex-row align-items-center" >
            <div class="d-flex flex-column align-items-center justify-content-center gap-3" style="">
                <div class="card-body d-flex flex-row gap-5">
                    <div>
                        <p class="card-text text-white fw-semibold">
                            name: ${ressource.getNameRessource()}
                        </p>
                        <p class="card-text text-white fw-semibold">
                            quantity : ${ressource.getQuantity()}
                        </p>
                    </div>
                    <div>
                        <p class="card-text text-white fw-semibold">
                            type: ${ressource.getType()}
                        </p>
                        <p class="card-text text-white fw-semibold">
                            supplier : ${ressource.getSupplier()}
                        </p>
                    </div>
                </div>
                <div class="p-3 d-flex flex-row justify-content-end gap-2" style="width: 100%">
                    <a class="btn btn-default rounded-2 d-flex flex-column align-items-center" href="./editRessource?idRessource=${ressource.getIdRessource()}" role="button" id="modifier" style="background-color: #FFDFB9; color: white">
                        <img style="margin-left: 2px;" src="https://i.ibb.co/3WHBbv1/editing.png" height="25">
                    </a>
                    <a class="btn btn-default rounded-2" href="#" role="button" id="delete" style="background-color: #FFDFB9; color: white">
                        <img src="https://i.ibb.co/647jYn0/bin.png" height="25">
                    </a>
                </div>
            </div>
        </div>
        <div class="mx-auto">
            <img src="${ressource.getPictureRessource()}" class="rounded-5 p-3" alt="picture ressource" height="250" width="400">
        </div>
    </div>
    </c:forEach>
</div>
<div class="d-flex flex-row align-items-center justify-content-center mb-5">
    <a class="btn btn-default fs-5 rounded-3 text-black fw-semibold" href="./newRessource" role="button" id="btnNewTask" style="background-color:#FFDFB9;width:220px; color: white">
        New Ressources
        <img style="margin-left: 8px" src="https://i.ibb.co/qMCr2VQ/more.png" height="25">
    </a>
</div>
<%@ include file="footer.jsp"%>
<script>
    let home = document.getElementById('home');
    let project=document.getElementById('project');
    home.id="";
    project.id="active";
</script>
</body>
</html>
