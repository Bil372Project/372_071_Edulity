package entities;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "LUNCH_MENU", schema = "TESTER", catalog = "")
@IdClass(LunchMenuEntityPK.class)
public class LunchMenuEntity {
    private Time lunchDay;
    private String food;

    @Id
    @Column(name = "LUNCH_DAY", nullable = false)
    public Time getLunchDay() {
        return lunchDay;
    }

    public void setLunchDay(Time lunchDay) {
        this.lunchDay = lunchDay;
    }

    @Id
    @Column(name = "FOOD", nullable = false, length = 30)
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
        LunchMenuEntity that = (LunchMenuEntity) o;
        return Objects.equals(lunchDay, that.lunchDay) &&
                Objects.equals(food, that.food);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lunchDay, food);
    }
}
