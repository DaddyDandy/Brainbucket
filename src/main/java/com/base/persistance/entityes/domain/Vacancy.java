package com.base.persistance.entityes.domain;

import com.base.persistance.entityes.NamedEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Cooper on 29.03.2015.
 */
@Entity
@Table(name = "vacancy")
public class Vacancy extends NamedEntity {
}
