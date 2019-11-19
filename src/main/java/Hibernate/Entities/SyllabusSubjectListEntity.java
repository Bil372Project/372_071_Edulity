package Hibernate.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SYLLABUS_SUBJECT_LIST", schema = "TESTER", catalog = "")
@IdClass(SyllabusSubjectListEntityPK.class)
public class SyllabusSubjectListEntity {
    private String semester;
    private String subject;
    private String courseName;

    @Id
    @Column(name = "SEMESTER", nullable = false, length = 30)
    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Id
    @Column(name = "SUBJECT", nullable = false, length = 50)
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SyllabusSubjectListEntity that = (SyllabusSubjectListEntity) o;
        return Objects.equals(semester, that.semester) &&
                Objects.equals(subject, that.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(semester, subject);
    }

    @Basic
    @Column(name = "COURSE_NAME", nullable = true, length = 30)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
