import Hibernate.Entities.StudentEntity;
import Hibernate.Generator.HibernateSupporter;
import Hibernate.Queries.HeadOfDepartmentQuery;
import Hibernate.Queries.StudentQuery;
import Hibernate.Queries.TeacherQuery;
import org.hibernate.Session;

import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
            if(request.getParameter("school_name") != null)
                session.setAttribute("school_name", request.getParameter("school_name"));
            request.getRequestDispatcher("/student.jsp").forward(request,response);
        }
        else {
            request.setAttribute("errors", errors);
            request.getRequestDispatcher((String)request.getSession().getAttribute("current_page")).forward(request,
                    response);
        }
    }

    private Hashtable validate(HttpServletRequest request) {
        Hashtable errors = new Hashtable();
        String schoolName = request.getParameter("school_name");
        if(schoolName == null) schoolName = (String)request.getSession().getAttribute("school_name");
        String type = request.getParameter("type");
        String id = request.getParameter("id");
        String parentId = request.getParameter("parent_id");
        if(schoolName.equals("")) {
            errors.put("schoolName", "School field should not be empty");
        }
        if(type == null || type.equals("")) {
            errors.put("type", "Role field should not be empty");
        }
        if(id.equals("")) {
            errors.put("id", "ID field should not be empty");
        }

        Session session = HibernateSupporter.getSessionFactory().openSession();
        String hql = "";
        List students = null;
        List teachers = null;
        if(type != null) {
            if(type.equals("student")){
                StudentQuery query = new StudentQuery();
                students = query.makeQuery(schoolName,id,null,null,null,
                        null,null,null,null,null);
                if(students == null || students.isEmpty()) {
                    errors.put("id","Your id or school name is wrong. Please check them..");
                }
                else {
                    if(parentId != null && !parentId.equals("")){
                        if (((StudentEntity)students.get(0)).getParentSsn().equals(parentId)) {
                            request.getSession().setAttribute("parent_id",parentId);
                        }
                        else
                            errors.put("parent","Student id and parent ssn does not match.");
                    } else {
                        request.getSession().setAttribute("parent_id", null);
                    }
                    request.getSession().setAttribute("student", students.get(0));
                }

            } else { // if type == "Teacher"
                List hods = new HeadOfDepartmentQuery().makeQuery(schoolName, id);
                teachers = new TeacherQuery().makeQuery(schoolName,id,null,null);
                if(teachers == null || teachers.isEmpty()) {
                        if(hods == null || hods.isEmpty())
                            errors.put("id", "Your id or school name is wrong. Please check them..");
                        else
                            request.getSession().setAttribute("hod", hods.get(0));
                } else
                    request.getSession().setAttribute("teacher", teachers.get(0));
            }

        }


        return errors;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


}
