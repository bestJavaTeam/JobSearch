package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="t_user")
public class User {
    @GeneratedValue
    @Id
    @Column(name="id")
    private int userId;

    @Column(name="name")
    private String userName;

    @Column(name="birth")
    private Date birth;

    @Column(name="exp")
    private String workExperience;

    @Column(name="location")
    private String userLocation;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public Date getBirth() {
        return birth;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", birth=" + birth +
                ", workExperience='" + workExperience + '\'' +
                ", userLocation='" + userLocation + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}




























