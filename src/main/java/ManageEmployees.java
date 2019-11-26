import Hibernate.Entities.*;
import Hibernate.Generator.HibernateSupporter;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import javax.persistence.PersistenceException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Hashtable;

@WebServlet(urlPatterns = {"/manageEmployees"})
public class ManageEmployees extends HttpServlet {
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
            try {
                String[] types = req.getParameterValues("type");
                if(types.length == 0)
                    throw new NullPointerException();
                String id = req.getParameter("id");
                String name = req.getParameter("name");
                String specialization = req.getParameter("specialization");
                String office_no = req.getParameter("office_no");
                String school_name = req.getSession().getAttribute("school_name").toString();
                String ssn = req.getParameter("ssn");
                EmployeeEntity emp = new EmployeeEntity();
                emp.setEmployeeId(id);
                emp.setName(name);
                emp.setSchoolName(school_name);
                emp.setSsn(ssn);
                supporter.createObject(emp);
                TeachingStaffEntity teacher = new TeachingStaffEntity();
                teacher.setEmployeeId(id);
                teacher.setOfficeNo(office_no);
                teacher.setSchoolName(school_name);
                teacher.setSpecialization(specialization);
                supporter.createObject(teacher);
                if (Arrays.asList(types).contains("teacher")) {
                    TeacherEntity t = new TeacherEntity();
                    t.setEmployeeId(id);
                    t.setSchoolName(school_name);
                    supporter.createObject(t);
                }
                if (Arrays.asList(types).contains("hod")) {
                    HeadOfDepartmentEntity hod = new HeadOfDepartmentEntity();
                    hod.setEmployeeId(id);
                    hod.setSchoolName(school_name);
                    supporter.createObject(hod);
                }
            }catch (NullPointerException ex) {
                errors.put("Null","Be sure you have filled all fields");
            } catch (ConstraintViolationException ex) {
                errors.put("constraint", String.format("The id is already taken. Please choose another"));
            } catch (PersistenceException ex) {
                errors.put("persistance", "Could not create new entity");
            }
            if(errors.isEmpty())
                messages.put("success","Employee successfully added to Database");
        }else if (op.equals("update")) {
            String[] ids = req.getParameterValues("ids");

            if(ids != null)
                for (String id :
                        ids) {
                    String name =(!req.getParameter(id + "-name").equals("")) ? req.getParameter(id + "-name") :
                            req.getParameter(id + "-name-orig");
                    String specialization =(!req.getParameter(id + "-specialization").equals("")) ?
                            req.getParameter(id + "-specialization") :
                            req.getParameter(id + "-specialization-orig");
                    String ssn =(!req.getParameter(id + "-ssn").equals("")) ? req.getParameter(id + "-ssn") :
                            req.getParameter(id + "-ssn-orig");
                    String office_no =(!req.getParameter(id + "-office_no").equals("")) ? req.getParameter(id +
                            "-office_no") : req.getParameter(id + "-office_no-orig");

                    TeacherEntity t = new TeacherEntity();
                    t.setSchoolName((String) req.getSession().getAttribute("school_name"));
                    t.setEmployeeId(id);
                    t.setHodEmployeeId(null);
                    t.setSurveyId(null);
                    try {
                        supporter.update(t);
                    } catch (PersistenceException e) {
                        errors.put("persistance1" + id, String.format("%s cannot be updated",id));
                    } catch (Exception e) {
                        errors.put("unexpected1" + id, "An unexpected error occured");
                    }
                    //There is nothing for hod to update
                    TeachingStaffEntity teacher = new TeachingStaffEntity();
                    teacher.setEmployeeId(id);
                    teacher.setSpecialization(specialization);
                    teacher.setSchoolName((String) req.getSession().getAttribute("school_name"));
                    teacher.setOfficeNo(office_no);
                    try {
                        supporter.update(teacher);
                    } catch (PersistenceException e) {
                        errors.put("persistance2" + id, String.format("%s cannot be updated",id));
                    } catch (Exception e) {
                        errors.put("unexpected2" + id, "An unexpected error occured");
                    }
                    EmployeeEntity e = new EmployeeEntity();
                    e.setSsn(ssn);
                    e.setSchoolName((String) req.getSession().getAttribute("school_name"));
                    e.setName(name);
                    e.setEmployeeId(id);
                    try {
                        supporter.update(e);
                    } catch (PersistenceException ex) {
                        errors.put("persistance3" + id, String.format("%s cannot be updated",id));
                    } catch (Exception ex) {
                        errors.put("unexpected3" + id, "An unexpected error occured");
                    }
                    if (errors.isEmpty())
                        messages.put("success" + id, String.format("Succsefully updated the employee with id: %s",id));
                }
        } else { // delete option
            String[] ids = req.getParameterValues("ids");

            if(ids != null) {
                for (String id :
                        ids) {
                    session = HibernateSupporter.getSessionFactory().openSession();
                    Transaction transaction = session.beginTransaction();
                    String school_name = req.getSession().getAttribute("school_name").toString();
                    Query query = session.createQuery("delete TeacherEntity where schoolName = :schoolName " +
                            "and employeeId =:id");
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
                    query = session.createQuery("delete from HeadOfDepartmentEntity where schoolName = :schoolName " +
                            "and employeeId =:id");
                    query.setParameter("schoolName", school_name);
                    query.setParameter("id", id);
                    try {
                        query.executeUpdate();
                    } catch (PersistenceException e) {
                        errors.put("Persistence1" + id, String.format("Error for deleting %s\n from hods" +
                                "Possible reasons: The entity may be linked to some course like instances",id));
                    } catch (Exception e){
                        errors.put("Unexpected1" + id, String.format("An unexpected error occurred when deleting:" +
                                "%s",id));
                    }
                    query = session.createQuery("delete from TeachingStaffEntity where schoolName = :schoolName " +
                            "and employeeId =:id");
                    query.setParameter("schoolName", school_name);
                    query.setParameter("id", id);
                    try {
                        query.executeUpdate();
                    } catch (PersistenceException e) {
                        errors.put("Persistence2" + id, String.format("Error for deleting %s\n from hods" +
                                "Possible reasons: The entity may be linked to some course like instances",id));
                    } catch (Exception e){
                        errors.put("Unexpected2" + id, String.format("An unexpected error occurred when deleting:" +
                                "%s",id));
                    }
                    query = session.createQuery("delete from EmployeeEntity where schoolName = :schoolName " +
                            "and employeeId =:id");
                    query.setParameter("schoolName", school_name);
                    query.setParameter("id", id);
                    try {
                        query.executeUpdate();
                    } catch (PersistenceException e) {
                        errors.put("Persistence3" + id, String.format("Error for deleting %s\n from hods" +
                                "Possible reasons: The entity may be linked to some course like instances",id));
                    } catch (Exception e){
                        errors.put("Unexpected3" + id, String.format("An unexpected error occurred when deleting:" +
                                "%s",id));
                    }
                    if(errors.isEmpty()) {
                        messages.put("success"+id, String.format("Succesfully deleted the employee with id: %s", id));
                    }
                    transaction.commit();
                }
            }
        }

        session.close();
        req.setAttribute("errors",errors);
        req.setAttribute("messages", messages);
        req.getRequestDispatcher("employees.jsp").forward(req,resp);

    }
}
