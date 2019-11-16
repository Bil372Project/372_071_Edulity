package entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class HeadOfDepartmentEntityPK implements Serializable {
    private String schoolName;
    private String employeeId;

    @Column(name = "SCHOOL_NAME", nullable = false, length = 15)
    @Id
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Column(name = "EMPLOYEE_ID", nullable = false, length = 15)
    @Id
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeadOfDepartmentEntityPK that = (HeadOfDepartmentEntityPK) o;
        return Objects.equals(schoolName, that.schoolName) &&
                Objects.equals(employeeId, that.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schoolName, employeeId);
    }
}
