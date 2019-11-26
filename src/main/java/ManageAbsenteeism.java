import Hibernate.Entities.ListOfAbsentDatesEntity;
import Hibernate.Generator.HibernateSupporter;
import org.hibernate.Session;

import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Hashtable;

@WebServlet(urlPatterns = {"/manageAbsenteeism"})

public class ManageAbsenteeism extends HttpServlet {
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

        if(op.equals("add")) {
            String id = req.getParameter("id");
            String year = req.getParameter("year");
            String month = req.getParameter("month");
            String day = req.getParameter("day");
            ListOfAbsentDatesEntity entity = new ListOfAbsentDatesEntity();
            entity.setStudentId(id);
            entity.setSchoolName((String) req.getSession().getAttribute("school_name"));
            try {
                entity.setAbsentDate(Date.valueOf(year + "-" + month + "-" + day));
                supporter.createObject(entity);
            } catch (PersistenceException e) {
                errors.put("persistance", "Error because of some constraint rules");
            } catch (Exception e) {
                errors.put("Error", "Unexpected error: " + e.getMessage());
            }
            if (errors.isEmpty()) {
                messages.put("success", "Successfully added new absent date");
            }
        } else {
            String id = req.getParameter("id");
            String year = req.getParameter("year");
            String month = req.getParameter("month");
            String day = req.getParameter("day");
            Date date = Date.valueOf(year + "-" + month + "-" + day);
            session.beginTransaction();
            try {
                Query query = session.createQuery("delete from ListOfAbsentDatesEntity where studentId=:id and " +
                        "schoolName=:schoolName and absentDate =: date");
                query.setParameter("id",id);
                query.setParameter("schoolName", req.getSession().getAttribute("school_name").toString());
                query.setParameter("date",date);
                if(query.executeUpdate() == 0)
                    errors.put("not_exist", "Deletion failed. The student was not absent at this date");
            } catch (PersistenceException e) {
                errors.put("persistance", "Error because of some constraint rules");
            } catch (Exception e) {
                errors.put("Error", "Unexpected error: " + e.getMessage());
            }
            if (errors.isEmpty()) {
                messages.put("success", "Successfully deleted absent date");
            }

        }

        session.close();
        req.setAttribute("errors", errors);
        req.setAttribute("messages", messages);
        req.getRequestDispatcher("manageabsenteeism.jsp").forward(req,resp);
    }
}
