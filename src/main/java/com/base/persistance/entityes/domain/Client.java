package com.base.persistance.entityes.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Cooper on 17.05.2015.
 */
@Entity
@Table(name = "clients")
public class Client extends User {

    @OneToOne(mappedBy = "client")
    private Profile profile;

    @OneToOne(mappedBy = "client")
    private Company company;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
