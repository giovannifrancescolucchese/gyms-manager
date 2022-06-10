package it.euris.gymsmanager.service.property;

import it.euris.gymsmanager.entity.Property;
import java.util.List;
import java.util.Optional;

public interface PropertyService {

    List<Property> getAll();
    Optional<Property> getById(Long id);
    Property create(Property property);
    Property updateById(Long id, Property property);
    void deleteById(Long id);

}

