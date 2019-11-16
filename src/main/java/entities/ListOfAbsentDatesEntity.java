package entities;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "LIST_OF_ABSENT_DATES", schema = "TESTER", catalog = "")
@IdClass(ListOfAbsentDatesEntityPK.class)
public class ListOfAbsentDatesEntity {
    private String schoolName;
    private String studentId;
    private Time absentDate;

    @Id
    @Column(name = "SCHOOL_NAME", nullable = false, length = 30)
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Id
    @Column(name = "STUDENT_ID", nullable = false, length = 15)
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Id
    @Column(name = "ABSENT_DATE", nullable = false)
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
        ListOfAbsentDatesEntity that = (ListOfAbsentDatesEntity) o;
        return Objects.equals(schoolName, that.schoolName) &&
                Objects.equals(studentId, that.studentId) &&
                Objects.equals(absentDate, that.absentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schoolName, studentId, absentDate);
    }
}
