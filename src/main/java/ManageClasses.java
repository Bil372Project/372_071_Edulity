import Hibernate.Entities.StudentEntity;
import Hibernate.Generator.HibernateSupporter;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.PersistenceException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Hashtable;

@WebServlet(urlPatterns = {"/manageClasses"})

public class ManageClasses extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HibernateSupporter supporter = new HibernateSupporter();
        Session session = supporter.getSessionFactory().openSession();
        Hashtable<String, String> errors = new Hashtable();
        Hashtable<String, String> messages = new Hashtable();
        String op = req.getParameter("submit");

        if (op.equals("add")) {
            Long section = Long.valueOf(req.getParameter("section"));
            String schoolName = (String) req.getSession().getAttribute("school_name");
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String parent_ssn = req.getParameter("parent_ssn");
            parent_ssn = (parent_ssn.equals("")) ? null : parent_ssn;
            String busid = req.getParameter("bus_id");
            Long bus_id = (busid.equals("")) ? null: (StringUtils.isNumeric(busid)) ? Long.valueOf(busid) : null;
            StudentEntity student = new StudentEntity();
            student.setClassSection(section);
            student.setName(name);
            student.setParentSsn(parent_ssn);
            student.setSchoolBusId(bus_id);
            student.setSchoolName(schoolName);
            student.setStudentId(id);
            try {
                supporter.createObject(student);
            } catch (PersistenceException e) {
                errors.put("persistance", "A student with the same id already exists. Please provide a different id");
            } catch (Exception e) {
                errors.put("add_error", "Unexpected error occured");
            }
            if (errors.isEmpty())
                messages.put("success", String.format("Successfully added the student with id: %s",id));
            req.setAttribute("section" ,section);
        } else if (op.equals("update")) {
            String[] ids = req.getParameterValues("ids");
            if (ids != null && ids.length != 0) {
                for (String id :
                        ids) {
                    String section = req.getParameter(id + "-section");
                    String name =(!req.getParameter(id + "-name").equals("")) ? req.getParameter(id + "-name") :
                            req.getParameter(id + "-name-orig");
                    String parentssn =(!req.getParameter(id + "-parentssn").equals("")) ?
                            req.getParameter(id + "-parentssn") :
                            req.getParameter(id + "-parentssn-orig");
                    String busid =(!req.getParameter(id + "-bus_id").equals("")) ? req.getParameter(id + "-bus_id") :
                            req.getParameter(id + "-bus_id-orig");
                    StudentEntity student = new StudentEntity();
                    student.setClassSection(Long.valueOf(section));
                    student.setStudentId(id);
                    student.setName(name);
                    student.setParentSsn(parentssn);
                    student.setSchoolName((String) req.getSession().getAttribute("school_name"));
                    Long bus_id = (busid.equals("")) ? null: (StringUtils.isNumeric(busid)) ? Long.valueOf(busid) :
                            Long.valueOf(req.getParameter(id + "-bus_id-orig"));
                    student.setSchoolBusId(Long.valueOf(bus_id));
                    try {
                        supporter.update(student);
                    } catch (PersistenceException e) {
                        errors.put("persistance", "Could not update the student because of a constraint error");
                    } catch (Exception e) {
                        errors.put("add_error", "Unexpected error occured");
                    }
                    if (errors.isEmpty()) {
                        messages.put("success" + id, String.format("Succesfully updated the student with id: %s", id));
                    }
                    req.setAttribute("section" ,section);
                }
            }

        } else { // delete
            String[] ids = req.getParameterValues("ids");
            String s = "";
            if (ids != null && ids.length != 0) {
                for (String id :
                        ids) {
                    String section = req.getParameter(id + "-section");
                    s = section;
                    Transaction transaction = session.beginTransaction();
                    String school_name = req.getSession().getAttribute("school_name").toString();
                    Query query = session.createQuery("delete StudentEntity where schoolName = :schoolName " +
                            "and studentId =:id");
                    query.setParameter("schoolName", school_name);
                    query.setParameter("id", id);
                    try {
                        query.executeUpdate();
                    } catch (PersistenceException e) {
                        errors.put("Persistence0" + id, String.format("Error for deleting %s\n from Teachers" +
                                "Possible reasons: The entity may be linked to some course like instances",id));
                    } catch (Exception e){
                        errors.put("Unexpected0" + id, String.format("An unexpected error occurred when deleting:" +
                                "%s",id));
                    }
                    if (errors.isEmpty())
                        messages.put("success" + id, String.format("Successfully deleted the student with id: %s", id));
                }
                req.setAttribute("section" ,s);
            }
        }
        session.close();
        req.setAttribute("section", req.getParameter("section"));
        req.setAttribute("errors", errors);
        req.setAttribute("messages", messages);
        req.getRequestDispatcher("classes.jsp").forward(req,resp);
    }
}
