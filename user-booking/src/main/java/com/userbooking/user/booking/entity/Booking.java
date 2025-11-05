package com.userbooking.user.booking.entity;

import com.userbooking.user.booking.dto.UserDetails;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private UserInfo userInfo;
    @NotNull
    @NotEmpty
    private String trainNumber;
    @NotNull
    @NotEmpty
    private String coach;
    @NotNull
    @NotEmpty
    private String trainName;
    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date journeyDate;
    @NotEmpty(message = "From place is required")
    private String fromjourney;
    @NotEmpty(message = "To place is required")
    private String endjourney;

    private String PNR ;
    public long getId() {
        return id;
    }

    public String getPNR() {
        return PNR;
    }

    public void setPNR(String PNR) {
        this.PNR =  PNR;
    }
    @PrePersist
    public void generatePNR(){
        this.PNR=UUID.randomUUID().toString();
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public Date getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(Date journeyDate) {
        this.journeyDate = journeyDate;
    }

    public String getFromjourney() {
        return fromjourney;
    }

    public void setFromjourney(String fromjourney) {
        this.fromjourney = fromjourney;
    }

    public String getEndjourney() {
        return endjourney;
    }

    public void setEndjourney(String endjourney) {
        this.endjourney = endjourney;
    }
}
