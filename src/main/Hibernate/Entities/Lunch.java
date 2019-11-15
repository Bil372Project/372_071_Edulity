package main.Hibernate.Entities;

import java.util.Date;

public class Lunch {
    private Date day;
    private String student_id;

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }
}
