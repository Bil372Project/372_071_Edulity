package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "EMPLOYEE", schema = "TESTER", catalog = "")
@IdClass(EmployeeEntityPK.class)
public class EmployeeEntity {
    private String employeeId;
    private String schoolName;
    private String ssn;
    private String name;

    @Id
    @Column(name = "EMPLOYEE_ID", nullable = false, length = 15)
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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
    @Column(name = "SSN", nullable = false, length = 50)
    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return Objects.equals(employeeId, that.employeeId) &&
                Objects.equals(schoolName, that.schoolName) &&
                Objects.equals(ssn, that.ssn) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, schoolName, ssn, name);
    }
}
