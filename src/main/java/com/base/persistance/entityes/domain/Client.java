package com.base.persistance.entityes.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Cooper on 17.05.2015.
 */
@Entity
@Table(name = "clients")
public class Client extends User {

    @OneToMany(mappedBy = "client")
    List<Message> messages;

    @OneToOne(mappedBy = "client")
    Profile profile;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
