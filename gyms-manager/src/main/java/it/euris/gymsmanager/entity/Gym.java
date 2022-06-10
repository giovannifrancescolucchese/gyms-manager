package it.euris.gymsmanager.entity;

import javax.persistence.*;
import lombok.Data;
import java.util.Set;

/**
 * L'entita vera e propria sulla quale verrano eseguite le operazioni CRUD.
 * Viene utilizzato Lombok per evitare di scrivere costruttori e emetodi get e set
 */
@Entity
@Data
@Table(name = "gym")
public class Gym {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @Column(name="name")
  private String name;

  @Column(name="address")
  private String address;

  @Column(name="description")
  private String description;

  @Column(name="year_of_construction")
  private Long constructionYear;

  @Column(name="website")
  private String website;

  @Column(name="email")
  private String email;

  @Column(name="phone")
  private String phone;

  @Column(name="review")
  private String review;

  @OneToMany(mappedBy = "gym")
  Set<Property> property;

  @OneToMany(mappedBy = "gym")
  Set<Subscription> subscription;

  /**@OneToMany(mappedBy="gym")
  private Set<Client> client;*/

  /**@OneToOne(mappedBy = "gym", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
  private Manager mng;*/

}