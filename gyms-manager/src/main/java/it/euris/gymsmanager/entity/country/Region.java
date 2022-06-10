package it.euris.gymsmanager.entity.country;

import javax.persistence.*;
import lombok.Data;
import java.util.Set;

@Entity
@Data
@Table(name = "region")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy="region")
    private Set<Province> province;

}