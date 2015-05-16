package com.base.persistance.entityes.domain;

import com.base.persistance.entityes.NamedEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Cooper on 17.05.2015.
 */
@Entity
@Table(name = "companies")
public class Company extends NamedEntity {

    @OneToOne(fetch = FetchType.LAZY)
    private Client client;

    @OneToMany(mappedBy = "company")
    private List<Vacancy> vacancies;

    @Column(name = "company_rate")
    private Integer companyRate;

    @Column(name = "company_description")
    private String companyDescription;

    @OneToMany(mappedBy = "company")
    private List<ContactField> contactFields;

    @Column(name = "staff_count")
    private Integer staffCount;

    public Integer getStaffCount() {
        return staffCount;
    }

    public void setStaffCount(Integer staffCount) {
        this.staffCount = staffCount;
    }

    public List<ContactField> getContactFields() {
        return contactFields;
    }

    public void setContactFields(List<ContactField> contactFields) {
        this.contactFields = contactFields;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public Integer getCompanyRate() {
        return companyRate;
    }

    public void setCompanyRate(Integer companyRate) {
        this.companyRate = companyRate;
    }

    public List<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(List<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
