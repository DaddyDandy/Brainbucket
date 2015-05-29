package com.base.web.bean.pages.vacancies;

import com.base.persistance.HibernateUtil;
import com.base.persistance.entityes.domain.Vacancy;
import com.base.web.bean.BaseListBean;
import com.base.web.bean.PageBean;
import com.base.web.commons.helpers.ResourceHelper;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.Alias;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cooper on 28.03.2015.
 */
@ManagedBean(name = "vacanciesBean")
@ViewScoped
public class VacanciesBean extends BaseListBean<Vacancy> {

    List<Vacancy> vacancies = new ArrayList<>();

    Long selectedVacancy;

    @Override
    protected void onConstruct() {
        Criteria criteria = HibernateUtil.createCriteria(Vacancy.class);
        vacancies = criteria.list();
    }

    @Override
    protected void buildSearchCriteria(List<Criteria> criterias, List<Alias> aliases, List<Order> orders) {

    }

    public void viewVacancy() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("edit_id", getSelectedVacancy());
        goTo("/vacancies/" + getSelectedVacancy());
    }

    public void createVacancy() throws IOException {
        goTo("/vacancies/new");
    }

    @Override
    public String getPageTitle() {
        return ResourceHelper.getValue("titleVacancies");
    }

    public List<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(List<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }

    public Long getSelectedVacancy() {
        return selectedVacancy;
    }

    public void setSelectedVacancy(Long selectedVacancy) {
        this.selectedVacancy = selectedVacancy;
    }
}
