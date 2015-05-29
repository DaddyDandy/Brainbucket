package com.base.web.bean.pages;

import com.base.persistance.entityes.domain.User;
import com.base.web.bean.BaseEntityEditBean;
import com.base.web.commons.helpers.ResourceHelper;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.IOException;

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

    @Override
    public void onLoad() {
        entity = new User();
    }

    @Override
    public void onValidate() {

    }

    @Override
    public void onSave() {
        initUser();

        super.save();
    }

    private void initUser() {
        entity.setLogin(email);
        entity.setPassword(password);
        entity.setFirstName(firstName);
        entity.setSecondName(secondName);
    }

    public void saveUser() {
        onSave();
        try {
            goBack();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cancel() throws IOException {
        goBack();
    }

    @Override
    public void goBack() throws IOException {
        goTo("/");
    }

    @Override
    public String getPageTitle() {
        return ResourceHelper.getValue("titleRegistration");
    }

    @Override
    public boolean isRenderGuestLinks() {
        return false;
    }

    @Override
    public boolean isRenderOptionsLinks() {
        return true;
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
