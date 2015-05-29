package com.base.web.bean.pages.vacancies;

import com.base.persistance.HibernateUtil;
import com.base.persistance.entityes.domain.Vacancy;
import com.base.web.bean.BaseEntityEditBean;
import com.base.web.enums.JobTimeType;
import com.base.web.enums.Location;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cooper on 19.05.2015.
 */
@ManagedBean(name = "vacancyEditBean")
@ViewScoped
public class VacancyEditBean extends BaseEntityEditBean<Vacancy> {

    List<SelectItem> locations;

    private Location location;

    List<SelectItem> jobTimeTypes;

    private JobTimeType jobTimeType;

    private String generalRequirements;

    private String bonuses;

    private String name;

    private Long editId;

    private boolean newEntity;

    @Override
    public void onLoad() {
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        editId = Long.parseLong(request.getParameter("id"));

        if (editId != null && editId > 0) {
            Session session = HibernateUtil.getSessionFactory().openSession();

            Criteria criteria = session.createCriteria(Vacancy.class);
            criteria.add(Restrictions.eq("id", editId));
            entity = (Vacancy) criteria.uniqueResult();
            session.close();
            name = entity.getName();
            bonuses = entity.getBonuses();
            generalRequirements = entity.getGeneralRequirements();
            setNewEntity(false);
        } else {
            setNewEntity(true);
            entity = new Vacancy();
        }
        jobTimeTypes = new ArrayList<>();
        for (JobTimeType type : JobTimeType.values()) {
            jobTimeTypes.add(new SelectItem(type, type.name()));
        }
        locations = new ArrayList<>();
        for (Location loc : Location.values()) {
            locations.add(new SelectItem(loc, loc.name()));
        }
    }

    @Override
    public void onValidate() {
        setValidationFailed(false);
        if (getName() == null || getName().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage("vacancyName", new FacesMessage(FacesMessage.SEVERITY_ERROR, "'Name' is required field", ""));
            setValidationFailed(true);
        }
        if (getGeneralRequirements() == null || getGeneralRequirements().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage("vacancyGR", new FacesMessage(FacesMessage.SEVERITY_ERROR, "'General requirements' is required field", ""));
            setValidationFailed(true);
        }
    }

    @Override
    public void onSave() {
        entity.setName(getName());
        entity.setBonuses(getBonuses());
        entity.setCompany(null);
        entity.setGeneralRequirements(getGeneralRequirements());
        entity.setJobTimeType(getJobTimeType());
        entity.setLocation(getLocation());

        if (isNewEntity()) {
            save();
        } else {
            update();
        }
        try {
            if (!isNewEntity()) {
                goTo("/vacancies/" + editId);
            } else {
                goTo("/vacancies/");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cancel() throws IOException {
        if (!isNewEntity()) {
            goTo("/vacancies/" + editId);
        } else {
            goTo("/vacancies/");
        }
    }

    public Long getEditId() {
        return editId;
    }

    public void setEditId(Long editId) {
        this.editId = editId;
    }

    public List<SelectItem> getLocations() {
        return locations;
    }

    public void setLocations(List<SelectItem> locations) {
        this.locations = locations;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<SelectItem> getJobTimeTypes() {
        return jobTimeTypes;
    }

    public void setJobTimeTypes(List<SelectItem> jobTimeTypes) {
        this.jobTimeTypes = jobTimeTypes;
    }

    public JobTimeType getJobTimeType() {
        return jobTimeType;
    }

    public void setJobTimeType(JobTimeType jobTimeType) {
        this.jobTimeType = jobTimeType;
    }

    public String getGeneralRequirements() {
        return generalRequirements;
    }

    public void setGeneralRequirements(String generalRequirements) {
        this.generalRequirements = generalRequirements;
    }

    public String getBonuses() {
        return bonuses;
    }

    public void setBonuses(String bonuses) {
        this.bonuses = bonuses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNewEntity() {
        return newEntity;
    }

    public void setNewEntity(boolean newEntity) {
        this.newEntity = newEntity;
    }
}
