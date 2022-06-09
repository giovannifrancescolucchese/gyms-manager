package it.euris.gymsmanager.entity.gym;

import javax.persistence.*;
import it.euris.gymsmanager.entity.property.Property;
import it.euris.gymsmanager.entity.subscription.Subscription;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

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
  @GenericGenerator( name = "uuid2", strategy = "uuid2" )
  @Column(name = "gym_id", updatable = false, nullable = false, columnDefinition = "BINARY(16)")
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
