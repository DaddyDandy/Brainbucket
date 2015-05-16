package com.base.persistance.entityes.domain;

import com.base.persistance.entityes.NamedEntity;
import com.base.web.enums.JobTimeType;
import com.base.web.enums.Location;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Cooper on 29.03.2015.
 */
@Entity
@Table(name = "vacancy")
public class Vacancy extends NamedEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @Column(name = "location")
    @Enumerated(value = EnumType.STRING)
    private Location location;

    @Column(name = "location")
    @Enumerated(value = EnumType.STRING)
    private JobTimeType jobTimeType;

    @Column(name = "location")
    private String generalRequirements;

    @Column(name = "location")
    private String currentTasks;

    @OneToMany(mappedBy = "vacancy")
    private List<SkillVacancy> skillVacancies;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public JobTimeType getJobTimeType() {
        return jobTimeType;
    }

    public void setJobTimeType(JobTimeType jobTimeType) {
        this.jobTimeType = jobTimeType;
    }

    public String getGeneralRequirements() {
        return generalRequirements;
    }

    public void setGeneralRequirements(String generalRequirements) {
        this.generalRequirements = generalRequirements;
    }

    public String getCurrentTasks() {
        return currentTasks;
    }

    public void setCurrentTasks(String currentTasks) {
        this.currentTasks = currentTasks;
    }

    public List<SkillVacancy> getSkillVacancies() {
        return skillVacancies;
    }

    public void setSkillVacancies(List<SkillVacancy> skillVacancies) {
        this.skillVacancies = skillVacancies;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
