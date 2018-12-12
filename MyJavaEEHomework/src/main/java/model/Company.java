package model;

import javax.persistence.*;

@Entity
@Table(name="t_company")
public class Company {
    @GeneratedValue
    @Id
    @Column(name="id")
    private int companyId;

    @Column(name="name")
    private String companyName;

    @Column(name="location")
    private String companyLocation;

    @Column(name="contact")
    private String companyContact;

    @Column(name="scale")
    private String companyScale;

    @Column(name="type")
    private String companyType;

    @Column(name="info")
    private String companyInfo;

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    public void setCompanyContact(String companyContact) {
        this.companyContact = companyContact;
    }

    public void setCompanyScale(String companyScale) {
        this.companyScale = companyScale;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    public int getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public String getCompanyContact() {
        return companyContact;
    }

    public String getCompanyScale() {
        return companyScale;
    }

    public String getCompanyType() {
        return companyType;
    }

    public String getCompanyInfo() {
        return companyInfo;
    }
}














