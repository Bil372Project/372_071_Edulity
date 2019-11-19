package Hibernate.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "STOP", schema = "TESTER", catalog = "")
public class StopEntity {
    private String stopId;
    private String stopName;

    @Id
    @Column(name = "STOP_ID", nullable = false, length = 30)
    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    @Basic
    @Column(name = "STOP_NAME", nullable = true, length = 30)
    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StopEntity that = (StopEntity) o;
        return Objects.equals(stopId, that.stopId) &&
                Objects.equals(stopName, that.stopName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stopId, stopName);
    }
}
