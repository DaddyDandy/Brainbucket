package com.base.persistance.entityes.domain;

import com.base.persistance.entityes.IndexedEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by Cooper on 17.05.2015.
 */
@Entity
@Table(name = "profile_skills")
public class ProfileSkill extends IndexedEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    Profile profile;

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
