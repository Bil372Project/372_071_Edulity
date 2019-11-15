package main.Hibernate.Entities;

import java.util.Date;

public class Homework {
    private int hw_number;
    private Date due_date;
    private String teacher_employee_id;
    private int class_section;

    public Homework(int hw_number, Date due_date, String teacher_employee_id, int class_section) {
        this.hw_number = hw_number;
        this.due_date = due_date;
        this.teacher_employee_id = teacher_employee_id;
        this.class_section = class_section;
    }

    public int getHw_number() {
        return hw_number;
    }

    public void setHw_number(int hw_number) {
        this.hw_number = hw_number;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
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
