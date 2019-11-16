package entities;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "ANNOUNCEMENT", schema = "TESTER", catalog = "")
public class AnnouncementEntity {
    private Time submitDate;
    private Time dueDate;
    private String info;
    private String teacherEmployeeId;
    private String schoolName;
    private Long classSection;

    @Id
    @Column(name = "SUBMIT_DATE", nullable = false)
    public Time getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Time submitDate) {
        this.submitDate = submitDate;
    }

    @Basic
    @Column(name = "DUE_DATE", nullable = true)
    public Time getDueDate() {
        return dueDate;
    }

    public void setDueDate(Time dueDate) {
        this.dueDate = dueDate;
    }

    @Basic
    @Column(name = "INFO", nullable = true, length = 30)
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnnouncementEntity that = (AnnouncementEntity) o;
        return Objects.equals(submitDate, that.submitDate) &&
                Objects.equals(dueDate, that.dueDate) &&
                Objects.equals(info, that.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(submitDate, dueDate, info);
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

    @Basic
    @Column(name = "CLASS_SECTION", nullable = true, precision = 0)
    public Long getClassSection() {
        return classSection;
    }

    public void setClassSection(Long classSection) {
        this.classSection = classSection;
    }
}
