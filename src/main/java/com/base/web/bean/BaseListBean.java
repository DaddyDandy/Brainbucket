package com.base.web.bean;

import com.base.persistance.entityes.IndexedEntity;

import java.io.Serializable;

/**
 * Created by Cooper on 29.03.2015.
 */
public abstract  class BaseListBean<T extends IndexedEntity> extends PageBean implements Serializable {

    @Override
    protected void onConstruct() {
        buildSearchCriteria();
        initList();
    }

    protected void initList() {

    }

    protected void buildSearchCriteria() {

    }
}
