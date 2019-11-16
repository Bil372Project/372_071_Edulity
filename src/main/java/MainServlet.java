import entities.SchoolEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.List;

@WebServlet(urlPatterns = {"/mainServlet"})
public class MainServlet extends HttpServlet {

    List<SchoolEntity> schoolEntities = null;

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
        if(schoolName.equals("")) {
            errors.put("schoolName", "School field should not be empty");
        }
        if(type.equals("")) {
            errors.put("type", "Role field should not be empty");
        }
        if(id.equals("")) {
            errors.put("id", "ID field should not be empty");
        }

        Session session = HibarnateSupporter.getSessionFactory().openSession();
        String hql = "select s.studentId from StudentEntity as s where s.studentId =:id and " +
                "s.schoolName =: schoolName";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        query.setParameter("schoolName", schoolName);

        if(query.list().isEmpty()) {
            errors.put("id","Your id or school name is wrong. Please check them..");
        }

        return errors;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


}
