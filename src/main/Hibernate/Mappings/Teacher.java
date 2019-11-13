package main.Hibernate.Mappings;

public class Teacher {
    private String school_name;
    private String employee_id;
    private String survey_id;
    private String hod_employee_id;

    public Teacher(String school_name, String employee_id, String survey_id, String hod_employee_id) {
        this.school_name = school_name;
        this.employee_id = employee_id;
        this.survey_id = survey_id;
        this.hod_employee_id = hod_employee_id;
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

    public String getSurvey_id() {
        return survey_id;
    }

    public void setSurvey_id(String survey_id) {
        this.survey_id = survey_id;
    }

    public String getHod_employee_id() {
        return hod_employee_id;
    }

    public void setHod_employee_id(String hod_employee_id) {
        this.hod_employee_id = hod_employee_id;
    }
}
