package Hibernate.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "HAVE_SCHEDULE", schema = "TESTER", catalog = "")
@IdClass(HaveScheduleEntityPK.class)
public class HaveScheduleEntity {
    private long classSection;
    private String schoolName;
    private String scheduleId;

    @Id
    @Column(name = "CLASS_SECTION", nullable = false, precision = 0)
    public long getClassSection() {
        return classSection;
    }

    public void setClassSection(long classSection) {
        this.classSection = classSection;
    }

    @Id
    @Column(name = "SCHOOL_NAME", nullable = false, length = 15)
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Basic
    @Column(name = "SCHEDULE_ID", nullable = true, length = 30)
    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HaveScheduleEntity that = (HaveScheduleEntity) o;
        return classSection == that.classSection &&
                Objects.equals(schoolName, that.schoolName) &&
                Objects.equals(scheduleId, that.scheduleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classSection, schoolName, scheduleId);
    }
}
