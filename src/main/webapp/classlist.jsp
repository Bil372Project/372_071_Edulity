<%@ page import="java.util.Hashtable" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Hibernate.Entities.ClazzEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="Hibernate.Queries.ClazzQuery" %><%--
  Created by IntelliJ IDEA.
  User: Muhammed Emre Durdu
  Date: 20.11.2019
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ClazzQuery query = new ClazzQuery();
    List<ClazzEntity> classes = query.makeQuery((String)session.getAttribute("school_name"),null,
            null,null);
    Hashtable errors = (Hashtable) request.getAttribute("errors");
    String sbErros = "";
    if(errors != null && !errors.isEmpty()) {
        for (String str :
                new ArrayList<String>(errors.values())) {
            sbErros += str + "\n";
        }
        //print errors
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

    StringBuilder sbClasses = new StringBuilder();

    /*
        <div class="card my-3 w-50">
		<img src="img/avatar.png" class="card-img-top" alt="">
		<div class="card-img-overlay">
			<h4 class="card-title">ClassSection</h4>
			<p class="card-text">Size: classSize</p>
			<a href="" class="card-link">See Profile</a>
		</div>
	</div>
    */

    if(classes != null && !classes.isEmpty()) {
        for (ClazzEntity clazz :
                classes) {
            sbClasses.append("<div class=\"card my-3 w-50 d-inline-block pr-4\">"+
                    "<img src=\"resources/img/classroom2.jpg\" class=\"card-img-top\" alt=\"\">" +
                    "<div class=\"card-body\">" +
                    "<h4 class=\"card-title\">Class : " + (clazz.getSection()/2  + 1) +
                    " Section: "+(clazz.getSection()%2 + 1)+
                    "</h4>" +
                    "<p class=\"card-text\">Size: " + clazz.getClassSize() +"</p>" +
                    "<a href=\"\" class=\"card-link\">See details</a>"+
            "</div>" +
            "</div>");
        }

    }
%>
<html>
<head>
    <title><%="Edulity - " + ((String)session.getAttribute("school_name")).toUpperCase() + "- Classes"%></title>
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
                        <a href="school.jsp" class="nav-link active hvr-underline-from-center">
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
        <div class="container">
            <%=sbClasses.toString()%>
        </div>
    </main>

</body>
</html>
