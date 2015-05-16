package com.base.persistance.entityes.domain;

import com.base.persistance.entityes.IndexedEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Cooper on 17.05.2015.
 */
@Entity
@Table(name = "messages")
public class Message extends IndexedEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(name = "receiver_id")
    private Long receiverId;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

    @Column(name = "send_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sendDate;

    @Column(name = "review_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rewievDate;

    @Column(name = "can_reply")
    private Boolean canReply;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Date getRewievDate() {
        return rewievDate;
    }

    public void setRewievDate(Date rewievDate) {
        this.rewievDate = rewievDate;
    }

    public Boolean getCanReply() {
        return canReply;
    }

    public void setCanReply(Boolean canReply) {
        this.canReply = canReply;
    }
}
