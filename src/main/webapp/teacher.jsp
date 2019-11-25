<%--
  Created by IntelliJ IDEA.
  User: Muhammed Emre Durdu
  Date: 25.11.2019
  Time: 09:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teacher</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/bootstrap.bundle.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <link href="https://fonts.googleapis.com/css?family=Oxygen&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/bootstrap-grid.css">
    <link rel="stylesheet" href="css/bootstrap-reboot.css">
    <link rel="stylesheet" href="homepage.css">
    <link rel="stylesheet" href="common.css">
    <link rel="stylesheet" href="hover.css">
    <style>
        .navbar-collapse {
            height: 100%;
        }
        .container {
            position: relative;
        }
        a>i{
            font-size: 1.5rem;
        }

        /*#login {*/
        /*    position: fixed;*/
        /*    right: 0;*/
        /*    z-index: 10;*/
        /*}*/

    </style>
</head>
<body>
    <nav class="navbar bg-dark navbar-expand-sm navbar-dark sticky-top clearfix">
        <div class="container">
            <a href="./index.jsp" class="navbar-brand"><img class="img-logo" src="resources/img/logo.png"
                                                            alt="Logo"></a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div id="navbarCollapse" class="collapse navbar-collapse">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a href="teacher.jsp" class="nav-link active hvr-underline-from-center">
                            <i class="fas fa-home"></i>
                        </a>
                    </li>
                </ul>
                <ul class="navbar-nav dropdown">
                    <a href="#" class="dropdown-toggle nav-link active hvr-underline-from-center" data-toggle="dropdown">Admin</a>
                    <li class="dropdown-menu bg-white">
                        <%if (session.getAttribute("hod") != null) {%>
                        <a href="employees.jsp"
                           class="dropdown-item nav-link active hvr-underline-from-center bg-dark">Manage employees
                        </a>
                        <a href="classes.jsp"
                           class="dropdown-item nav-link active hvr-underline-from-center bg-dark">Manage classes
                        </a>
                        <a href="" class="dropdown-item nav-link active hvr-underline-from-center bg-dark">Manage schedule</a>
                        <%}%>
                        <a href="" class="dropdown-item nav-link active hvr-underline-from-center bg-dark">Manage absenteeism</a>
                        <a href="" class="dropdown-item nav-link active hvr-underline-from-center bg-dark">Manage assignments</a>

                    </li>
                </ul>
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item border-right">
                        <a href="teacherlist.jsp" class="nav-link active hvr-underline-from-center">
                            Teachers
                        </a>
                    </li>
                    <li class="nav-item border-right">
                        <a href="classlist.jsp" class="nav-link active hvr-underline-from-center">
                            Classes
                        </a>
                    </li>
                    <li class="nav-item border-right">
                        <a href="buslist.jsp" class="nav-link active hvr-underline-from-center">
                            Bus List
                        </a>
                    </li>
                    <li class="nav-item border-right">
                        <a href="#" class="nav-link active hvr-underline-from-center">
                            Food List
                        </a>
                    </li>
                    <li class="nav-item">
                        <form action="logout" method="post" class="m-0">
                            <input type="submit" value="Logout" class="btn btn-dark">
                        </form>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <main class="m-4">
        <div class="container">
            <span class="badge-info rounded p-2">Teacher id: <%=session.getAttribute("id")%></span>
        </div>
    </main>
    <footer class="py-5 bg-dark text-white text-center">
        Copyright © Edulity 2019
    </footer>

</body>
</html>