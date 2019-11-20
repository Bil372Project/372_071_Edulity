<%@ page import="java.util.Hashtable" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Muhammed Emre Durdu
  Date: 17.11.2019
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.getSession().setAttribute("current_page", "school.jsp");
    Hashtable errors = (Hashtable) request.getAttribute("errors");
    String sbErros = "";
    if(errors != null && !errors.isEmpty()) {
        for (String str :
                new ArrayList<String>(errors.values())) {
            sbErros += str + "\n";
        }
        if (!sbErros.equals("")){
            sbErros ="<div class=\"alert alert-danger alert-dismissible  \n" +
                    "            fade show\" role=\"alert\"> \n" +
                    "              \n" +
                    "            <strong>"+sbErros +"</strong>" +
                "               <button type=\"button\" class=\"btn close\" \n" +
                    "                data-dismiss=\"alert\" aria-label=\"Close\"> \n" +
                    "                  \n" +
                    "                <span aria-hidden=\"true\">×</span> \n" +
                "               </button> " +
                    "</div>";

        }
    }
%>
<html>
<head>
    <title><%="Edulity - " + ((String)session.getAttribute("school_name")).toUpperCase()%></title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/bootstrap.bundle.js"></script>
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
                        <a href="#" class="nav-link active hvr-underline-from-center">
                            <i class="fas fa-home"></i>
                        </a>
                    </li>
                </ul>
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item border-right">
                        <a href="#" class="nav-link active hvr-underline-from-center">
                            Teachers
                        </a>
                    </li>
                    <li class="nav-item border-right">
                        <a href="#" class="nav-link active hvr-underline-from-center">
                            Classes
                        </a>
                    </li>
                    <li class="nav-item border-right">
                        <a href="#" class="nav-link active hvr-underline-from-center">
                            Bus List
                        </a>
                    </li>
                    <li class="nav-item border-right">
                        <a href="#" class="nav-link active hvr-underline-from-center">
                            Food List
                        </a>
                    </li>
                    <li class="nav-item">
                        <button  id="back-to-top" type="button" class="btn btn-dark"
                           data-toggle="collapse"
                           data-target="#login">
                            Login
                        </button>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <main>
        <div class="container mt-4 clearfix">
            <%=sbErros%>
            <div id="login" class="collapse float-right">
                <div class="form-container clearfix">
                    <form action="mainServlet" method="get">
                        <div class="form-group" id="types">
                            <label class="rad">
                                <input id="r1" type="radio" name="type" value="student"
                                       onclick="changePlaceHolder('Student ID')">
                                <i></i> Student
                            </label>
                            <label class="rad">
                                <input id="r2" type="radio" name="type" value="teacher" class="form-control"
                                       onclick="changePlaceHolder('Teacher ID')">
                                <i></i> Teacher
                            </label>
                        </div>
                        <div class="form-group d-inline-block pl-0">
                            <input id="text-id" type="text" name="id" class="form-control" placeholder="Enter your ID">
                        </div>
                        <div class="form-group d-inline-block pl-0" >
                            <input type="submit" name="submit" class="form-control" value="Login">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="container img-container">
            <div id="slider2" class="carousel slide carousel-fade my-5 " data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#slider2" data-slide-to="0" class="active"></li>
                    <li data-target="#slider2" data-slide-to="1"></li>
                    <li data-target="#slider2" data-slide-to="2"></li>
                    <li data-target="#slider2" data-slide-to="3"></li>
                </ol>
                <div class="carousel-inner rounded-lg shadow-lg" >
                    <div class="carousel-item active">
                        <img class="d-block w-100" src="resources/img/food.jpg" alt="">
                        <div class="carousel-caption">
                            <h5>Food List</h5>
                            <p>See the daily food list now!!</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="resources/img/classroom.jpg" alt="">
                        <div class="carousel-caption">
                            <h5>Classes</h5>
                            <p>Get information about classes</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="resources/img/school_bus.jpg" alt="">
                        <div class="carousel-caption">
                            <h5>School Busses</h5>
                            <p>Get every information about school busses!!</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="resources/img/teacher.jpg" alt="">
                        <div class="carousel-caption">
                            <h5>Teachers</h5>
                            <p>Want to contact one of our teachers..</p>
                        </div>
                    </div>
                </div>
                <a href="#slider2" class="carousel-control-prev" data-slide="prev">
                    <span class="carousel-control-prev-icon"></span>
                </a>
                <a href="#slider2" class="carousel-control-next" data-slide="next">
                    <span class="carousel-control-next-icon"></span>
                </a>
            </div>
        </div>
    </main>
    <footer class="py-5 bg-dark text-white text-center">
        Copyright © Edulity 2019
    </footer>

</body>
</html>
<script>
    var type;
    function changePlaceHolder(t) {
        type = t;
        document.getElementById('text-id').setAttribute("placeholder", t);
    }

    $(document).ready(function(){
        // $(window).scroll(function () {
        //     if ($(this).scrollTop() > 50) {
        //         $('#back-to-top').fadeIn();
        //     } else {
        //         $('#back-to-top').fadeOut();
        //     }
        // });
        // scroll body to 0px on click

    });
</script>
