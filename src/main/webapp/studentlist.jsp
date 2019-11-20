<%@ page import="java.util.Hashtable" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Hibernate.Entities.StudentEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="Hibernate.Queries.StudentQuery" %>
<%@ page import="java.util.Comparator" %><%--
  Created by IntelliJ IDEA.
  User: Muhammed Emre Durdu
  Date: 20.11.2019
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
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
    List<StudentEntity> students =
            new StudentQuery().makeQuery(session.getAttribute("school_name").toString(),null,null,
                    null,null,null,null,
                    Long.valueOf(request.getParameter("section")),null,null);
    students.sort(new Comparator<StudentEntity>() {
        @Override
        public int compare(StudentEntity o1, StudentEntity o2) {
            return o1.getName().compareTo(o2.getName());
        }
    });
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
                        <a href="classlist.jsp" class="nav-link active hvr-underline-from-center">
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
            <table class="table table-dark">
                <thead>
                <tr><th>#</th><th>Name</th><th>ID</th></tr>
                </thead>
                <tbody>
                <%
                    int i = 1;
                    for (StudentEntity student :
                            students) {
                        %>
                    <tr><td><%=i%></td><td><%=student.getName()%></td><td><%=student.getStudentId()%></td></tr>
                    <%i++;%>
                <%}%>
                </tbody>

            </table>
        </div>
    </main>
    <footer class="py-5 bg-dark text-white text-center">
        Copyright © Edulity 2019
    </footer>
</body>
</html>
