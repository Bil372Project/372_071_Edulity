<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="org.hibernate.cfg.Configuration" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="javax.persistence.Query" %>
<%@ page import="java.util.Hashtable" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Hibernate.Queries.SchoolQuery" %>
<%@ page import="Hibernate.Entities.SchoolEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    request.getSession().setAttribute("current_page", "index.jsp");
    StringBuilder schoolNames = new StringBuilder();
    SchoolQuery q = new SchoolQuery();
    List<SchoolEntity> schools = q.makeQuery(null,null,null);
    if(schools != null)
        for (SchoolEntity school :
                schools) {

            schoolNames.append("<option name=\"schoolName\" value=\""+ school.getName() + "\"" + ">" +
                    school.getName()+ "</option>");
        }

    Hashtable errors = (Hashtable) request.getAttribute("errors");
    StringBuilder sbErros = new StringBuilder();
    if(errors != null && !errors.isEmpty()) {
        for (String str :
                new ArrayList<String>(errors.values())) {
            sbErros.append(String.format("<div class=\"bg-danger rounded-lg p-2 mb-1\">" +
                    "<p>%s</p>" +
                    "</div>",str));
        }

    }
%>
<!doctype html>
<html lang="en">
<head class="">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Edulity</title>
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

    <script>
        if(performance.navigation.type == 2){
            location.reload(true);
        }
        var type;
        function changePlaceHolder(t) {
            type = t;
            document.getElementById('text-id').setAttribute("placeholder", t);
        }
    </script>
    <style>

    </style>
</head>
<body>
    <nav class="navbar bg-dark navbar-expand-sm navbar-dark sticky-top clearfix">
        <div class="container">
            <a href="./index.jsp" class="navbar-brand"><img class="img-logo" src="resources/img/logo.png" alt="Logo"></a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div id="navbarCollapse" class="collapse navbar-collapse">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a href="#" class="nav-link active hvr-underline-from-center">
                            Home
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link active hvr-underline-from-center">
                            About
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link active hvr-underline-from-center">
                            Contact
                        </a>
                    </li>
                </ul>
            </div>

        </div>
    </nav>

    <main class="mt-5">
        <div class="container">
            <div class="row">
                <div class="col-6">
                    <img src="resources/img/logo.png" alt="Logo" class="card-img pt-0">
                </div>
                <div class="col-6 pt-5">
                    <div class="clearfix">
                        <div class="align-content-center form-container">
                            <form action="mainServlet" method="get">
                                <%=sbErros.toString()%>
                                <div class="form-group">
                                    <label for="school_name">School Name</label>
                                    <select name="school_name" id="school_name" class="form-control">
                                        <%=schoolNames.toString()%>
                                    </select>
                                </div>
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
                                <div class="form-group">
                                    <input id="text-id" type="text" name="id" class="form-control" placeholder="Enter your ID">
                                </div>
                                <div class="row">
                                    <div class="form-group col-6">
                                        <input type="submit" name="submit" value="Login"
                                               class="form-control rounded-pill">
                                    </div>
                                    <div class="form-group col-6">
                                        <input type="submit" name="submit" value="Go to school page"
                                               class="form-control rounded-pill">
                                    </div>
                                </div>

                            </form>
                        </div>
                    </div>
                </div>

            </div>
        </div>


    </main>

    <footer class="py-5 bg-dark text-white text-center">
        Copyright © Edulity 2019
    </footer>

</body>
</html>