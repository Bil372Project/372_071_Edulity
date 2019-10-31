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
        for (Day pageType : Day.values()) {
            map.put(pageType.value, pageType);
        }
    }

    public static Day valueOf(int pageType) {
        return (Day) map.get(pageType);
    }


    public int getValue() {
        return value;
    }

}
