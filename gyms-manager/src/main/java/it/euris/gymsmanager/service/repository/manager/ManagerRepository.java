package it.euris.gymsmanager.service.repository.manager;


import it.euris.gymsmanager.entity.manager.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPARepository che mette a disposizione i metodi per poter effettuare le operazioni CRUD sul DBMS
 */
@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

}

