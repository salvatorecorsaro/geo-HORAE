package com.scorsaro.geohorae.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="country")
@Getter
@Setter
public class Country {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    private String code;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy="country")
    private List<Region> regions;
}
