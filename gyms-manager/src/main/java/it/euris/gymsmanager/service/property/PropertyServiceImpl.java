package it.euris.gymsmanager.service.property;

import java.util.List;
import java.util.Optional;
import it.euris.gymsmanager.entity.property.Property;
import it.euris.gymsmanager.service.repository.property.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementazione della classe di servizio
 */

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    PropertyRepository propertyRepository;

    /**
     * Ottiene la lista di tutti gi impianti sportivi
     *
     * @return lista di oggett Gym
     */
    @Override
    public List<Property> getAll() {
        return propertyRepository.findAll();
    }

    /**
     * Ottiene l'ggetto Gym con quel particolare Id
     *
     * @param id l'identificativo dell'ggetto che si vuole ottenere
     * @return l'oggetto Gym
     */
    @Override
    public Optional<Property> getById(Long id) {
        return propertyRepository.findById(id);
    }

    /**
     * Crea l'entità Gym
     *
     * @param property il payload che rappresenta la nuova struttura sportiva
     * @return la nuova struttura sportiva appena creata
     */
    @Override
    public Property create(Property property) {
        return propertyRepository.save(property);
    }

    /**
     * Aggiorna la palestra con quel particolare identificativo
     *
     * @param id l'identificativo della palestra da aggiornare
     * @param property il payload che andrà a sovrascrivere i dati di quella particolare entità
     * @return la palestra aggiornata
     */
    @Override
    public Property updateById(Long id, Property property) {
        property.setId(id);
        return propertyRepository.save(property);
    }

    /**
     * Cancella l'entità con quel particolare identificativo
     *
     * @param id l'identificativo che individua la palestra da cancellare
     */
    @Override
    public void deleteById(Long id) {
        propertyRepository.deleteById(id);
    }

}
