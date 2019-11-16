package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SURVEY", schema = "TESTER", catalog = "")
public class SurveyEntity {
    private String surveyId;
    private String schoolName;
    private String hodEmployeeId;
    private String parentSsn;

    @Id
    @Column(name = "SURVEY_ID", nullable = false, length = 20)
    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SurveyEntity that = (SurveyEntity) o;
        return Objects.equals(surveyId, that.surveyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surveyId);
    }

    @Basic
    @Column(name = "SCHOOL_NAME", nullable = true, length = 15)
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
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
    @Column(name = "PARENT_SSN", nullable = true, length = 30)
    public String getParentSsn() {
        return parentSsn;
    }

    public void setParentSsn(String parentSsn) {
        this.parentSsn = parentSsn;
    }
}
