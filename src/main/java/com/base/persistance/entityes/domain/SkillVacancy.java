package com.base.persistance.entityes.domain;

import com.base.persistance.entityes.SkillBase;

import javax.persistence.*;

/**
 * Created by Cooper on 17.05.2015.
 */
@Entity
@Table(name = "skill_vacancies")
public class SkillVacancy extends SkillBase {

    @ManyToOne(fetch = FetchType.LAZY)
    private Vacancy vacancy;

    public Vacancy getVacancy() {
        return vacancy;
    }

    public void setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
    }
}
