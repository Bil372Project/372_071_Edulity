package entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class EmployeeEntityPK implements Serializable {
    private String employeeId;
    private String schoolName;

    @Column(name = "EMPLOYEE_ID", nullable = false, length = 15)
    @Id
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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
        EmployeeEntityPK that = (EmployeeEntityPK) o;
        return Objects.equals(employeeId, that.employeeId) &&
                Objects.equals(schoolName, that.schoolName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, schoolName);
    }
}
