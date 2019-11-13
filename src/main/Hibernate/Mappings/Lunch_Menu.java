package main.Hibernate.Mappings;

import java.util.Date;

public class Lunch_Menu {
    private Date lunch_day;
    private String food;

    public Lunch_Menu(Date lunch_day, String food) {
        this.lunch_day = lunch_day;
        this.food = food;
    }

    public Date getLunch_day() {
        return lunch_day;
    }

    public void setLunch_day(Date lunch_day) {
        this.lunch_day = lunch_day;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }
}
