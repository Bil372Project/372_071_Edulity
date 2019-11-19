package Hibernate.Entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ScheduleConsistsOfEntityPK implements Serializable {
    private String scheduleId;
    private String courseName;

    @Column(name = "SCHEDULE_ID", nullable = false, length = 30)
    @Id
    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    @Column(name = "COURSE_NAME", nullable = false, length = 30)
    @Id
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
        ScheduleConsistsOfEntityPK that = (ScheduleConsistsOfEntityPK) o;
        return Objects.equals(scheduleId, that.scheduleId) &&
                Objects.equals(courseName, that.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scheduleId, courseName);
    }
}
