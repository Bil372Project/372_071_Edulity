package main.Hibernate.Entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Announcement", uniqueConstraints = @UniqueConstraint(columnNames = "submit_date"))
public class Announcement {

    @Id
    @Column(name = "SUBMIT_DATE", unique = true, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date submit_date;

    @Column(name = "DUE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date due_date;

    @Column(name = "INFO", length = 30)
    private String info;

    @ManyToOne(targetEntity = Teacher.class)
    @JoinColumn(name="TEACHER_EMPLOYEE_ID", referencedColumnName="EMPLOYEE_ID")
    private String teacher_employee_id;

    @ManyToOne(targetEntity = Class.class)
    @JoinColumns({
            @JoinColumn(name="SCHOOL_NAME", referencedColumnName="SCHOOL_NAME"),
            @JoinColumn(name="SCHOOL_NAME", referencedColumnName="SCHOOL_NAME")
    })
    private String school_name;

    @ManyToMany(targetEntity = Class.class)
    @JoinColumn(name="CLASS_SECTION", referencedColumnName="SECTION")
    private int class_section;

    public Announcement(Date submit_date, Date due_date, String info, String teacher_employee_id, String school_name, int class_section) {
        this.submit_date = submit_date;
        this.due_date = due_date;
        this.info = info;
        this.teacher_employee_id = teacher_employee_id;
        this.school_name = school_name;
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

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public int getClass_section() {
        return class_section;
    }

    public void setClass_section(int class_section) {
        this.class_section = class_section;
    }
}
