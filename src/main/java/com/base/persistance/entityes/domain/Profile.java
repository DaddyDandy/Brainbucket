package com.base.persistance.entityes.domain;

import com.base.persistance.entityes.IndexedEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Cooper on 17.05.2015.
 */
@Entity
@Table(name = "profiles")
public class Profile extends IndexedEntity {

    @OneToOne(fetch = FetchType.LAZY)
    Client client;

    @OneToMany(mappedBy = "profile")
    List<ProfileSkill> profileSkills;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<ProfileSkill> getProfileSkills() {
        return profileSkills;
    }

    public void setProfileSkills(List<ProfileSkill> profileSkills) {
        this.profileSkills = profileSkills;
    }
}
