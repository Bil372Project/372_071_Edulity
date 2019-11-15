package main.Hibernate.Entities;

public class Have_Schedule {
    private int class_section;
    private String Schedule_id;

    public Have_Schedule(int class_section, String schedule_id) {
        this.class_section = class_section;
        Schedule_id = schedule_id;
    }

    public int getClass_section() {
        return class_section;
    }

    public void setClass_section(int class_section) {
        this.class_section = class_section;
    }

    public String getSchedule_id() {
        return Schedule_id;
    }

    public void setSchedule_id(String schedule_id) {
        Schedule_id = schedule_id;
    }
}
