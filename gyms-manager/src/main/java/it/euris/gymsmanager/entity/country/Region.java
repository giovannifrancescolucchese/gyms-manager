package it.euris.gymsmanager.entity.country;

import javax.persistence.*;
import lombok.Data;

/**Object Region*/
@Entity
@Data
@Table(name = "REGION")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name="value")
    private String value;

    @Column(name="description")
    private String description;

}