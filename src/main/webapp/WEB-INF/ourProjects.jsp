<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Our Projects</title>
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
    <h1 class="card-title text-center fw-bold" style="color: #FF6900">Our Projects</h1>
</div>

<div class="row gap-5 mb-5 m-0">
    <c:forEach var="project" items="${projects}">
    <div class="card mx-auto" style="width: 70%;background-color: #FF6900;">
        <div class="row g-0">
            <div class="col-md-8 d-flex align-items-center" style="padding-left: 60px">
                <div class="card-body">
                    <h2 class="text-white">
                        ${project.getNameProject()}
                    </h2>
                    <p class="card-text text-white fw-semibold" style="width: 50%">
                        ${project.getDescriptionProject()}
                    </p>
                    <p class="card-text text-white fw-semibold">
                        Start Date : ${project.getStartDate()} <br>
                        Start End  : ${project.getEndDate()}
                    </p>
                    <p class="card-text text-white fw-semibold">
                        budget : ${project.getBudget()} dh
                    </p>
                </div>
            </div>
            <div class="col-md-4 mx-auto" >
                <img src="${project.getPictureProject()}" class="rounded-5 p-3" alt="..." height="250" width="300">
                <div class="button-crud p-3 d-flex flex-row gap-2">
                    <a class="btn btn-default rounded-2 text-black fw-semibold" href="./tasksProject?idProject=${project.getIdProject()}" role="button" id="btnGetStarted1" style="background-color: #FFDFB9;width:142px; color: white">View Tasks</a>
                    <a class="btn btn-default rounded-2 d-flex flex-column align-items-center" href="./editProject?idProject=${project.getIdProject()}" role="button" id="modifier" style="background-color: #FFDFB9; color: white">
                        <img style="margin-left: 2px;" src="https://i.ibb.co/3WHBbv1/editing.png" height="25">
                    </a>
                    <form action="deleteProject" method="post">
                        <input type="hidden" name="idProject" value="${project.getIdProject()}">
                        <button class="btn btn-default rounded-2" role="button" id="delete" style="background-color: #FFDFB9; color: white">
                            <img  src="https://i.ibb.co/647jYn0/bin.png" height="25">
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    </c:forEach>
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
