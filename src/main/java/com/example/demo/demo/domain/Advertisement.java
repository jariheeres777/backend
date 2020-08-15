package com.example.demo.demo.domain;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;


@Entity
public class Advertisement {
    @Id
    @GeneratedValue
    private long adID;
    private String adname;
    private int pricead;
    private String adtext;
    private String adPictures;


    public Advertisement() {
    }

    public Advertisement(String adname) {
        this.adID = adID;
        this.adname = adname;
        this.pricead = pricead;
        this.adtext = adtext;
        this.adPictures = adPictures;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("ads")
    private Account user;

    public String getAdname() {
        return adname;
    }

    public void setAdname(String adname) {
        this.adname = adname;
    }

    public int getPricead() {
        return pricead;
    }

    public void setPricead(int pricead) {
        this.pricead = pricead;
    }

    public String getAdtext() {
        return adtext;
    }

    public void setAdtext(String adtext) {
        this.adtext = adtext;
    }

    public long getAdID() {
        return adID;
    }

    public void setAdID(long adID) {
        this.adID = adID;
    }

    public Account getUser() {
        return user;
    }

    public String getAdPictures() {
        return adPictures;
    }

    public void setAdPictures(String adPictures) {
        this.adPictures = adPictures;
    }

    public void setUser(Account user) {
        this.user = user;
    }


}
