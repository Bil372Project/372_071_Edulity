<%@ page import="Hibernate.Entities.SchoolBusEntity" %>
<%@ page import="Hibernate.Queries.SchoolBusQuery" %>
<%@ page import="java.util.*" %>
<%@ page import="Hibernate.Queries.DriverQuery" %>
<%@ page import="Hibernate.Entities.DriverEntity" %><%--
  Created by IntelliJ IDEA.
  User: Muhammed Emre Durdu
  Date: 20.11.2019
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.getSession().setAttribute("current_page", "buslist.jsp");
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

    List<SchoolBusEntity> busEntities = new SchoolBusQuery().makeQuery(null,null,null,
            null,null,session.getAttribute("school_name").toString());
    busEntities.sort(new Comparator<SchoolBusEntity>() {
        @Override
        public int compare(SchoolBusEntity o1, SchoolBusEntity o2) {
            return o1.getLicensePlate().compareTo(o2.getLicensePlate());
        }
    });
    Hashtable<Long, List> stopsTable = new Hashtable<>();
    for (SchoolBusEntity bus :
            busEntities) {
        stopsTable.put(bus.getId(), new SchoolBusQuery().getStops(session.getAttribute("school_name").toString(),
                bus.getId()));
    }

%>
<html>
<head>
    <title><%="Edulity - " + ((String)session.getAttribute("school_name")).toUpperCase() + "- Bus List"%></title>
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
                        <a href="school.jsp" class="nav-link active hvr-underline-from-center">
                            <i class="fas fa-home"></i>
                        </a>
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
            <div id="accordion">
                <%
                    for (SchoolBusEntity bus :
                            busEntities) {
                %>
                <div class="card mb-1 bg-dark text-white">
                    <div class="card-header">
                        <a href="#<%="busid" + bus.getId()%>" class="card-link" data-toggle="collapse">
                            <i class="fas fa-bus-alt"> Show stops</i>
                        </a>

                        <span class="card-subtitle"><%=" Destination:" + bus.getDestination()%></span>
                        <button type="button" class="btn btn-link" data-toggle="modal"
                                data-target="<%="#busdriver" + bus.getDriverId()%>">
                            About Driver
                        </button>
                        <div class="modal fade text-dark" tabindex="-1" role="dialog" aria-hidden="true"
                             id="<%="busdriver" + bus.getDriverId()%>">

                            <div class="modal-dialog modal-sm modal-dialog-centered">

                                <div class="modal-content">

                                    <div class="modal-header">
                                        <h4 class="modal-title"><%=bus.getDriverId()%></h4>
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    </div>
                                    <div class="modal-body">
                                        <p>Phone number: <%=((DriverEntity)new DriverQuery().makeQuery(bus.getDriverId(),null,
                                                null).get(0)).getPhoneNumber()%></p>
                                    </div>
                                    <div class="modal-footer">
                                        <button class="btn btn-danger" type="button" data-dismiss="modal">Close</button>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div id="<%="busid" + bus.getId()%>" class="collapse" data-parent="#accordion">
                        <div class="card-body">
                            <%
                                for (Object stop :
                                        stopsTable.get(bus.getId())) {%>
                            <span class="badge badge-dark"><%=stop%></span>
                            <%}%>
                        </div>
                    </div>
                </div>
                <%}%>

            </div>
        </div>

    </main>
    <footer class="py-5 bg-dark text-white text-center">
        Copyright © Edulity 2019
    </footer>
</body>
</html>
