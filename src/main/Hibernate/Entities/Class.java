package main.Hibernate.Entities;

import javax.persistence.*;

@Entity
@Table(name = "CLASS", uniqueConstraints = @UniqueConstraint(columnNames = {"school_name", "section"}))
public class Class {
    private String school_name;
    private int section;
    private String schedule;
    private int class_size;

    public Class(String school_name, int section, String schedule, int class_size) {
        this.school_name = school_name;
        this.section = section;
        this.schedule = schedule;
        this.class_size = class_size;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public int getClass_size() {
        return class_size;
    }

    public void setClass_size(int class_size) {
        this.class_size = class_size;
    }
}
