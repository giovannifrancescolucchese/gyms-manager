package it.euris.gymsmanager.entity.country;

import javax.persistence.*;

import it.euris.gymsmanager.entity.Gym;
import lombok.Data;

@Entity
@Data
@Table(name = "PROVINCE")
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name="value")
    private String value;

    @Column(name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

}
