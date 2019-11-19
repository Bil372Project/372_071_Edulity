package Hibernate.Entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class HaveScheduleEntityPK implements Serializable {
    private long classSection;
    private String schoolName;

    @Column(name = "CLASS_SECTION", nullable = false, precision = 0)
    @Id
    public long getClassSection() {
        return classSection;
    }

    public void setClassSection(long classSection) {
        this.classSection = classSection;
    }

    @Column(name = "SCHOOL_NAME", nullable = false, length = 15)
    @Id
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HaveScheduleEntityPK that = (HaveScheduleEntityPK) o;
        return classSection == that.classSection &&
                Objects.equals(schoolName, that.schoolName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classSection, schoolName);
    }
}
