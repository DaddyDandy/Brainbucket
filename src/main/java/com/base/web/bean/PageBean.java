package com.base.web.bean;

import javax.annotation.PostConstruct;
import java.io.Serializable;

/**
 * Created by Cooper on 28.03.2015.
 */
public abstract class PageBean implements Serializable {

    @PostConstruct
    public void init() {
        onConstruct();
    }

    public void goBack() {

    }

    public String getPageTitle() {
        return "";
    }

    protected abstract void onConstruct();
}
