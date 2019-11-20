package Hibernate.Entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class SchoolBusStopsEntityPK implements Serializable {
    private long schoolBusId;
    private String stopId;

    @Column(name = "SCHOOL_BUS_ID", nullable = false, precision = 0)
    @Id
    public long getSchoolBusId() {
        return schoolBusId;
    }

    public void setSchoolBusId(long schoolBusId) {
        this.schoolBusId = schoolBusId;
    }

    @Column(name = "STOP_ID", nullable = false, length = 30)
    @Id
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
        SchoolBusStopsEntityPK that = (SchoolBusStopsEntityPK) o;
        return schoolBusId == that.schoolBusId &&
                Objects.equals(stopId, that.stopId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schoolBusId, stopId);
    }
}
