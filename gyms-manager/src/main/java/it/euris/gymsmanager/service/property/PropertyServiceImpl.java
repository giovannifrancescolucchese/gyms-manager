package it.euris.gymsmanager.service.property;

import java.util.List;
import java.util.Optional;
import it.euris.gymsmanager.entity.Property;
import it.euris.gymsmanager.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    PropertyRepository propertyRepository;

    @Override
    public Property create(Property property) {
        return propertyRepository.save(property);
    }

    @Override
    public Property updateById(Long id, Property property) {
        property.setId(id);
        return propertyRepository.save(property);
    }

    @Override
    public Optional<Property> getById(Long id) {
        return propertyRepository.findById(id);
    }

    @Override
    public List<Property> getAll() {
        return propertyRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        propertyRepository.deleteById(id);
    }

    public void deleteAllInBatch(){
        propertyRepository.deleteAllInBatch();
    }

}
