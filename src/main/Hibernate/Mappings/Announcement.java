package main.Hibernate.Mappings;

import java.util.Date;

public class Announcement {
    private Date submit_date;
    private Date due_date;
    private String info;
    private String teacher_employee_id;
    private int class_section;

    public Announcement(Date submit_date, Date due_date, String info, String teacher_employee_id, int class_section) {
        this.submit_date = submit_date;
        this.due_date = due_date;
        this.info = info;
        this.teacher_employee_id = teacher_employee_id;
        this.class_section = class_section;
    }

    public Date getSubmit_date() {
        return submit_date;
    }

    public void setSubmit_date(Date submit_date) {
        this.submit_date = submit_date;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTeacher_employee_id() {
        return teacher_employee_id;
    }

    public void setTeacher_employee_id(String teacher_employee_id) {
        this.teacher_employee_id = teacher_employee_id;
    }

    public int getClass_section() {
        return class_section;
    }

    public void setClass_section(int class_section) {
        this.class_section = class_section;
    }
}
