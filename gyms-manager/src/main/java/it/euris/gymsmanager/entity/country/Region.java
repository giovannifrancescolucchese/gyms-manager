package it.euris.gymsmanager.entity.country;

import javax.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "region")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name="value")
    private String value;

    @Column(name="description")
    private String description;

    @OneToMany(mappedBy="region")
    private List<Province> province;

}