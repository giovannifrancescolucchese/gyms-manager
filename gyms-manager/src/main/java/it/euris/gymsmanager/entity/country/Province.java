package it.euris.gymsmanager.entity.country;

import javax.persistence.*;
import lombok.Data;

/**Object Province*/
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
