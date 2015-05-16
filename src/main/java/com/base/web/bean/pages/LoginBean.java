package com.base.web.bean.pages;

import com.base.web.bean.PageBean;
import com.base.web.commons.helpers.ResourceHelper;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Created by Cooper on 29.03.2015.
 */
@ManagedBean(name = "registrationBean")
@ViewScoped
public class LoginBean extends PageBean{

    @Override
    protected void onConstruct() {

    }

    @Override
    public String getPageTitle() {
        return ResourceHelper.getValue("titleLogin");
    }
}
