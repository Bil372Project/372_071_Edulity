package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "COURSE", schema = "TESTER", catalog = "")
@IdClass(CourseEntityPK.class)
public class CourseEntity {
    private String courseName;
    private long grade;
    private String type;
    private String teacherEmployeeId;
    private String schoolName;

    @Id
    @Column(name = "COURSE_NAME", nullable = false, length = 30)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Id
    @Column(name = "GRADE", nullable = false, precision = 0)
    public long getGrade() {
        return grade;
    }

    public void setGrade(long grade) {
        this.grade = grade;
    }

    @Basic
    @Column(name = "TYPE", nullable = true, length = 10)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseEntity that = (CourseEntity) o;
        return grade == that.grade &&
                Objects.equals(courseName, that.courseName) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName, grade, type);
    }

    @Basic
    @Column(name = "TEACHER_EMPLOYEE_ID", nullable = true, length = 15)
    public String getTeacherEmployeeId() {
        return teacherEmployeeId;
    }

    public void setTeacherEmployeeId(String teacherEmployeeId) {
        this.teacherEmployeeId = teacherEmployeeId;
    }

    @Basic
    @Column(name = "SCHOOL_NAME", nullable = true, length = 15)
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
