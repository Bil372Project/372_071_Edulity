package main.Hibernate.Mappings;

public class Head_of_Department {
    private String school_name;
    private String employee_id;

    public Head_of_Department(String school_name, String employee_id) {
        this.school_name = school_name;
        this.employee_id = employee_id;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }
}
