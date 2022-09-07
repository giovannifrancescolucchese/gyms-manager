package it.euris.gymsmanager.service.frequentation;

import it.euris.gymsmanager.entity.Customer;
import it.euris.gymsmanager.entity.Frequentation;

import java.util.List;
import java.util.Optional;

public interface FrequentationService {

    List<Frequentation> getAll();

    Optional<Frequentation> getById(Long id);

    Frequentation create(Frequentation frequentation);

    Frequentation updateById(Long id, Frequentation frequentation);

    void deleteById(Long id);

    void deleteAllInBatch();


}
