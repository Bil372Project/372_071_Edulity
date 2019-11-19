package Hibernate.Entities;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "SCHEDULE_CONSISTS_OF", schema = "TESTER", catalog = "")
@IdClass(ScheduleConsistsOfEntityPK.class)
public class ScheduleConsistsOfEntity {
    private String scheduleId;
    private String courseName;
    private Time startDate;
    private Time endDate;
    private Long grade;

    @Id
    @Column(name = "SCHEDULE_ID", nullable = false, length = 30)
    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    @Id
    @Column(name = "COURSE_NAME", nullable = false, length = 30)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Basic
    @Column(name = "START_DATE", nullable = true)
    public Time getStartDate() {
        return startDate;
    }

    public void setStartDate(Time startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "END_DATE", nullable = true)
    public Time getEndDate() {
        return endDate;
    }

    public void setEndDate(Time endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduleConsistsOfEntity that = (ScheduleConsistsOfEntity) o;
        return Objects.equals(scheduleId, that.scheduleId) &&
                Objects.equals(courseName, that.courseName) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scheduleId, courseName, startDate, endDate);
    }

    @Basic
    @Column(name = "GRADE", nullable = true, precision = 0)
    public Long getGrade() {
        return grade;
    }

    public void setGrade(Long grade) {
        this.grade = grade;
    }
}
