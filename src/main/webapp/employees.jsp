<%@ page import="Hibernate.Queries.EmployeeQuery" %>
<%@ page import="Hibernate.Entities.EmployeeEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.Hashtable" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Hibernate.Queries.TeachingStaffQuery" %>
<%@ page import="Hibernate.Entities.EmployeeEntityPK" %><%--
  Created by IntelliJ IDEA.
  User: Muhammed Emre Durdu
  Date: 25.11.2019
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Hashtable errors = (Hashtable) request.getAttribute("errors");
    Hashtable messages = (Hashtable) request.getAttribute("messages");
    StringBuilder sbErros = new StringBuilder();
    StringBuilder sbMessages = new StringBuilder();

    List<Object[]> employees = new TeachingStaffQuery().getAllInfo((String) session.getAttribute("school_name"));

    if(errors != null && !errors.isEmpty()) {
        for (String str :
                new ArrayList<String>(errors.values())) {
            sbErros.append(String.format("<div class=\"bg-danger rounded-lg p-2 mb-1\">" +
                    "<p>%s</p>" +
                    "</div>",str));
        }

    }
    if(messages != null && !messages.isEmpty()) {
        for (String str :
                new ArrayList<String>(messages.values())) {
            sbMessages.append(String.format("<div class=\"bg-success rounded-lg p-2 mb-1\">" +
                    "<p>%s</p>" +
                    "</div>",str));
        }

    }
%>
<html>
<head>
    <title>Manage Employees</title>
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
                    <a href="manageabsenteeism.jsp"
                       class="dropdown-item nav-link active hvr-underline-from-center bg-dark">Manage
                        absenteeism</a>
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
        <form action="manageEmployees" method="post">
            <%=sbErros.toString()%>
            <%=sbMessages.toString()%>
            <label for="add-employee" class="text-white">Add Teaching staff</label>
            <div class="form-group clearfix" id="add-employee">
                <div class="clearfix">
                    <label for="types" class="text-light float-left mr-2">Role</label>
                    <div class="form-group text-white float-left" id="types">
                        <label class="ckb">
                            <input id="c1" type="checkbox" name="type" value="teacher">
                            <i></i> Teacher
                        </label>
                        <label class="ckb">
                            <input id="c2" type="checkbox" name="type" value="hod">
                            <i></i> Head of Department
                        </label>
                    </div>
                </div>
            </div>
            <input class="float-left col-1 form-control" type="text" placeholder="ID" name="id">
            <input class="float-left col-3 form-control" type="text" placeholder="Name" name="name">
            <input class="float-left col-2 form-control" type="text" placeholder="Specialization"
                   name="specialization">
            <input class="float-left col-2 form-control" type="text" placeholder="SSN"
                   name="ssn">
            <input class="float-left col-2 form-control" type="text" placeholder="Office no" name="office_no">
            <button type="submit" class="btn btn-success col-2" name="submit" value="add">
                <i class="fas fa-plus"></i> Add
            </button>
        </form>
        <br><br>
        <hr>
        <br><br>
        <form action="manageEmployees" method="post">
            <div class="clearfix">
                <button type="submit" class="btn btn-success col-2 bg-info" name="submit" value="update">
                    <i class="fas fa-file-import "></i> Update
                </button>
                <button type="submit" class="btn btn-success col-2 bg-danger" name="submit" value="delete">
                    <i class="fas fa-user-minus "></i> Delete selecteds
                </button>
            </div>
            <table class="table table-dark table-hover">
                <thead>
                    <th>#</th><th>ID</th><th>Name</th><th>Specialization</th><th>SSN</th><th>Office No</th>
                </thead>
                <tbody>
                <%
                    for (Object[] emp :
                            employees) {
                    String id = ((EmployeeEntityPK)emp[0]).getEmployeeId();
                    String name = (String) emp[2];
                    String specialization = (String) emp[4];
                    String ssn = (String) emp[3];
                    String office_no = (String) emp[5];
                %>
                <input type="hidden" name="<%=id + "-id"%>" value="<%=id%>">
                <input type="hidden" name="<%=id + "-name-orig"%>" value="<%=name%>">
                <input type="hidden" name="<%=id + "-specialization-orig"%>" value="<%=specialization%>">
                <input type="hidden" name="<%=id + "-ssn-orig"%>" value="<%=ssn%>">
                <input type="hidden" name="<%=id + "-office_no-orig"%>" value="<%=office_no%>">
                      <tr>
                          <td><label class="ckb">
                              <input type="checkbox" name="ids" value="<%=id%>">
                              <i></i>
                          </label></td>
                          <td><%=id%></td>
                          <td>
                              <input class="form-control" type="text" name="<%=id + "-name"%>" placeholder="<%=name%>">
                          </td>
                          <td><input class="form-control" type="text" name="<%=id + "-specialization"%>"
                                     placeholder="<%=specialization%>"></td>
                          <td><input class="form-control" type="text" name="<%=id + "-ssn"%>" placeholder="<%=ssn%>"></td>
                          <td><input class="form-control" type="text" name="<%=id + "-office_no"%>" placeholder="<%=office_no%>"></td>
                      </tr>
                    <%}%>
                </tbody>
            </table>

        </form>
    </div>
</main>
<footer class="py-5 bg-dark text-white text-center">
    Copyright © Edulity 2019
</footer>
</body>
</html>
