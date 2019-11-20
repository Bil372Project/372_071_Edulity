import Hibernate.Queries.StudentQuery;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/studentList"})
public class StudentList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        StudentQuery query = new StudentQuery();
        List students = query.makeQuery((String)req.getSession().getAttribute("school_name"), null,
                null, null, null, null, null,
                Long.valueOf(req.getParameter("section")), null, null);
        req.setAttribute("students", students);
        req.setAttribute("section",req.getParameter("section"));
        req.getRequestDispatcher("/studentlist.jsp").forward(req,resp);
    }
}
