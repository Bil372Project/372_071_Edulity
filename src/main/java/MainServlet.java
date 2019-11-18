import Queries.HibarnateSupporter;
import entities.SchoolEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

@WebServlet(urlPatterns = {"/mainServlet"})
public class MainServlet extends HttpServlet {


    @Override

    public void init() throws ServletException {
        super.init();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        Hashtable errors = validate(request);

        //if invoked the go to school page submit button
        if(request.getParameter("submit").equals("Go to school page")){
            session.setAttribute("school_name", request.getParameter("school_name"));
            request.getRequestDispatcher("/school.jsp").forward(request,response);
            return;
        }

        if(errors.isEmpty()) { // validation succesfull
            session.setAttribute("id", request.getParameter("id"));
            session.setAttribute("type", request.getParameter("type"));
            session.setAttribute("school_name", request.getParameter("school_name"));
            request.getRequestDispatcher("/student.jsp").forward(request,response);
        }
        else {
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }

    private Hashtable validate(HttpServletRequest request) {
        Hashtable errors = new Hashtable();
        String schoolName = request.getParameter("school_name");
        String type = request.getParameter("type");
        String id = request.getParameter("id");
        if(schoolName.equals("")) {
            errors.put("schoolName", "School field should not be empty");
        }
        if(type == null || type.equals("")) {
            errors.put("type", "Role field should not be empty");
        }
        if(id.equals("")) {
            errors.put("id", "ID field should not be empty");
        }

        Session session = HibarnateSupporter.getSessionFactory().openSession();
        String hql = "";
        Query query = null;
        if(type != null) {
            hql = (type.equals("student")) ? "select s.studentId from StudentEntity as s where s.studentId =:id " +
                    "and " +
                    "s.schoolName =: schoolName" :
                    "select e.id from EmployeeEntity as e where e.employeeId=:id and e.schoolName=:schoolName";
            query = session.createQuery(hql);
            query.setParameter("id", id);
            query.setParameter("schoolName", schoolName);
        }

        if(query == null || query.list().isEmpty()) {
            errors.put("id","Your id or school name is wrong. Please check them..");
        }

        return errors;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


}
