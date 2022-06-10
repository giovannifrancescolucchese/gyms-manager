package it.euris.gymsmanager.entity.country;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "province")
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name="region_id", nullable=false)
    private Region region;

}
