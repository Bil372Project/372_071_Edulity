package main.Hibernate.Mappings;

public class Syllabus_Subject_List {
    private String semester;
    private String subject;

    public Syllabus_Subject_List(String semester, String subject) {
        this.semester = semester;
        this.subject = subject;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
