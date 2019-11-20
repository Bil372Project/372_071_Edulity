package Hibernate.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "HEAD_OF_DEPARTMENT", schema = "TESTER", catalog = "")
@IdClass(HeadOfDepartmentEntityPK.class)
public class HeadOfDepartmentEntity {
    private String schoolName;
    private String employeeId;

    @Id
    @Column(name = "SCHOOL_NAME", nullable = false, length = 15)
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Id
    @Column(name = "EMPLOYEE_ID", nullable = false, length = 15)
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
        HeadOfDepartmentEntity that = (HeadOfDepartmentEntity) o;
        return Objects.equals(schoolName, that.schoolName) &&
                Objects.equals(employeeId, that.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schoolName, employeeId);
    }
}
