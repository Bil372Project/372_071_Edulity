import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table( name = "School" )
public class School implements Serializable {

    @Column(name = "SCHOOL_TYPE")
    private String type;
    @Id
    @Column(name = "NAME", unique = true, nullable = false)
    private String name;

    @Column(name = "SCHOOL_ADDRESS")
    private String address;

    public School(){

    }
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