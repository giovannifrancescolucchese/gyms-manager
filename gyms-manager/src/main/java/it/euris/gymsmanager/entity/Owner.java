package it.euris.gymsmanager.entity;

import javax.persistence.*;
import lombok.Data;

/**Object Owner*/
@Entity
@Data
@Table(name = "OWNER")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Column(name = "region")
    private String region;

    @Column(name = "province")
    private String province;

}
