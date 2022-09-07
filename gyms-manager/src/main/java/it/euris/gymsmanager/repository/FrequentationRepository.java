package it.euris.gymsmanager.repository;

import it.euris.gymsmanager.entity.Customer;
import it.euris.gymsmanager.entity.Frequentation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FrequentationRepository  extends JpaRepository<Frequentation, Long> {
}
