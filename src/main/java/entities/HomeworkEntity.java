package entities;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "HOMEWORK", schema = "TESTER", catalog = "")
public class HomeworkEntity {
    private long hwNumber;
    private Time dueDate;
    private String teacherEmployeeId;
    private String schoolName;
    private Long classSection;

    @Id
    @Column(name = "HW_NUMBER", nullable = false, precision = 0)
    public long getHwNumber() {
        return hwNumber;
    }

    public void setHwNumber(long hwNumber) {
        this.hwNumber = hwNumber;
    }

    @Basic
    @Column(name = "DUE_DATE", nullable = true)
    public Time getDueDate() {
        return dueDate;
    }

    public void setDueDate(Time dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeworkEntity that = (HomeworkEntity) o;
        return hwNumber == that.hwNumber &&
                Objects.equals(dueDate, that.dueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hwNumber, dueDate);
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
