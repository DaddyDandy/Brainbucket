package com.base.persistance.entityes.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Cooper on 17.05.2015.
 */
@Entity
@Table(name = "admins")
public class Admin extends User {

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
