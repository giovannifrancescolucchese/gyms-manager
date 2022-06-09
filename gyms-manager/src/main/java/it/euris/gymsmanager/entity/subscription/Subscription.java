package it.euris.gymsmanager.entity.subscription;

import it.euris.gymsmanager.entity.client.Client;
import it.euris.gymsmanager.entity.gym.Gym;
import it.euris.gymsmanager.entity.manager.Manager;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "subscription")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "gym_id")
    Gym gym;

    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;
}
