package com.base.web.bean.pages;

import com.base.persistance.entityes.domain.Vacancy;
import com.base.web.bean.BaseListBean;
import com.base.web.bean.PageBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Created by Cooper on 28.03.2015.
 */
@ManagedBean(name = "vacanciesBean")
@ViewScoped
public class VacanciesBean extends BaseListBean<Vacancy> {

    @Override
    protected void onConstruct() {

    }

    @Override
    protected void buildSearchCriteria() {

    }
}
