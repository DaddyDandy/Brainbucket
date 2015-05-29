package com.base.web.bean.pages.vacancies;

import com.base.persistance.HibernateUtil;
import com.base.persistance.entityes.domain.Vacancy;
import com.base.web.bean.PageBean;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Cooper on 19.05.2015.
 */
@ManagedBean(name = "vacancyViewBean")
@ViewScoped
public class VacancyViewBean extends PageBean{

    private Long editId;

    private Vacancy vacancy;

    @Override
    protected void onConstruct() {
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        editId = Long.parseLong(request.getParameter("id"));

        if (editId != null && editId > 0) {
            Criteria criteria = HibernateUtil.createCriteria(Vacancy.class);
            criteria.add(Restrictions.eq("id", editId));
            vacancy = (Vacancy)criteria.uniqueResult();
        }
    }

    @Override
    public void goBack() throws IOException {
        goTo("/");
    }

    public void edit() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("edit_id", getEditId());
        goTo("/vacancies/" + getEditId() + "/edit");
    }

    public Long getEditId() {
        return editId;
    }

    public void setEditId(Long editId) {
        this.editId = editId;
    }

    public Vacancy getVacancy() {
        return vacancy;
    }

    public void setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
    }
}
