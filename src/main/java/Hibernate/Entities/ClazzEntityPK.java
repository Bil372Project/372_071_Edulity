package Hibernate.Entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ClazzEntityPK implements Serializable {
    private String schoolName;
    private long section;

    @Column(name = "SCHOOL_NAME", nullable = false, length = 15)
    @Id
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Column(name = "SECTION", nullable = false, precision = 0)
    @Id
    public long getSection() {
        return section;
    }

    public void setSection(long section) {
        this.section = section;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClazzEntityPK that = (ClazzEntityPK) o;
        return section == that.section &&
                Objects.equals(schoolName, that.schoolName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schoolName, section);
    }
}
