<%@ page import="Hibernate.Queries.HomeworkQuery" %>
<%@ page import="Hibernate.Entities.StudentEntity" %>
<%@ page import="Hibernate.Entities.HomeworkEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.Date" %>
<%@ page import="Hibernate.Entities.ListOfHwQuestionsEntity" %>
<%@ page import="Hibernate.Queries.ListOfHwQuestionsQuery" %><%--
  Created by IntelliJ IDEA.
  User: Muhammed Emre Durdu
  Date: 21.11.2019
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    StudentEntity studentEntity = (StudentEntity) session.getAttribute("student");
    HomeworkQuery query = new HomeworkQuery();
    List<HomeworkEntity> homeworks = query.makeQuery(null,null,null,
        studentEntity.getSchoolName(),studentEntity.getClassSection());
    List<ListOfHwQuestionsEntity> questions = null;
    if(request.getParameter("hwNumber") != null)
        questions =new ListOfHwQuestionsQuery().makeQuery(null,
                Long.valueOf(request.getParameter("hwNumber")));

%>
<html>
<head>
    <title>Homeworks</title>
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
                        <a href="absenteism.jsp" class="nav-link active hvr-underline-from-center">
                            Absenteism
                        </a>
                    </li>
                    <li class="nav-item border-right">
                        <a href="announcements.jsp" class="nav-link active hvr-underline-from-center">
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
    <main>
        <div class="container my-4">
            <%if(homeworks.isEmpty()) {%>
                <img class="img-fluid align-content-center mx-auto" src="resources/img/celebration.png" alt="">
                <h3 class="h3">NO HOMEWORK !!</h3>
            <%} else {%>
            <table class="table table-dark table-hover">
                <thead>
                    <tr>
                        <th>Homework Number</th><th>Due Date</th><th>Assigning teacher</th><th></th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (HomeworkEntity hw :
                                homeworks) {
                            %>
                            <tr>
                                <td><%=hw.getHwNumber()%></td>
                                <td><%=((Date)hw.getDueDate())%></td>
                                <td><%=hw.getTeacherEmployeeId()%></td>
                                <td>
                                    <form action="homeworks.jsp">
                                        <input type="hidden" name="hwNumber" value="<%=hw.getHwNumber()%>">
                                        <input class="btn-link my-0 btn" type="submit" value="See questions">
                                    </form>
                                </td>
                            </tr>
                        <%}%>
                </tbody>
            </table>
            <%}; int i=1;%>
            <%if(questions != null && !questions.isEmpty())
                for (ListOfHwQuestionsEntity question :
                        questions) {
                    %>
                <table class="table table-dark table-hover">
                    <thead>
                        <tr><th>#</th><th>question</th></tr>
                    </thead>
                    <tbody>
                        <tr><td><%=i%></td><td><%=question.getQuestion()%></td></tr>
                    </tbody>
                </table>
            <%i++;}%>
        </div>
    </main>
    <footer class="py-5 bg-dark text-white text-center">
        Copyright © Edulity 2019
    </footer>
</body>
</html>
