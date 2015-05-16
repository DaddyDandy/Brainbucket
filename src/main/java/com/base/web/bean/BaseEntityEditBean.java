package com.base.web.bean;

import com.base.persistance.HibernateUtil;
import com.base.persistance.entityes.IndexedEntity;
import org.hibernate.Session;

import java.lang.reflect.ParameterizedType;

/**
 * Created by Cooper on 29.03.2015.
 */
public abstract class BaseEntityEditBean<T extends IndexedEntity> extends PageBean {

    protected T entity;

    public BaseEntityEditBean() {

    }

    @Override
    protected void onConstruct() {
        onLoad();
    }

    public abstract void onLoad();

    public abstract void onValidate();

    public void onSave() {
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

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }
}
