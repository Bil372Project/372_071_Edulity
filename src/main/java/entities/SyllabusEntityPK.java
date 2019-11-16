package entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class SyllabusEntityPK implements Serializable {
    private String semester;
    private String courseName;

    @Column(name = "SEMESTER", nullable = false, length = 30)
    @Id
    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Column(name = "COURSE_NAME", nullable = false, length = 30)
    @Id
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SyllabusEntityPK that = (SyllabusEntityPK) o;
        return Objects.equals(semester, that.semester) &&
                Objects.equals(courseName, that.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(semester, courseName);
    }
}
