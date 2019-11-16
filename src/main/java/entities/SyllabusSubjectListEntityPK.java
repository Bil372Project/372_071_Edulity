package entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class SyllabusSubjectListEntityPK implements Serializable {
    private String semester;
    private String subject;

    @Column(name = "SEMESTER", nullable = false, length = 30)
    @Id
    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Column(name = "SUBJECT", nullable = false, length = 50)
    @Id
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
        SyllabusSubjectListEntityPK that = (SyllabusSubjectListEntityPK) o;
        return Objects.equals(semester, that.semester) &&
                Objects.equals(subject, that.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(semester, subject);
    }
}
