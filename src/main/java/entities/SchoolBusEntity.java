package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SCHOOL_BUS", schema = "TESTER", catalog = "")
public class SchoolBusEntity {
    private long id;
    private String licensePlate;
    private String destination;
    private Long capacity;
    private String driverId;
    private String schoolName;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "LICENSE_PLATE", nullable = true, length = 30)
    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Basic
    @Column(name = "DESTINATION", nullable = true, length = 30)
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Basic
    @Column(name = "CAPACITY", nullable = true, precision = 0)
    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolBusEntity that = (SchoolBusEntity) o;
        return id == that.id &&
                Objects.equals(licensePlate, that.licensePlate) &&
                Objects.equals(destination, that.destination) &&
                Objects.equals(capacity, that.capacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, licensePlate, destination, capacity);
    }

    @Basic
    @Column(name = "DRIVER_ID", nullable = true, length = 30)
    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    @Basic
    @Column(name = "SCHOOL_NAME", nullable = true, length = 15)
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
