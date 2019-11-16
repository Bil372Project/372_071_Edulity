<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="org.hibernate.cfg.Configuration" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="javax.persistence.Query" %>
<%@ page import="java.util.Hashtable" %>
<%@ page import="java.util.ArrayList" %>
<%
    StringBuilder schoolNames = new StringBuilder();
    if(request.getAttribute("sessionFactory") == null)
        request.setAttribute("sessionFactory",new Configuration().configure().buildSessionFactory());
    SessionFactory sessionFactory = (SessionFactory) request.getAttribute("sessionFactory");
    Session s = sessionFactory.openSession();
    Query query = s.createQuery("select name from SchoolEntity ");
    for (String se :
            (List<String>) query.getResultList()) {
        schoolNames.append("<option name=\"schoolName\" value=\""+ se + "\"" + ">" + se + "</option>");
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

    <script>
        var type;
        function changePlaceHolder(t) {
            type = t;
            document.getElementById('text-id').setAttribute("placeholder", t);
        }
        
        function validateLogin() {
            var option = document.getElementById('school_names');
            var schoolName = option.options[option.selectedIndex].value;
            var id = document.getElementById(text-id).valueOf();

        }
    </script>
    <style>
        body{
            font-family: 'Oxygen', sans-serif;
            background-color: #5a6268;
        }
        .img-logo{
            height: 3rem;
        }
        .navbar {
            opacity: 0.8;
            border-bottom: 1px solid #fff;
        }

        .form-container {
            background: transparent;
        }
        .form-control {
            -webkit-transition: height 0.6s;
            -moz-transition: height 0.6s;
            -ms-transition: height 0.6s;
            -o-transition: height 0.6s;
            transition: height 0.6s;
        }

        main {
            height: 80rem;
        }
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
                        <a href="#" class="nav-link active">
                            Home
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link active">
                            About
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link active">
                            Contact
                        </a>
                    </li>
                </ul>
            </div>

        </div>
    </nav>

    <main class="mt-5">
        <div class="container clearfix">
            <div class="align-content-center form-container">
                <form action="mainServlet" method="get">
                    <%=sbErros.toString()%>
                    <div class="form-group">
                        <label for="school_names">School Names</label>
                        <select name="school_names" id="school_names" class="form-control">
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
                    <div class="form-group">
                        <input type="submit" value="Login" class="form-control">
                    </div>
                </form>
            </div>
        </div>
    </main>

    <footer class="py-5 bg-dark text-white text-center">
        Copyright © Edulity 2019
    </footer>

</body>
</html>