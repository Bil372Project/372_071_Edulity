package main.Hibernate.Mappings;

import java.util.Date;

public class Syllabus_Exam_Date {
    private String semester;
    private Date exam_date;

    public Syllabus_Exam_Date(String semester, Date exam_date) {
        this.semester = semester;
        this.exam_date = exam_date;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Date getExam_date() {
        return exam_date;
    }

    public void setExam_date(Date exam_date) {
        this.exam_date = exam_date;
    }
}
