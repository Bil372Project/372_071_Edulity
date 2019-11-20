package Hibernate.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CLASS", schema = "TESTER", catalog = "")
@IdClass(ClazzEntityPK.class)
public class ClazzEntity {
    private String schoolName;
    private long section;
    private String schedule;
    private Long classSize;


    @Id
    @Column(name = "SCHOOL_NAME", nullable = false, length = 15)
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Id
    @Column(name = "SECTION", nullable = false, precision = 0)
    public long getSection() {
        return section;
    }

    public void setSection(long section) {
        this.section = section;
    }

    @Basic
    @Column(name = "SCHEDULE", nullable = true, length = 50)
    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    @Basic
    @Column(name = "CLASS_SIZE", nullable = true, precision = 0)
    public Long getClassSize() {
        return classSize;
    }

    public void setClassSize(Long classSize) {
        this.classSize = classSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClazzEntity that = (ClazzEntity) o;
        return section == that.section &&
                Objects.equals(schoolName, that.schoolName) &&
                Objects.equals(schedule, that.schedule) &&
                Objects.equals(classSize, that.classSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schoolName, section, schedule, classSize);
    }
}
