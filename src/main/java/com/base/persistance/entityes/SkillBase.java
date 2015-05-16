package com.base.persistance.entityes;

import com.base.persistance.entityes.IndexedEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by Cooper on 17.05.2015.
 */
@MappedSuperclass
public class SkillBase  extends IndexedEntity {

    @Column(name = "profile_skill_name", unique = true)
    private String profileSkillName;

    public String getProfileSkillName() {
        return profileSkillName;
    }

    public void setProfileSkillName(String profileSkillName) {
        this.profileSkillName = profileSkillName;
    }
}
