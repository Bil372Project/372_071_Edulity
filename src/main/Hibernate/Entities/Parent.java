package main.Hibernate.Entities;

public class Parent {
    private String ssn;
    private String name;
    private String phone_number;
    private String address;
    private String e_mail;

    public Parent(String ssn, String name, String phone_number, String address, String e_mail) {
        this.ssn = ssn;
        this.name = name;
        this.phone_number = phone_number;
        this.address = address;
        this.e_mail = e_mail;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }
}
