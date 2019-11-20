package Hibernate.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;

@Entity
@Table(name = "SCHOOL", schema = "TESTER", catalog = "")
public class SchoolEntity {
    private String name;
    private String schoolType;
    private String schoolAddress;

    @Id
    @Column(name = "NAME", nullable = false, length = 15)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "SCHOOL_TYPE", nullable = false, length = 15)
    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
    }

    @Basic
    @Column(name = "SCHOOL_ADDRESS", nullable = false, length = 50)
    public String getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolEntity that = (SchoolEntity) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(schoolType, that.schoolType) &&
                Objects.equals(schoolAddress, that.schoolAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, schoolType, schoolAddress);
    }

    private HashSet<ClazzEntity> classes;

    @OneToMany
    public HashSet<ClazzEntity> getOneToMany() {
        return classes;
    }

    public void setOneToMany(HashSet<ClazzEntity> oneToMany) {
        this.classes = oneToMany;
    }
}
