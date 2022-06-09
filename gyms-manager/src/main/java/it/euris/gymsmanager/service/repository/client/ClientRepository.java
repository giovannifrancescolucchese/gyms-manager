package it.euris.gymsmanager.service.repository.client;

import it.euris.gymsmanager.entity.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPARepository che mette a disposizione i metodi per poter effettuare le operazioni CRUD sul DBMS
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
