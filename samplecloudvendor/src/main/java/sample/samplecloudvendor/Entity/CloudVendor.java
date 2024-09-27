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
    private String vendorName;
    private String vendorCode;
    private String region;
    private String cost;
    public CloudVendor() {
    }

    public CloudVendor(int id, String vendorName, String vendorCode, String region, String cost) {
        this.id = id;
        this.vendorName = vendorName;
        this.vendorCode = vendorCode;
        this.region = region;
        this.cost = cost;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "CloudVendor{" +
                "id=" + id +
                ", vendorName='" + vendorName + '\'' +
                ", vednorCode='" + vendorCode + '\'' +
                ", region='" + region + '\'' +
                ", cost='" + cost + '\'' +
                '}';
    }
}
