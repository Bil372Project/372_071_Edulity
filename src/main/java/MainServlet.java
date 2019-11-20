import Hibernate.Generator.HibarnateSupporter;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Hashtable;

@WebServlet(urlPatterns = {"/mainServlet"})
public class MainServlet extends HttpServlet {


    @Override
    public void init() throws ServletException {
        super.init();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Hashtable errors = validate(request);
        if(errors.isEmpty()) { // validation succesfull
            request.getRequestDispatcher("/student.jsp").forward(request,response);
        }
        else {
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }

    private Hashtable validate(HttpServletRequest request) {
        Hashtable errors = new Hashtable();
        String schoolName = request.getParameter("school_names");
        String type = request.getParameter("type");
        String id = request.getParameter("id");
        if(schoolName == null || schoolName.equals("")) {
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
