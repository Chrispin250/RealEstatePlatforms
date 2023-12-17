package com.example.realestateplatform.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Agent {
    @Id
    private Long id;
    public String fullNames;
    public String telephone;
    public String emailAddress;
    public String location;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date date;
    public String estate;

    public Agent() {
    }

    public Agent(Long id, String fullNames, String telephone, String emailAddress, String location, Date date, String estate) {
        this.id = id;
        this.fullNames = fullNames;
        this.telephone = telephone;
        this.emailAddress = emailAddress;
        this.location = location;
        this.date = date;
        this.estate = estate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullNames() {
        return fullNames;
    }

    public void setFullNames(String fullNames) {
        this.fullNames = fullNames;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEstate() {
        return estate;
    }

    public void setEstate(String estate) {
        this.estate = estate;
    }
}
