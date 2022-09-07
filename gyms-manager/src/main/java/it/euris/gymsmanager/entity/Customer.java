package it.euris.gymsmanager.entity;

import javax.persistence.*;
import lombok.Data;

import java.util.Date;

/**Object Customer*/
@Entity
@Data
@Table(name = "CUSTOMER")
public class Customer {

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

    @Column(name="startdate")
    private String startdate;

    @Column(name="enddate")
    private String enddate;

    @ManyToOne
    @JoinColumn(name = "gym_id")
    private Gym gym;


}





