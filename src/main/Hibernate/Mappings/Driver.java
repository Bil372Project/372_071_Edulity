package main.Hibernate.Mappings;

public class Driver {
    private String id;
    private String ssn;
    private String phone_number;

    public Driver(String id, String ssn, String phone_number) {
        this.id = id;
        this.ssn = ssn;
        this.phone_number = phone_number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
