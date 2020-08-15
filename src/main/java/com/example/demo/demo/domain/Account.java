package com.example.demo.demo.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name= "app_user")
public class Account {

    @Id
    @GeneratedValue
    @Column
    private long accountID;
    private String username;
    private String email;
    private String password;
    private  int date;


    @ManyToMany
    @JoinTable (name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public Account(String username, String email, String encode, Set<String> role, int date) {
    }

    public Account(String username, String email ,String password, int date,Set<Role> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.date =date;
        this.roles= roles;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Advertisement> ads;

    public long getAccountID() {
        return accountID;
    }

    public void setAccountID(long accountID) {
        this.accountID = accountID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Advertisement> getAds() {
        return ads;
    }

    public void setAds(List<Advertisement> ads) {
        this.ads = ads;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public int getDate() { return date; }

    public void setDate(int date) { this.date = date; }

}