package com.base.web.bean;

import com.base.persistance.HibernateUtil;
import com.base.persistance.entityes.IndexedEntity;
import com.base.persistance.entityes.domain.Client;
import com.base.persistance.entityes.domain.Profile;
import com.base.persistance.entityes.domain.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.lang.reflect.ParameterizedType;

/**
 * Created by Cooper on 29.03.2015.
 */
public abstract class BaseEntityEditBean<T extends IndexedEntity> extends PageBean {

    protected T entity;

    private boolean validationFailed;

    @Override
    protected void onConstruct() {
        onLoad();
    }

    public abstract void onLoad();

    public abstract void onValidate();

    public abstract void onSave();

    public void doSave() {
        onValidate();
        if (!validationFailed) {
            onSave();
        }
    }

    public void save() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void delete() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void update() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public boolean isValidationFailed() {
        return validationFailed;
    }

    public void setValidationFailed(boolean validationFailed) {
        this.validationFailed = validationFailed;
    }
}
