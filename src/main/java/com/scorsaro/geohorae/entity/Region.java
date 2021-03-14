package com.scorsaro.geohorae.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "region")
@Data
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
