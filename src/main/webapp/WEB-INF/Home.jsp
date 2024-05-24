<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Home</title>
    <style>
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
<div class="card text-white">
    <img src="https://i.ibb.co/xXnGVTF/mobile-engineers.jpg" alt="introduction picture" height="420">
    <div class="card-img-overlay mt-5" style="margin-left:65px ">
        <h5 class="card-title text-black">Mission</h5>
        <h1 class="card-title fw-bold" style="color: #FF6900">Creating</h1>
        <p class="card-text" style="color: #FFDFB9">construction projects are taking<br>
            place in your local communities<br>
            and around the world .</p>
        <p class="card-text mt-4">
            <a class="btn btn-default rounded-5" href="#" role="button" id="btnGetStarted" style="background-color: #FF6900; color: white">Get Started
            <img style="margin-left: 8px;" src="https://i.ibb.co/641V7bq/play-1.png" height="30">
            </a>
        </p>
    </div>
</div>

<div class="card-body m-3 p-5">
    <h1 class="card-title" style="color: #FF6900" id="welcome">Welcome </h1>
    <p class="card-text fw-bold">to the project management application for
        construction by ConstructionXpert Services</p>
</div>

<div class="about mb-5 my-auto d-flex flex-column gap-5">
    <div class="card mx-auto" style="width: 80%;background-color: #FF6900;">
        <div class="row g-0">
            <div class="col-md-4 mx-auto" style="padding-left: 40px;background-color: rgba(0,0,0,0.26)" >
                <img src="https://i.ibb.co/b31B9Hx/pexels-mikael-blomkvist-8960987.jpg" class="rounded-5 p-3" alt="..." height="350">
            </div>
            <div class="col-md-8 d-flex align-items-center">
                <div class="card-body d-flex justify-content-center">
                    <p class="card-text text-white ">
                        Our user-friendly tool enables your team<br>
                        to efficiently plan, organize, and manage<br>
                        all your construction projects.
                    </p>
                </div>
            </div>
        </div>
    </div>

    <div class="card mx-auto" style="width: 80%;background-color: #FF6900;">
        <div class="row g-0">
            <div class="col-md-8 d-flex align-items-center">
                <div class="card-body d-flex justify-content-center">
                    <p class="card-text text-white ">
                        With an intuitive interface, you can view,<br>
                        update, and delete projects, tasks, and<br>
                        resources while ensuring data security<br>
                        and system integrity.
                    </p>
                </div>
            </div>
            <div class="col-md-4 mx-auto" style="padding-left: 40px;background-color: rgba(0,0,0,0.26)" >
                <img src="https://i.ibb.co/LCsFB7n/pexels-pixabay-38544.jpg" class="rounded-5 p-3" alt="..." height="350" width="260">
            </div>
        </div>
    </div>

    <div class="card mx-auto" style="width: 80%;background-color: #FF6900;">
        <div class="row g-0">
            <div class="col-md-4 mx-auto" style="padding-left: 40px;background-color: rgba(0,0,0,0.26)" >
                <img src="https://i.ibb.co/sR5dj1Q/pexels-giuseppe-testa-815775886-19265034.jpg" class="rounded-5 p-3" alt="..." height="350">
            </div>
            <div class="col-md-8 d-flex align-items-center">
                <div class="card-body d-flex justify-content-center">
                    <p class="card-text text-white">
                        Optimize your processes and ensure the success<br>
                        of your projects with ConstructionXpert Services.
                    </p>
                </div>
            </div>
        </div>
    </div>

</div>

<%@ include file="footer.jsp"%>
<script>
    let home = document.getElementById('home');
    let project=document.getElementById('project');
    project.id="";
    home.id="active";

    document.getElementById('btnGetStarted').addEventListener('click', function(event) {
        event.preventDefault(); // Empêche le comportement par défaut du lien
        document.getElementById('welcome').scrollIntoView({
            behavior: 'smooth' // Défilement fluide
        });
    });
</script>
</body>
</html>
