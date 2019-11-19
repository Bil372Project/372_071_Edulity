package Hibernate.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SCHOOL_BUS_STOPS", schema = "TESTER", catalog = "")
@IdClass(SchoolBusStopsEntityPK.class)
public class SchoolBusStopsEntity {
    private long schoolBusId;
    private String stopId;

    @Id
    @Column(name = "SCHOOL_BUS_ID", nullable = false, precision = 0)
    public long getSchoolBusId() {
        return schoolBusId;
    }

    public void setSchoolBusId(long schoolBusId) {
        this.schoolBusId = schoolBusId;
    }

    @Id
    @Column(name = "STOP_ID", nullable = false, length = 30)
    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolBusStopsEntity that = (SchoolBusStopsEntity) o;
        return schoolBusId == that.schoolBusId &&
                Objects.equals(stopId, that.stopId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schoolBusId, stopId);
    }
}
