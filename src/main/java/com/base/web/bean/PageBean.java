package com.base.web.bean;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by Cooper on 28.03.2015.
 */
public abstract class PageBean implements Serializable {

    @PostConstruct
    public void init() {
        onConstruct();
    }

    public void goBack() throws IOException {

    }

    public void signup() throws IOException {
        goTo("/signup");
    }

    public void signin() throws IOException {
        goTo("/signin");
    }

    public String getPageTitle() {
        return "";
    }

    protected abstract void onConstruct();

    public void goTo(String path) throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(ec.getRequestContextPath().concat(path));
    }

    public boolean isRenderGuestLinks() {
        return true;
    }

    public boolean isRenderOptionsLinks() {
        return false;
    }

}
