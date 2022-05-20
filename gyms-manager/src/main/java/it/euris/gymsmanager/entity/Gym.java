package it.euris.gymsmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

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

}
