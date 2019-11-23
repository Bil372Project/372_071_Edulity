<%@ page import="Hibernate.Entities.ListOfAbsentDatesEntity" %>
<%@ page import="Hibernate.Queries.ListOfAbsentDatesQuery" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Hibernate.Entities.ListOfHwQuestionsEntity" %><%--
  Created by IntelliJ IDEA.
  User: Muhammed Emre Durdu
  Date: 21.11.2019
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ListOfAbsentDatesQuery query = new ListOfAbsentDatesQuery();
    List<ListOfAbsentDatesEntity> tmp =  query.makeQuery(session.getAttribute("school_name").toString(),
            session.getAttribute("id").toString(), null);
    List<String> absentDates = new ArrayList<>();
    for (ListOfAbsentDatesEntity date :
            tmp) {
        absentDates.add("\"" + date.getAbsentDate() + "\"");
    }
    request.setAttribute("absentDates", absentDates);
%>
<html>

<head>
    <title>Absenteism</title>
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
    <link rel="stylesheet" href="calendar.css">
<%--    <script src="calendar.js"></script>--%>
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
    <main class="mt-4">
        <div class="container">
            <span class="badge badge-danger p-2"><%="Total number of absent days: " + absentDates.size()%></span>
            <div id="cal" class="mx-auto">
                <header>
                    <h1 id="caltitle"></h1>
                    <h1 id="time"></h1>
                    <h2>
                        <a id="prev" href=""></a>
                        <a id="next" href=""></a>
                    </h2>
                </header>

                <table>
                    <tr>
                        <td>
                            <div class="day mo"></div>
                            <div class="day">Su</div>
                            <div class="day">Mo</div>
                            <div class="day">Tu</div>
                            <div class="day">We</div>
                            <div class="day">Th</div>
                            <div class="day">Fr</div>
                            <div class="day">Sa</div>
                            <div class="day">Su</div>
                            <div class="day">Mo</div>
                            <div class="day">Tu</div>
                            <div class="day">We</div>
                            <div class="day">Th</div>
                            <div class="day">Fr</div>
                            <div class="day">Sa</div>
                            <div class="day">Su</div>
                            <div class="day">Mo</div>
                            <div class="day">Tu</div>
                            <div class="day">We</div>
                            <div class="day">Th</div>
                            <div class="day">Fr</div>
                            <div class="day">Sa</div>
                            <div class="day">Su</div>
                            <div class="day">Mo</div>
                            <div class="day">Tu</div>
                            <div class="day">We</div>
                            <div class="day">Th</div>
                            <div class="day">Fr</div>
                            <div class="day">Sa</div>
                            <div class="day">Su</div>
                            <div class="day">Mo</div>
                            <div class="day">Tu</div>
                            <div class="day">We</div>
                            <div class="day">Th</div>
                            <div class="day">Fr</div>
                            <div class="day">Sa</div>
                            <div class="day">Su</div>
                            <div class="day">Mo</div>
                        </td>
                        <td>
                            <table id="months">
                                <tr id="mtoprow">
                                    <td class="mc" valign="top"><span id="p0"></span></td>
                                    <td class="mc" valign="top"><span id="p1"></span></td>
                                    <td class="mc" valign="top"><span id="p2"></span></td>
                                    <td class="mc" valign="top"><span id="p3"></span></td>
                                    <td class="mc" valign="top"><span id="p4"></span></td>
                                    <td class="mc" valign="top"><span id="p5"></span></td>
                                    <td class="mc" valign="top"><span id="p6"></span></td>
                                    <td class="mc" valign="top"><span id="p7"></span></td>
                                    <td class="mc" valign="top"><span id="p8"></span></td>
                                    <td class="mc" valign="top"><span id="p9"></span></td>
                                    <td class="mc" valign="top"><span id="p10"></span></td>
                                    <td class="mc" valign="top"><span id="p11"></span></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </div>

            <div id="tmp">
                  <span id="m0" style="display:none">
                    <div class="months">
                      <div class="mo">Month</div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                      <div class="dt"></div>
                    </div>
                  </span>
            </div>
        </div>
    </main>
    <footer class="py-5 bg-dark text-white text-center">
        Copyright © Edulity 2019
    </footer>

</body>
<script>
    var today = new Date();
    var year = today.getUTCFullYear();
    var month = today.getUTCMonth();
    var day = today.getUTCDate();
    var hour = today.getHours();
    var minute = today.getMinutes();
    var second = today.getSeconds();
    var timeish = hour + '.' + (minute * 60);

    var timeDiff = {
        setStartTime : function () {
            d = new Date();
            time  = d.getTime();
        },

        getDiff : function () {
            d = new Date();
            return (d.getTime()-time);
        }
    }

    var mtbl  = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
    var mnames = new Array("Jan", "Feb", "Mar", "Apr", "May", "Jun",
        "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");

    // End-of-month Julian Day lookup tables for normal and leap years
    var jdtbln = new Array(0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334);
    var jdtbll = new Array(0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335);

    var leap = false;
    var jdtbl = jdtbln;
    var yearpattern = /^\d{4,5}$/;
    var displayStyle = "std";
    var abtlinkhidden = true;

    function isLeap(year) {
        return (year % 100 != 0) && (year % 4 == 0) || (year % 400 == 0);
    }
    function julianDay(day, month) {
        return day + jdtbl[month-1];
    }

    // returns the day of week as an integer: 1=Sun, 2=Mon, ..., 7=Sat
    function dayOfWeek(day, month, year) {
        leap = isLeap(year);
        jdtbl = leap? jdtbll : jdtbln;
        var dow = (year + julianDay(day, month)
            + Math.floor((year-1)/4) - Math.floor((year-1)/100)
            + Math.floor((year-1)/400)) % 7;
        return dow == 0? 7: dow;
    }

    var absentDates = <%=request.getAttribute("absentDates")%>;

    function isDateAbsent(year, month, day) {
        for (let i = 0; i < absentDates.length; i++) {
            var date = absentDates[i].split("-");
            if(year == date[0] && month == date[1] && day == date[2])
                return true;
        }
        return false;
    }

    function renderMonth(parent, month, year) {
        var dateCells = $(parent + " div.dt");
        var cellid = dayOfWeek(1, month, year) - 1;
        var max = mtbl[month-1];
        if (max == 28 && leap) max = 29;
        for (var ix = 1; ix <= max; ix++) {
            if(isDateAbsent(year, month, ix)) {
                var className = dateCells.eq(cellid).className;
                dateCells.eq(cellid).addClass('ab')
            }

            dateCells.eq(cellid++).html(ix);

        }
        $(parent + " div.mo").html(mnames[month-1]);
    }

    function getMonthSequence(mainMonth) {

        var tmp = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        if (mainMonth == 0) return tmp;

        var monthseq = new Array();
        monthseq.push(mainMonth);
        if (mainMonth == 11) {
            // n+1 isn't possible
            monthseq.push(9);
            monthseq.push(10);
            tmp.splice(9, 3);
        } else {
            monthseq.push(mainMonth-1);
            monthseq.push(mainMonth+1);
            tmp.splice(mainMonth-1, 3);
        }
        return monthseq.concat(tmp);
    }

    function getIdPrefix(ix) {
        return "#p";
    }

    function showSelective() {
        $("div#cal").show();
        $("p.prinvis").show();
        $("#mtoprow").show();
    }

    function renderCalendar(startMonth, stopMonth, year) {
        year = parseInt(year);

        timeDiff.setStartTime();
        var d = new Date();
        var seqargs = 0;
        var monthHtml = $("span#m0").html();
        var monthseq = getMonthSequence(seqargs);

        $("#caltitle").text(year);
        $("title").text(year);
        $('#prev').attr('href', '#' + (year-1)).text(year-1);
        $('#next').attr('href', '#' + (year+1)).text(year+1);

        for (var ix = startMonth-1; ix < stopMonth; ix++) {
            var newId = getIdPrefix(ix) + ix;
            if ($(newId).length == 1) {
                $(newId).html(monthHtml);
                renderMonth(newId, monthseq[ix]+1, year);
            }
        }

        showSelective();

    }

    // Clock

    function convertToHHMM(info) {
        var hrs = parseInt(Number(info));
        var min = Math.round((Number(info)-hrs) * 60);
        return hrs+':'+min;
    }



    function startTime() {
        var today = new Date();
        var hour = today.getHours();
        var minute = today.getMinutes();
        var second = today.getSeconds();

        if (hour > 12) {
            hour -= 12;
        } else if (hour === 0) {
            hour = 12;
        }

        minute = checkTime(minute);
        second = checkTime(second);
        $('#time').text(hour + ":" + minute + ":" + second);
        t = setTimeout(function(){startTime()},500);
    }

    function checkTime(i) {
        if (i < 10) {
            i = "0" + i;
        }
        return i;
    }

    $(window).on('hashchange', function() {
        if (window.location.hash) {
            var hash = window.location.hash.replace('#', '');
        }

        if(/^\d{4}$/.test(hash)) {
            renderCalendar(1, 12, hash);
        } else {
            renderCalendar(1, 12, year);
        }
    });


    // Lets get this shit started
    $(document).ready(function () {

        if (window.location.hash) {
            var hash = window.location.hash.replace('#', '');
        }

        if(/^\d{4}$/.test(hash)) {
            renderCalendar(1, 12, hash);
        } else {
            renderCalendar(1, 12, new Date().getFullYear());
        }

        startTime();

    });
</script>
</html>
