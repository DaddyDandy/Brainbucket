package com.base.web.bean.pages;

import com.base.web.bean.PageBean;
import com.base.web.commons.helpers.ResourceHelper;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.IOException;

/**
 * Created by Cooper on 29.03.2015.
 */
@ManagedBean(name = "loginBean")
@ViewScoped
public class LoginBean extends PageBean {

    private String email;

    private String password;

    @Override
    protected void onConstruct() {

    }

    @Override
    public String getPageTitle() {
        return ResourceHelper.getValue("titleLogin");
    }

    public void signIn() throws IOException {


        goTo("/");
    }

    public void signUp() throws IOException {


        goTo("/");
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
}
