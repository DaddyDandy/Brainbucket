package com.base.web.bean.pages;

import com.base.persistance.entityes.domain.User;
import com.base.web.bean.BaseEntityEditBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Created by Cooper on 29.03.2015.
 */
@ManagedBean(name = "registrationBean")
@ViewScoped
public class RegistrationBean extends BaseEntityEditBean<User> {

    private String email;

    private String password;

    private String firstName;

    private String secondName;

    public RegistrationBean() {
        entity = new User();
    }

    @Override
    public void onLoad() {

    }

    @Override
    public void onValidate() {

    }

    @Override
    public void onSave() {
        initUser();

        super.onSave();
    }

    private void initUser() {
        entity.setLogin(email);
        entity.setPassword(password);
        entity.setFirstName(firstName);
        entity.setSecondName(secondName);
    }

    public void saveUser() {
        onSave();
    }

    public void cancel() {
        goBack();
    }

    @Override
    public void goBack() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
}
