package it.euris.gymsmanager.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import java.util.Set;

@Entity
@Data
@Table(name = "owner")
public class Owner {

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

    @OneToOne(mappedBy = "owner")
    @JsonIgnore
    private Gym gym;

    /**@OneToMany(mappedBy = "owner")
    Set<Property> property;*/

}
