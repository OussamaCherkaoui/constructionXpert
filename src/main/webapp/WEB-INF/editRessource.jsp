<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Edit Ressources</title>
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
    <h1 class="card-title text-center fw-bold" style="color: #FF6900">Edit Ressources</h1>
</div>
<div class="container text-white w-75 mb-5 p-4 rounded-2" style="background-color: #FF6900">
    <form action="editRessource" method="post" class="d-flex flex-column align-items-center">
        <input type="hidden" name="idTask" value="${idTask}">
        <input type="hidden" name="idRessource" value="${idRessource}">
        <div class="mb-4 w-75">
            <label class="form-label" for="name">Name Ressource</label>
            <input type="text" id="name" name="name" class="form-control w-100" value="${ressource.getNameRessource()}"/>
        </div>

        <div class=" mb-4 w-75">
            <label class="form-label" for="type">Type</label>
            <input type="text" id="type" name="type" class="form-control w-100" value="${ressource.getType()}"/>
        </div>

        <div class="form-outline mb-4 w-75">
            <label class="form-label" for="quantity">Quantity</label>
            <input type="number" id="quantity" name="quantity" class="form-control w-25" value="${ressource.getQuantity()}"/>
        </div>

        <div class=" mb-4 w-75">
            <label class="form-label" for="supplier">Supplier</label>
            <input type="text" id="supplier" name="supplier" class="form-control w-100" value="${ressource.getSupplier()}"/>
        </div>

        <div class="form-outline mb-4 w-75">
            <label class="form-label" for="picture">Picture Ressource <br>(Url)</label>
            <input type="text" id="picture" name="picture" class="form-control w-75" value="${ressource.getPictureRessource()}"/>
        </div>
        <div class="d-flex justify-content-end w-75">
            <button  type="submit" data-mdb-button-init
                     data-mdb-ripple-init class="btn btn-block btn-lg gradient-custom-4 text-body" style="background-color: #FFDFB9">update Ressource</button>
        </div>
        <c:if test="${ not empty result}">
            <div class="fw-bold fs-5 bg-white p-2 rounded-5" style="color: #4CAF50;text-align: center">${result}</div>
        </c:if>
    </form>
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

