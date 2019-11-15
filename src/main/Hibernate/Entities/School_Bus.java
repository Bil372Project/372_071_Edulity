package main.Hibernate.Entities;

public class School_Bus {
    private int id;
    private String driver_id;
    private String license_plate;
    private String destination;
    private int capacity;
    private String school_name;

    public School_Bus(int id, String driver_id, String license_plate, String destination, int capacity, String school_name) {
        this.id = id;
        this.driver_id = driver_id;
        this.license_plate = license_plate;
        this.destination = destination;
        this.capacity = capacity;
        this.school_name = school_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(String driver_id) {
        this.driver_id = driver_id;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }
}
