package com.base.web.bean.pages.vacancies;

import com.base.persistance.entityes.domain.Vacancy;
import com.base.web.bean.BaseListBean;
import com.base.web.bean.PageBean;
import com.base.web.commons.helpers.ResourceHelper;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.sql.Alias;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.IOException;
import java.util.List;

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
    protected void buildSearchCriteria(List<Criteria> criterias, List<Alias> aliases, List<Order> orders) {

    }

    public void createVacancy() throws IOException {
        goTo("/vacancies/new");
    }

    @Override
    public String getPageTitle() {
        return ResourceHelper.getValue("titleVacancies");
    }
}
