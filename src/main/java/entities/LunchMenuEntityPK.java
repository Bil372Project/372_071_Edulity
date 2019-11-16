package entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Time;
import java.util.Objects;

public class LunchMenuEntityPK implements Serializable {
    private Time lunchDay;
    private String food;

    @Column(name = "LUNCH_DAY", nullable = false)
    @Id
    public Time getLunchDay() {
        return lunchDay;
    }

    public void setLunchDay(Time lunchDay) {
        this.lunchDay = lunchDay;
    }

    @Column(name = "FOOD", nullable = false, length = 30)
    @Id
    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LunchMenuEntityPK that = (LunchMenuEntityPK) o;
        return Objects.equals(lunchDay, that.lunchDay) &&
                Objects.equals(food, that.food);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lunchDay, food);
    }
}
