<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Tasks</title>
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
    <h1 class="card-title text-center fw-bold" style="color: #FF6900">Tasks for Project</h1>
</div>
<div class="row gap-5 mb-5" style="display: flex;flex-direction: row;flex-wrap: wrap;align-items: center;justify-content: center">
    <c:forEach var="task" items="${tasks}">
    <div class="card m-2 d-flex align-items-center" style="width: 30%;background-color: #FF6900;">
        <div class="row g-0 ">
                <div class="card-body">
                    <div class="d-flex flex-row align-items-center gap-5 text-white">
                        <h5>Manager :</h5>
                         <img src="${task.getPictureResponsable()}" class="rounded-5 p-3" alt="..." height="150" width="150">
                    </div>
                    <p class="card-text text-white fw-semibold" style="width: 80%">
                         ${task.getDescriptionTache()}
                    </p>
                    <p class="card-text text-white fw-semibold">
                        Start Date : ${task.getStartDate()} <br>
                        Start End  : ${task.getEndDate()}
                    </p>
                    <p class="card-text text-white fw-semibold">
                    Statut : ${task.getStatut()}
                    </p>
                    <div class="button-crud d-flex flex-row gap-2">
                        <a class="btn btn-default rounded-2 text-black fw-semibold" href="./ressourcesTask?idTask=${task.getIdTask()}" role="button" id="btnGetStarted" style="background-color: #FFDFB9;width:155px; color: white">View Ressources</a>
                        <a class="btn btn-default rounded-2 d-flex flex-column align-items-center" href="./editTask?idTask=${task.getIdTask()}" role="button" id="modifier" style="background-color: #FFDFB9; color: white">
                            <img style="margin-left: 2px;" src="https://i.ibb.co/3WHBbv1/editing.png" height="25">
                        </a>
                        <a class="btn btn-default rounded-2" href="#" role="button" id="delete" style="background-color: #FFDFB9; color: white">
                            <img src="https://i.ibb.co/647jYn0/bin.png" height="25">
                        </a>
                    </div>
                </div>
        </div>
    </div>
    </c:forEach>
</div>
<div class="d-flex flex-row align-items-center justify-content-center mb-5">
    <a class="btn btn-default fs-5 rounded-3 text-black fw-semibold" href="./newTask?idProject=${idProject}" role="button" id="btnNewTask" style="background-color:#FFDFB9;width:180px; color: white">
        New Task
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
