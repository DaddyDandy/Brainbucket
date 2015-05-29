package com.base.persistance.entityes;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Cooper on 26.03.2015.
 */
@MappedSuperclass
public class IndexedEntity implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
