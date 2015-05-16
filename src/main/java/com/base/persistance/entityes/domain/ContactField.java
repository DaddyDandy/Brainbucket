package com.base.persistance.entityes.domain;

import com.base.persistance.entityes.NamedEntity;
import com.base.web.enums.ContactFieldType;

import javax.persistence.*;

/**
 * Created by Cooper on 17.05.2015.
 */
@Entity
@Table(name = "contact_fields")
public class ContactField extends NamedEntity {

    @Enumerated(value = EnumType.STRING)
    @Column(name = "contact_field_type")
    private ContactFieldType contactFieldType;

    @ManyToOne(fetch = FetchType.LAZY)
    private Profile profile;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @Column(name = "contact_field_body")
    private String contactFiledBody;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getContactFiledBody() {
        return contactFiledBody;
    }

    public void setContactFiledBody(String contactFiledBody) {
        this.contactFiledBody = contactFiledBody;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public ContactFieldType getContactFieldType() {
        return contactFieldType;
    }

    public void setContactFieldType(ContactFieldType contactFieldType) {
        this.contactFieldType = contactFieldType;
    }
}
