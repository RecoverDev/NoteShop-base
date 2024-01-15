package com.noteshop.base.models;


import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "manufacturer")
public class Manufacturer {

    @Id
    @Column(columnDefinition = "serial")
    private Integer id;
    private String name;

}
