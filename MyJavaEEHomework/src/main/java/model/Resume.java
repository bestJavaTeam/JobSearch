package model;

import javax.persistence.*;

@Entity
@Table(name="t_resume")
public class Resume {
    @GeneratedValue
    @Id
    @Column(name="id")
    private int resumeId;

    @Column(name="user_id")
    private int userId;

    @Column(name="undergo")
    private String workExperience;

    @Column(name="project")
    private String projectExperience;

    @Column(name="education")
    private String educationalStatus;

    @Column(name="other")
    private String other;

    @Column(name="name")
    private String resumeName;










}














