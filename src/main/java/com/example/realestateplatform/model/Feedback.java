package com.example.realestateplatform.model;


import javax.persistence.*;

@Entity
public class Feedback {

    public String nnames;
    @Id
    public String emails;
    public String suggestion;

    public Feedback() {
    }

    public Feedback(String nnames, String emails, String suggestion) {
        this.nnames = nnames;
        this.emails = emails;
        this.suggestion = suggestion;
    }

    public String getNnames() {
        return nnames;
    }

    public void setNnames(String nnames) {
        this.nnames = nnames;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }
}
