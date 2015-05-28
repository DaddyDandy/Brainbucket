package com.base.persistance.entityes.domain;

import com.base.persistance.entityes.NamedEntity;
import com.base.web.enums.JobTimeType;
import com.base.web.enums.Location;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Cooper on 29.03.2015.
 */
@Entity
@Table(name = "vacancy")
public class Vacancy extends NamedEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Location location;

    @Column
    @Enumerated(value = EnumType.STRING)
    private JobTimeType jobTimeType;

    @Column
    private String bonuses;

    @Column
    private String generalRequirements;

    @OneToMany(mappedBy = "vacancy")
    private List<SkillVacancy> skillVacancies;

    @Column(name = "creationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "reviews")
    private Integer reviews;

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

    public String getBonuses() {
        return bonuses;
    }

    public void setBonuses(String bonuses) {
        this.bonuses = bonuses;
    }

    public String getGeneralRequirements() {
        return generalRequirements;
    }

    public void setGeneralRequirements(String generalRequirements) {
        this.generalRequirements = generalRequirements;
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
