package main.Hibernate.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table( name = "Employee" )
public class Employee implements Serializable {

    private String employee_id;
    private String school_name;
    private int ssn;
    private String name;

    public Employee(String employee_id, String school_name, int ssn, String name) {
        this.employee_id = employee_id;
        this.school_name = school_name;
        this.ssn = ssn;
        this.name = name;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
