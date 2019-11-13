package main.Hibernate.Mappings;

public class Syllabus {
    private String semester;
    private String course_name;
    private String grading_info;
    private String hod_employee_id;

    public Syllabus(String semester, String course_name, String grading_info, String hod_employee_id) {
        this.semester = semester;
        this.course_name = course_name;
        this.grading_info = grading_info;
        this.hod_employee_id = hod_employee_id;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getGrading_info() {
        return grading_info;
    }

    public void setGrading_info(String grading_info) {
        this.grading_info = grading_info;
    }

    public String getHod_employee_id() {
        return hod_employee_id;
    }

    public void setHod_employee_id(String hod_employee_id) {
        this.hod_employee_id = hod_employee_id;
    }
}
