package it.euris.gymsmanager.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "GYM")
public class Gym {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "description")
    private String description;

    @Column(name = "year_of_construction")
    private Long constructionYear;

    @Column(name = "website")
    private String website;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "review")
    private String review;

    @Column(name = "region")
    private String region;

    @Column(name = "province")
    private String province;

    @Column(name = "owner_id")
    private Long owner_id;

}