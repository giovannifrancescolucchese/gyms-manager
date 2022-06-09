package it.euris.gymsmanager.entity.manager;

import javax.persistence.*;
import it.euris.gymsmanager.entity.property.Property;
import lombok.Data;
import java.util.Set;

@Entity
@Data
@Table(name = "manager")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="fiscal_code")
    private String fiscal_code;

    @Column(name="phone")
    private String phone;

    @Column(name="email")
    private String email;

    @OneToMany(mappedBy = "manager")
    Set<Property> property;

    /**@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gym_id")
    private Gym gym;*/

}
