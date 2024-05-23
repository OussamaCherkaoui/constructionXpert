<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>New Task</title>
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
    <h1 class="card-title text-center fw-bold" style="color: #FF6900">New Task</h1>
</div>
<div class="container text-white w-75 mb-5 p-4" style="background-color: #FF6900">
    <form class="d-flex flex-column align-items-center">
        <div class=" mb-4 w-75">
            <label class="form-label" for="description">Description</label>
            <textarea id="description" name="description" class="form-control w-100"></textarea>
        </div>

        <div class="form-outline mb-4 w-75">
            <label class="form-label" for="startDate">Start date</label>
            <input type="date" id="startDate" name="startDate" class="form-control w-25"/>
        </div>

        <div class="form-outline mb-4 w-75">
            <label class="form-label" for="endDate">End date</label>
            <input type="date" id="endDate" name="endDate" class="form-control w-25" />
        </div>

        <div class="form-outline mb-4 w-75">
            <label class="form-label" for="statut">Statut</label>
            <select class="form-select w-50" name="statut" id="statut">
                <option selected>Select statut</option>
                <option value="Afaire">à faire</option>
                <option value="encours">en cours</option>
                <option value="terminer">terminé</option>
            </select>
        </div>
        <div class="form-outline mb-4 w-75">
            <label class="form-label" for="picture">Picture Responsable <br>(Url)</label>
            <input type="text" id="picture" name="picture" class="form-control w-75" />
        </div>
        <div class="d-flex justify-content-end w-75">
            <button  type="button" data-mdb-button-init
                     data-mdb-ripple-init class="btn btn-block btn-lg gradient-custom-4 text-body" style="background-color: #FFDFB9">Add Task</button>
        </div>
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