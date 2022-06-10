package it.euris.gymsmanager.repository;

import it.euris.gymsmanager.entity.Gym;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPARepository che mette a disposizione i metodi per poter effettuare le operazioni CRUD sul DBMS
 */
@Repository
public interface GymRepository extends JpaRepository<Gym, Long> {

}
