package Hibernate.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TEACHING_STAFF", schema = "TESTER", catalog = "")
@IdClass(TeachingStaffEntityPK.class)
public class TeachingStaffEntity {
    private String schoolName;
    private String employeeId;

    private String specialization;
    private String officeNo;

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

    @Basic
    @Column(name = "SPECIALIZATION", nullable = false, length = 50)
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Basic
    @Column(name = "OFFICE_NO", nullable = false, length = 50)
    public String getOfficeNo() {
        return officeNo;
    }

    public void setOfficeNo(String officeNo) {
        this.officeNo = officeNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeachingStaffEntity that = (TeachingStaffEntity) o;
        return Objects.equals(schoolName, that.schoolName) &&
                Objects.equals(employeeId, that.employeeId) &&
                Objects.equals(specialization, that.specialization) &&
                Objects.equals(officeNo, that.officeNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schoolName, employeeId, specialization, officeNo);
    }

}
