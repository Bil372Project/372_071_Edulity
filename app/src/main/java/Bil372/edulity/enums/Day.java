package Bil372.edulity.enums;

import java.util.HashMap;
import java.util.Map;

public enum Day {
    MON(0),
    TUE(1),
    WED(2),
    THU(3),
    FRI(4);

    private int value;
    private static Map map = new HashMap<>();


    private Day(int value) {
        this.value = value;
    }

    static {
        for (Day day : Day.values()) {
            map.put(day.value, day);
        }
    }

    public static Day valueOf(int day) {
        return (Day) map.get(day);
    }


    public int getValue() {
        return value;
    }
}
