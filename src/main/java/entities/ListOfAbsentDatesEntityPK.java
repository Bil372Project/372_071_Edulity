package entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Time;
import java.util.Objects;

public class ListOfAbsentDatesEntityPK implements Serializable {
    private String schoolName;
    private String studentId;
    private Time absentDate;

    @Column(name = "SCHOOL_NAME", nullable = false, length = 30)
    @Id
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Column(name = "STUDENT_ID", nullable = false, length = 15)
    @Id
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Column(name = "ABSENT_DATE", nullable = false)
    @Id
    public Time getAbsentDate() {
        return absentDate;
    }

    public void setAbsentDate(Time absentDate) {
        this.absentDate = absentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListOfAbsentDatesEntityPK that = (ListOfAbsentDatesEntityPK) o;
        return Objects.equals(schoolName, that.schoolName) &&
                Objects.equals(studentId, that.studentId) &&
                Objects.equals(absentDate, that.absentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schoolName, studentId, absentDate);
    }
}
