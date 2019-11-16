package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SYLLABUS", schema = "TESTER", catalog = "")
@IdClass(SyllabusEntityPK.class)
public class SyllabusEntity {
    private String semester;
    private String courseName;
    private Long gradingInfo;
    private String hodEmployeeId;
    private String schoolName;

    @Id
    @Column(name = "SEMESTER", nullable = false, length = 30)
    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Id
    @Column(name = "COURSE_NAME", nullable = false, length = 30)
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
        SyllabusEntity that = (SyllabusEntity) o;
        return Objects.equals(semester, that.semester) &&
                Objects.equals(courseName, that.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(semester, courseName);
    }

    @Basic
    @Column(name = "GRADING_INFO", nullable = true, precision = 0)
    public Long getGradingInfo() {
        return gradingInfo;
    }

    public void setGradingInfo(Long gradingInfo) {
        this.gradingInfo = gradingInfo;
    }

    @Basic
    @Column(name = "HOD_EMPLOYEE_ID", nullable = true, length = 15)
    public String getHodEmployeeId() {
        return hodEmployeeId;
    }

    public void setHodEmployeeId(String hodEmployeeId) {
        this.hodEmployeeId = hodEmployeeId;
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
