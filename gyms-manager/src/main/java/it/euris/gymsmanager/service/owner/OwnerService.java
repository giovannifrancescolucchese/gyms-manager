package it.euris.gymsmanager.service.owner;

import it.euris.gymsmanager.entity.Owner;
import java.util.List;
import java.util.Optional;

public interface OwnerService {

    List<Owner> getAll();
    Optional<Owner> getById(Long id);
    Owner create(Owner mng);
    Owner updateById(Long id, Owner mng);
    void deleteById(Long id);
    void deleteAllInBatch();

}
