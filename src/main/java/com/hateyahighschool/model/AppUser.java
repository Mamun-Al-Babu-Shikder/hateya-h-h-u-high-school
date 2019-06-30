package com.hateyahighschool.model;


import org.hibernate.annotations.Entity;

import javax.persistence.*;

/**
 * Created by A.A.MAMUN on 4/14/2019.
 */
@javax.persistence.Entity
public class AppUser {

    @Id
    @SequenceGenerator(name="third_party_seq", sequenceName="third_party_seq",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="third_party_seq")
    private Integer id;
    private String email;
    private String password;

    public AppUser() {
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
