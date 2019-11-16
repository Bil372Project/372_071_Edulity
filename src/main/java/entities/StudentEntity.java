package entities;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "STUDENT", schema = "TESTER", catalog = "")
@IdClass(StudentEntityPK.class)
public class StudentEntity {
    private String schoolName;
    private String studentId;
    private String name;
    private Long numberOfAbsent;
    private Long year;
    private Time birthDate;
    private String birthPlace;
    private Long classSection;
    private String parentSsn;
    private Long schoolBusId;

    @Id
    @Column(name = "SCHOOL_NAME", nullable = false, length = 15)
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Id
    @Column(name = "STUDENT_ID", nullable = false, length = 30)
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "NAME", nullable = true, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "NUMBER_OF_ABSENT", nullable = true, precision = 0)
    public Long getNumberOfAbsent() {
        return numberOfAbsent;
    }

    public void setNumberOfAbsent(Long numberOfAbsent) {
        this.numberOfAbsent = numberOfAbsent;
    }

    @Basic
    @Column(name = "YEAR", nullable = true, precision = 0)
    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    @Basic
    @Column(name = "BIRTH_DATE", nullable = true)
    public Time getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Time birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "BIRTH_PLACE", nullable = true, length = 30)
    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return Objects.equals(schoolName, that.schoolName) &&
                Objects.equals(studentId, that.studentId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(numberOfAbsent, that.numberOfAbsent) &&
                Objects.equals(year, that.year) &&
                Objects.equals(birthDate, that.birthDate) &&
                Objects.equals(birthPlace, that.birthPlace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schoolName, studentId, name, numberOfAbsent, year, birthDate, birthPlace);
    }

    @Basic
    @Column(name = "CLASS_SECTION", nullable = true, precision = 0)
    public Long getClassSection() {
        return classSection;
    }

    public void setClassSection(Long classSection) {
        this.classSection = classSection;
    }

    @Basic
    @Column(name = "PARENT_SSN", nullable = true, length = 30)
    public String getParentSsn() {
        return parentSsn;
    }

    public void setParentSsn(String parentSsn) {
        this.parentSsn = parentSsn;
    }

    @Basic
    @Column(name = "SCHOOL_BUS_ID", nullable = true, precision = 0)
    public Long getSchoolBusId() {
        return schoolBusId;
    }

    public void setSchoolBusId(Long schoolBusId) {
        this.schoolBusId = schoolBusId;
    }
}
