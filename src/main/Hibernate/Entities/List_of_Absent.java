package main.Hibernate.Entities;

import java.util.Date;

public class List_of_Absent {
    private String school_name;
    private String student_id;
    private Date absent_date;

    public List_of_Absent(String school_name, String student_id, Date absent_date) {
        this.school_name = school_name;
        this.student_id = student_id;
        this.absent_date = absent_date;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public Date getAbsent_date() {
        return absent_date;
    }

    public void setAbsent_date(Date absent_date) {
        this.absent_date = absent_date;
    }
}
