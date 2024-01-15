package com.noteshop.base.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Notebook")
public class Notebook {

    @Id
    @Column(columnDefinition = "serial")
    private Integer id;
    private Integer id_manufacturer;
    private String model;
    private double screen;
    private int RAM;
    private String CPU;
    private String card;
    private Integer SSD;
    private Integer HDD;
    private boolean CDROM;
    private String LAN;
    private String WIFI;
    private boolean BT;
    private String power;
    private double price;
    private String img;

    
}
