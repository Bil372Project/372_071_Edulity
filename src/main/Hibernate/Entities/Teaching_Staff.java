package main.Hibernate.Entities;

public class Teaching_Staff {
    private String school_name;
    private String employee_id;
    private String Specialization;
    private int office_no;

    public Teaching_Staff(String school_name, String employee_id, String specialization, int office_no) {
        this.school_name = school_name;
        this.employee_id = employee_id;
        Specialization = specialization;
        this.office_no = office_no;
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

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String specialization) {
        Specialization = specialization;
    }

    public int getOffice_no() {
        return office_no;
    }

    public void setOffice_no(int office_no) {
        this.office_no = office_no;
    }
}
