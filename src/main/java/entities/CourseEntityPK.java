package entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CourseEntityPK implements Serializable {
    private String courseName;
    private long grade;

    public CourseEntityPK(String courseName, long grade) {
        this.courseName = courseName;
        this.grade = grade;
    }

    @Column(name = "COURSE_NAME", nullable = false, length = 30)
    @Id
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Column(name = "GRADE", nullable = false, precision = 0)
    @Id
    public long getGrade() {
        return grade;
    }

    public void setGrade(long grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseEntityPK that = (CourseEntityPK) o;
        return grade == that.grade &&
                Objects.equals(courseName, that.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName, grade);
    }
}
