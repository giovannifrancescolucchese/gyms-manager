package it.euris.gymsmanager.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    Owner owner;

    @ManyToOne
    @JoinColumn(name = "gym_id")
    Gym gym;

}