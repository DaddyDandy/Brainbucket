package com.base.persistance.entityes.domain;

import com.base.persistance.entityes.IndexedEntity;
import com.base.web.enums.Gender;
import com.base.web.enums.JobStatus;
import com.base.web.enums.Location;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Cooper on 17.05.2015.
 */
@Entity
@Table(name = "profiles")
public class Profile extends IndexedEntity {

    @OneToOne(fetch = FetchType.LAZY)
    private Client client;

    @OneToMany(mappedBy = "profile")
    private List<SkillClient> skillClients;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "gender")
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "location")
    @Enumerated(value = EnumType.STRING)
    private Location location;

    @Column(name = "job_status")
    @Enumerated(value = EnumType.STRING)
    private JobStatus jobStatus;

    @Column(name = "ready_for_remote_work")
    private Boolean readyForRemoteWork;

    @Column(name = "ready_to_move")
    private Boolean readyToMove;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "web_site")
    private String webSite;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "profile")
    private List<ContactField> contactFields;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public JobStatus getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(JobStatus jobStatus) {
        this.jobStatus = jobStatus;
    }

    public Boolean getReadyForRemoteWork() {
        return readyForRemoteWork;
    }

    public void setReadyForRemoteWork(Boolean readyForRemoteWork) {
        this.readyForRemoteWork = readyForRemoteWork;
    }

    public Boolean getReadyToMove() {
        return readyToMove;
    }

    public void setReadyToMove(Boolean readyToMove) {
        this.readyToMove = readyToMove;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ContactField> getContactFields() {
        return contactFields;
    }

    public void setContactFields(List<ContactField> contactFields) {
        this.contactFields = contactFields;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<SkillClient> getSkillClients() {
        return skillClients;
    }

    public void setSkillClients(List<SkillClient> skillClients) {
        this.skillClients = skillClients;
    }
}
