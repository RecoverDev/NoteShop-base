package com.noteshop.base.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "basket")
public class Basket {

    @Id
    @Column(columnDefinition = "serial")
    private Integer id;

    private Integer id_user;

    private Integer id_notebook;
    @ManyToOne
    private Notebook notebook;

    private Integer count;

    private Integer status;

}
