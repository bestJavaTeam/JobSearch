package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="t_job")
public class Job {

    @GeneratedValue
    @Id
    @Column(name="id")
    private int jobId;

    @Column(name="company_id")
    private int companyId;

    @Column(name="site")
    private String workPlace;

    @Column(name="number")
    private int enrolmentNumbers;

    @Column(name="pub_date")
    private Date releasedate;

    @Column(name="info")
    private String companyInfo;

    @Column(name="needexp")
    private String needExperience;

    @Column(name="needlevel")
    private String needLevel;

    @Column(name="needmajor")
    private String needMajor;

    @Column(name="contact")
    private String contact;

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public void setEnrolmentNumbers(int enrolmentNumbers) {
        this.enrolmentNumbers = enrolmentNumbers;
    }

    public void setReleasedate(Date releasedate) {
        this.releasedate = releasedate;
    }

    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    public void setNeedExperience(String needExperience) {
        this.needExperience = needExperience;
    }

    public void setNeedLevel(String needLevel) {
        this.needLevel = needLevel;
    }

    public void setNeedMajor(String needMajor) {
        this.needMajor = needMajor;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getJobId() {
        return jobId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public int getEnrolmentNumbers() {
        return enrolmentNumbers;
    }

    public Date getReleasedate() {
        return releasedate;
    }

    public String getCompanyInfo() {
        return companyInfo;
    }

    public String getNeedExperience() {
        return needExperience;
    }

    public String getNeedLevel() {
        return needLevel;
    }

    public String getNeedMajor() {
        return needMajor;
    }

    public String getContact() {
        return contact;
    }
}















