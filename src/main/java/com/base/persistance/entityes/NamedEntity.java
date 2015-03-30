package com.base.persistance.entityes;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by Cooper on 28.03.2015.
 */
@MappedSuperclass
public class NamedEntity extends IndexedEntity {

    @Column
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
