package it.euris.gymsmanager.entity.property;

import it.euris.gymsmanager.entity.client.Client;
import it.euris.gymsmanager.entity.gym.Gym;
import it.euris.gymsmanager.entity.manager.Manager;
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
    @JoinColumn(name = "manager_id")
    Manager manager;

    @ManyToOne
    @JoinColumn(name = "gym_id")
    Gym gym;

    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;

}