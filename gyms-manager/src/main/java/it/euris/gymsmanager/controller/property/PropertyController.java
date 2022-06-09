package it.euris.gymsmanager.controller.property;

import java.util.List;
import it.euris.gymsmanager.entity.property.Property;
import it.euris.gymsmanager.service.property.PropertyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe CONTROLLER dove verranno esposti tutti i metodi relativi all'entità MNG al Front End
 */
@RequestMapping("/api/")
@RestController
public class PropertyController {

    @Autowired
    PropertyServiceImpl propertyService;

    /**
     * Metodo per il retrieve di tutti i manager
     *
     * @return la lista dei manager
     */
    @GetMapping(value = "property")
    public ResponseEntity<List<Property>> getAllManager() {
        return ResponseEntity.ok(propertyService.getAll());
    }

    /**
     * Metdo per il retrieve di un particolare manager
     *
     * @param id identificativo del manager
     * @return l'entità Mng con quel particolare id
     */
    @GetMapping(value = "property/{id}")
    public ResponseEntity<Property> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                propertyService.getById(id).isPresent()?
                        propertyService.getById(id).get():
                        null
        );
    }

    /**
     * Metodo per la creazione della entità manager
     *
     * @param property l'oggetto manager (conversione da json a oggetto Java automatico)
     * @return lo stesso oggetto creato
     */
    @PostMapping(value = "property",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Property> create(@RequestBody Property property) {
        return ResponseEntity.ok(propertyService.create(property));
    }

    /**
     * Metodo per l'aggiornamento di un'entità manager
     *
     * @param id l'identificativo del manager da aggiornare
     * @param property il payload che verrà sovrascritto
     * @return l'oggetto aggiornato
     */
    @PostMapping(value = "property/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Property> updateById(
            @PathVariable("id") Long id,
            @RequestBody Property property) {
        return ResponseEntity.ok(propertyService.updateById(id, property));
    }

    /**
     * Metodo per la cancellazione dell'entità
     *
     * @param id l'identificativo dell'entità da cancellare
     * @return http status ok senza contenuto
     */
    @DeleteMapping(value ="property/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
        propertyService.deleteById(id);
        propertyService.getById(id).get();
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

}
