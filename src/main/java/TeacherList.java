import Hibernate.Generator.HibarnateSupporter;
import Hibernate.Queries.TeachingStaffQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

@WebServlet(urlPatterns = {"/teacherList"})
public class TeacherList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        TeachingStaffQuery query = new TeachingStaffQuery();
        List teachers = query.getWithNames(req.getSession().getAttribute("school_name").toString());
        req.setAttribute("teachers",teachers);
        req.getRequestDispatcher("/teacherlist.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
