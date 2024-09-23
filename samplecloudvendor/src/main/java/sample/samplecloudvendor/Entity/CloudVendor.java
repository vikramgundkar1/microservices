package sample.samplecloudvendor.Entity;


import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

import javax.annotation.processing.Generated;


@Entity
@Table(name="vendor_cloud")
public class CloudVendor {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String fistName;
    private String lastName;
    private String designation;


    public CloudVendor(int id, String fistName, String lastName, String designation) {
        this.id = id;
        this.fistName = fistName;
        this.lastName = lastName;
        this.designation = designation;
    }

    public CloudVendor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "CloudVendor{" +
                "id=" + id +
                ", fistName='" + fistName + '\'' +
                ", LastName='" + lastName + '\'' +
                ", Designation='" + designation + '\'' +
                '}';
    }
}
