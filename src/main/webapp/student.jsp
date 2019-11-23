<%@ page import="Hibernate.Entities.ScheduleConsistsOfEntity" %>
<%@ page import="Hibernate.Queries.StudentQuery" %>
<%@ page import="Hibernate.Entities.StudentEntity" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Muhammed Emre Durdu
  Date: 16.11.2019
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.getSession().setAttribute("current_page", "student.jsp");
    StudentQuery query = new StudentQuery();
    List schedule = query.getSchedule((StudentEntity)request.getSession().getAttribute("student"));
    String[][] str = new String[10][5];
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
            str[i][column] = courseName;
        }
    }
%>
<html>
<head>
    <title>Student Page</title>
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
                        <a href="student.jsp" class="nav-link active hvr-underline-from-center">
                            <i class="fas fa-home"></i>
                        </a>
                    </li>
                </ul>
                <ul class="navbar-nav">
                    <li class="nav-item border-right">
                        <a href="homeworks.jsp" class="nav-link active hvr-underline-from-center">
                            Homeworks
                        </a>
                    </li>
                    <li class="nav-item border-right">
                        <a href="grades.jsp" class="nav-link active hvr-underline-from-center">
                            Grades
                        </a>
                    </li>
                    <li class="nav-item border-right">
                        <a href="absenteeism.jsp" class="nav-link active hvr-underline-from-center">
                            Absenteeism
                        </a>
                    </li>
                    <li class="nav-item border-right">
                        <a href="announcments.jsp" class="nav-link active hvr-underline-from-center">
                            Announcements
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
                        <form action="logout" method="post" class="m-0">
                            <input type="submit" value="Logout" class="btn btn-dark">
                        </form>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <main class="mt-4">
        <div class="container">
            <div class="align-content-center">
                <span class="mx-auto badge-info badge ">
                    <%="Section: " + ((StudentEntity)session.getAttribute("student")).getClassSection()%>
                </span>
                <span class="mx-auto badge-info badge">
                    <%="Name: " + ((StudentEntity)session.getAttribute("student")).getName()%>
                </span>
            </div>
            <table class="table table-dark table-hover">
                <thead><th>Time</th><th>Monday</th><th>Tuesdat</th><th>Wednesday</th>
                    <th>Thursday</th><th>Friday</th>
                </thead>
                <tbody>
                    <%for (int i = 0; i < 10; i++) {%>
                    <tr>
                        <%for (int j = 0; j < 6; j++) {%>
                        <td><%if(j == 0){%>
                            <%=i + 8 + ".30"%>
                            <%}else if(str[i][j-1] != null){%>
                            <%=str[i][j-1]%>
                            <%}%>
                        </td>
                        <%}%>
                    </tr>
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
