package main.Hibernate.Mappings;

import java.util.Date;

public class Student {
    private String school_name;
    private String student_id;
    private String name;
    private int number_of_absent;
    private int year;
    private Date birth_date;
    private String birth_place;
    private int class_section;
    private String parent_ssn;
    private int school_bus_id;

    public Student(String school_name, String student_id, String name, int number_of_absent, int year, Date birth_date, String birth_place, int class_section, String parent_ssn, int school_bus_id) {
        this.school_name = school_name;
        this.student_id = student_id;
        this.name = name;
        this.number_of_absent = number_of_absent;
        this.year = year;
        this.birth_date = birth_date;
        this.birth_place = birth_place;
        this.class_section = class_section;
        this.parent_ssn = parent_ssn;
        this.school_bus_id = school_bus_id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber_of_absent() {
        return number_of_absent;
    }

    public void setNumber_of_absent(int number_of_absent) {
        this.number_of_absent = number_of_absent;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getBirth_place() {
        return birth_place;
    }

    public void setBirth_place(String birth_place) {
        this.birth_place = birth_place;
    }

    public int getClass_section() {
        return class_section;
    }

    public void setClass_section(int class_section) {
        this.class_section = class_section;
    }

    public String getParent_ssn() {
        return parent_ssn;
    }

    public void setParent_ssn(String parent_ssn) {
        this.parent_ssn = parent_ssn;
    }

    public int getSchool_bus_id() {
        return school_bus_id;
    }

    public void setSchool_bus_id(int school_bus_id) {
        this.school_bus_id = school_bus_id;
    }
}
