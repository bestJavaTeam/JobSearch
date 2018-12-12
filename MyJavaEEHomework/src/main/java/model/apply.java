package model;

import javax.persistence.*;

@Entity
@Table(name="apply")
public class apply {
    @GeneratedValue
    @Id
    @Column(name="id")
    private int applyId;

    @Column(name="user_id")
    private int userId;

    @Column(name="job_id")
    private int jobId;

    public int getApplyId() {
        return applyId;
    }

    public int getUserId() {
        return userId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setApplyId(int applyId) {
        this.applyId = applyId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }
}






