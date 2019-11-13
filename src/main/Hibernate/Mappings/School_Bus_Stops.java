package main.Hibernate.Mappings;

public class School_Bus_Stops {
    private int school_bus_id;
    private String stop;

    public School_Bus_Stops(int school_bus_id, String stop) {
        this.school_bus_id = school_bus_id;
        this.stop = stop;
    }

    public int getSchool_bus_id() {
        return school_bus_id;
    }

    public void setSchool_bus_id(int school_bus_id) {
        this.school_bus_id = school_bus_id;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }
}
