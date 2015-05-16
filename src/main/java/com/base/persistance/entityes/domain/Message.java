package com.base.persistance.entityes.domain;

import com.base.persistance.entityes.IndexedEntity;

import javax.persistence.*;

/**
 * Created by Cooper on 17.05.2015.
 */
@Entity
@Table(name = "messages")
public class Message extends IndexedEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    Client sender;

    Long receiver;

    public Client getSender() {
        return sender;
    }

    public void setSender(Client sender) {
        this.sender = sender;
    }

    public Long getReceiver() {
        return receiver;
    }

    public void setReceiver(Long receiver) {
        this.receiver = receiver;
    }

}
