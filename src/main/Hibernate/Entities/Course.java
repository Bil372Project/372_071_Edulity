package main.Hibernate.Entities;

public class Course {
    private String course_name;
    private int grade;
    private boolean type;
    private String teacher_employee_id;

    public Course(String course_name, int grade, boolean type, String teacher_employee_id) {
        this.course_name = course_name;
        this.grade = grade;
        this.type = type;
        this.teacher_employee_id = teacher_employee_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public String getTeacher_employee_id() {
        return teacher_employee_id;
    }

    public void setTeacher_employee_id(String teacher_employee_id) {
        this.teacher_employee_id = teacher_employee_id;
    }
}
