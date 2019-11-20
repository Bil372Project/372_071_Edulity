package Hibernate.Entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Time;
import java.util.Objects;

public class SyllabusExamDateEntityPK implements Serializable {
    private String semester;
    private Time subject;

    @Column(name = "SEMESTER", nullable = false, length = 30)
    @Id
    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Column(name = "SUBJECT", nullable = false)
    @Id
    public Time getSubject() {
        return subject;
    }

    public void setSubject(Time subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SyllabusExamDateEntityPK that = (SyllabusExamDateEntityPK) o;
        return Objects.equals(semester, that.semester) &&
                Objects.equals(subject, that.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(semester, subject);
    }
}
