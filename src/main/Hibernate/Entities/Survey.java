package main.Hibernate.Entities;

public class Survey {
    private String survey_id;
    private String school_name;
    private String hod_employee_id;
    private String parent_ssn;

    public Survey(String survey_id, String school_name, String hod_employee_id, String parent_ssn) {
        this.survey_id = survey_id;
        this.school_name = school_name;
        this.hod_employee_id = hod_employee_id;
        this.parent_ssn = parent_ssn;
    }

    public String getSurvey_id() {
        return survey_id;
    }

    public void setSurvey_id(String survey_id) {
        this.survey_id = survey_id;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getHod_employee_id() {
        return hod_employee_id;
    }

    public void setHod_employee_id(String hod_employee_id) {
        this.hod_employee_id = hod_employee_id;
    }

    public String getParent_ssn() {
        return parent_ssn;
    }

    public void setParent_ssn(String parent_ssn) {
        this.parent_ssn = parent_ssn;
    }
}
