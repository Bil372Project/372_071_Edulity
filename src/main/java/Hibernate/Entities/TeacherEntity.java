package Hibernate.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TEACHER", schema = "TESTER", catalog = "")
@IdClass(TeacherEntityPK.class)
public class TeacherEntity {
    private String schoolName;
    private String employeeId;
    private String surveyId;
    private String hodEmployeeId;

    @Id
    @Column(name = "SCHOOL_NAME", nullable = false, length = 15)
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Id
    @Column(name = "EMPLOYEE_ID", nullable = false, length = 15)
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherEntity that = (TeacherEntity) o;
        return Objects.equals(schoolName, that.schoolName) &&
                Objects.equals(employeeId, that.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schoolName, employeeId);
    }

    @Basic
    @Column(name = "SURVEY_ID", nullable = true, length = 20)
    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    @Basic
    @Column(name = "HOD_EMPLOYEE_ID", nullable = true, length = 15)
    public String getHodEmployeeId() {
        return hodEmployeeId;
    }

    public void setHodEmployeeId(String hodEmployeeId) {
        this.hodEmployeeId = hodEmployeeId;
    }
}
