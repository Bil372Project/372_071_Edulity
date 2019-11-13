package main.Hibernate.Mappings;

import java.io.Serializable;

public class School implements Serializable {
    private String type;
    private String name;
    private String address;

    public School(String type, String name, String address) {
        this.type = type;
        this.name = name;
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
