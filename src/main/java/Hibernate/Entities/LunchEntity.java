package Hibernate.Entities;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "LUNCH", schema = "TESTER", catalog = "")
public class LunchEntity {
    private Time day;
    private String studentId;
    private String schoolName;

    @Id
    @Column(name = "DAY", nullable = false)
    public Time getDay() {
        return day;
    }

    public void setDay(Time day) {
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LunchEntity that = (LunchEntity) o;
        return Objects.equals(day, that.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day);
    }

    @Basic
    @Column(name = "STUDENT_ID", nullable = true, length = 30)
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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
