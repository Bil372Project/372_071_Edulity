package Bil372.edulity.common;

import android.widget.TableLayout;

public class DataAccessor {

    private static TableLayout scheduleTable;
    private static Schedule schedule;


    //Get database data in here
    static {
        schedule = new Schedule("8-A");
    }

    public static TableLayout getScheduleTable() {
        return scheduleTable;
    }

    public static void setScheduleTable(TableLayout scheduleTable) {
        DataAccessor.scheduleTable = scheduleTable;
    }

    public static Schedule getSchedule() {
        return schedule;
    }

    public static void setSchedule(Schedule schedule) {
        DataAccessor.schedule = schedule;
    }
}
