package com.base.persistance.entityes.domain;

import com.base.persistance.entityes.IndexedEntity;

import javax.persistence.*;

/**
 * Created by Cooper on 17.05.2015.
 */
@Entity
@Table(name = "job_skills")
public class SkillClient extends SkillBase {

    @ManyToOne(fetch = FetchType.LAZY)
    private Profile profile;

    @Column(name = "skill_rate")
    private Integer skillRate;

    public Integer getSkillRate() {
        return skillRate;
    }

    public void setSkillRate(Integer skillRate) {
        this.skillRate = skillRate;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
