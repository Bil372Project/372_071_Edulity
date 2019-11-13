package main.Hibernate.Mappings;

import java.util.Date;

public class Schedule_Consists_Of {
    private String schedule_id;
    private String course_name;
    private Date start_date;
    private Date end_date;

    public Schedule_Consists_Of(String schedule_id, String course_name, Date start_date, Date end_date) {
        this.schedule_id = schedule_id;
        this.course_name = course_name;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public String getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(String schedule_id) {
        this.schedule_id = schedule_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}
