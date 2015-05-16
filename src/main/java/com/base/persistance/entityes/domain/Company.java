package com.base.persistance.entityes.domain;

import com.base.persistance.entityes.NamedEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Cooper on 17.05.2015.
 */
@Entity
@Table(name = "companies")
public class Company extends NamedEntity {
}
