package it.euris.gymsmanager.repository.property;

import it.euris.gymsmanager.entity.property.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPARepository che mette a disposizione i metodi per poter effettuare le operazioni CRUD sul DBMS
 */
@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

}

