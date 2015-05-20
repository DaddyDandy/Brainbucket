package com.base.web.bean;

import com.base.persistance.entityes.IndexedEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.sql.Alias;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cooper on 29.03.2015.
 */
public abstract  class BaseListBean<T extends IndexedEntity> extends PageBean implements Serializable {

    private List<T> list = new ArrayList<>();

    @Override
    protected void onConstruct() {
        List<Criteria> criterias = new ArrayList<>();
        List<Alias> aliases = new ArrayList<>();
        List<Order> orders = new ArrayList<>();

        buildSearchCriteria(criterias, aliases, orders);
        initList(criterias, aliases, orders);
    }

    protected void initList(List<Criteria> criterias, List<Alias> aliases, List<Order> orders) {

    }

    protected void buildSearchCriteria(List<Criteria> criterias, List<Alias> aliases, List<Order> orders) {

    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
