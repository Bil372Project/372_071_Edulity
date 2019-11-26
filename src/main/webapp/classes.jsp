<%@ page import="Hibernate.Entities.ClazzEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="Hibernate.Queries.ClazzQuery" %>
<%@ page import="Hibernate.Queries.StudentQuery" %>
<%@ page import="Hibernate.Entities.StudentEntity" %>
<%@ page import="java.util.Comparator" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Hashtable" %><%--
  Created by IntelliJ IDEA.
  User: Muhammed Emre Durdu
  Date: 26.11.2019
  Time: 00:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Hashtable errors = (Hashtable) request.getAttribute("errors");
    Hashtable messages = (Hashtable) request.getAttribute("messages");
    StringBuilder sbErros = new StringBuilder();
    StringBuilder sbMessages = new StringBuilder();
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

    List<StudentEntity> students = new ArrayList<>();
    List<ClazzEntity> classes =
            new ClazzQuery().makeQuery(session.getAttribute("school_name").toString(),null,null,null);
    String[][] table = new String[10][5];
    String section = request.getParameter("section");
    section = (section == null || section.equals("")) ? (String) request.getAttribute("section") : section;
    if (section != null && !section.equals("")) {
        StudentQuery query = new StudentQuery();
        List schedule = query.getSchedule(Long.valueOf(section), (String) session.getAttribute("school_name"));

        for (Object[] course :
                (List<Object[]>)schedule) {
            String courseName = ((String)course[0]).replaceAll("[0-9]","");
            String day = ((String)course[1]).split("=")[0];
            String startTime = ((String)course[1]).split("=")[1];
            String endTime = ((String)course[2]).split("=")[1];
            int row = Integer.valueOf(startTime.split("\\.|:")[0]) - 8; //start time is 8.30
            int row2 = Integer.valueOf(endTime.split("\\.|:")[0]) - 8;
            int  column;
            switch (day.toLowerCase()) {
                case "monday":column = 0;break;
                case "tuesday":column=1;break;
                case "wednesday":column=2;break;
                case "thursday":column=3;break;
                case "friday":column=4;break;
                default:
                    throw new IllegalStateException("Unexpected value: " + day.toLowerCase());
            }
            for(int i = row; i < row2; i++) {
                table[i][column] = courseName;
            }
        }
        students =
                new StudentQuery().makeQuery(session.getAttribute("school_name").toString(),null,null,
                        null,null,null,null,
                        Long.valueOf(section),null,null);
        students.sort(new Comparator<StudentEntity>() {
            @Override
            public int compare(StudentEntity o1, StudentEntity o2) {
                return o1.getStudentId().compareTo(o2.getStudentId());
            }
        });
    }
%>
<html>
<head>
    <title>Manage Classes</title>
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
                        <a href="manageabsenteeism.jsp" class="dropdown-item nav-link active hvr-underline-from-center bg-dark">Manage
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
    <main class="my-4">
        <div class="container">
            <form action="classes.jsp">
                <label for="section" class="badge-info p-2 rounded text-white">Select section</label>
                <div class="form-group clearfix" id="section">
                   
                    <select name="section"  class="form-control d-inline-block float-left col-2">
                        <%
                            for (ClazzEntity c :
                                    classes) {%>
                        <option value="<%=c.getSection()%>"><%=c.getSection()%></option>
                        <%}%>
                    </select>
                    <input  type="submit" value="OK"
                            class="ml-1 form-control d-inline-block float-left col-2 bg-success text-white">
                </div>
            </form>
            <%if (section != null && !section.equals("")) {%>
            <hr class="">
            <%=sbErros.toString()%>
            <%=sbMessages.toString()%>
            <span class="badge badge-info p-2 rounded my-1">Section: <%=section%></span>
            <form action="manageClasses" method="post">
                <label for="add-student" class="text-white">Add Student</label>
                <div class="form-group" id="add-student">
                    <input type="hidden" name="section" value="<%=section%>">
                    <input class="float-left col-1 form-control" type="text" placeholder="ID" name="id">
                    <input class="float-left col-4 form-control" type="text" placeholder="Name" name="name">
                    <input class="float-left col-3 form-control" type="text" placeholder="Parent SSN"
                           name="parent_ssn">
                    <input class="float-left col-2 form-control" type="text" placeholder="Bus ID"
                           name="bus_id">
                    <button type="submit" class="btn btn-success col-2" name="submit" value="add">
                        <i class="fas fa-plus"></i> Add
                    </button>
                </div>

            </form>
            <hr>
            <form action="manageClasses" method="post">
                <input type="hidden" name="section" value="<%=section%>">
                <div class="clearfix mb-2">
                    <button type="submit" class="btn btn-success col-2 bg-info" name="submit" value="update">
                        <i class="fas fa-file-import "></i> Update
                    </button>
                    <button type="submit" class="btn btn-success col-2 bg-danger" name="submit" value="delete">
                        <i class="fas fa-user-minus "></i> Delete selecteds
                    </button>
                </div>
                <table class="table table-dark table-hover">
                    <thead>
                    <th>#</th><th>ID</th><th>Name</th><th>Parent SSN</th><th>Bus ID</th>
                    </thead>
                    <tbody>
                    <%
                        for (StudentEntity std:
                                students) {
                            String id = std.getStudentId();
                            String name = std.getName();
                            String parentssn = std.getParentSsn();
                            Long bus_id = std.getSchoolBusId();

                    %>
                    <input type="hidden" name="<%=id + "-section"%>" value="<%=section%>">
                    <input type="hidden" name="<%=id + "-id"%>" value="<%=id%>">
                    <input type="hidden" name="<%=id + "-name-orig"%>" value="<%=name%>">
                    <input type="hidden" name="<%=id + "-parentssn-orig"%>" value="<%=parentssn%>">
                    <input type="hidden" name="<%=id + "-bus_id-orig"%>" value="<%=bus_id%>">
                    <tr>
                        <td><label class="ckb">
                            <input type="checkbox" name="ids" value="<%=id%>">
                            <i></i>
                        </label></td>
                        <td><%=id%></td>
                        <td>
                            <input class="form-control" type="text" name="<%=id + "-name"%>" placeholder="<%=name%>">
                        </td>
                        <td><input class="form-control" type="text" name="<%=id + "-parentssn"%>"
                                   placeholder="<%=parentssn%>"></td>
                        <td><input class="form-control" type="text" name="<%=id + "-bus_id"%>" placeholder="<%=bus_id%>"></td>
                    </tr>
                    <%}%>
                    </tbody>
                </table>
            </form>
            <%}%>
        </div>



    </main>
    <footer class="py-5 bg-dark text-white text-center">
        Copyright © Edulity 2019
    </footer>
</body>
</html>
