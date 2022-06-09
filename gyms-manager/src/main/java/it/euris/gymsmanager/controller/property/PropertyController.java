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

@RequestMapping("/api/")
@RestController
public class PropertyController {

    @Autowired
    PropertyServiceImpl propertyService;

    @GetMapping(value = "property")
    public ResponseEntity<List<Property>> getAllManager() {
        return ResponseEntity.ok(propertyService.getAll());
    }

    @GetMapping(value = "property/{id}")
    public ResponseEntity<Property> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                propertyService.getById(id).isPresent()?
                        propertyService.getById(id).get():
                        null
        );
    }

    @PostMapping(value = "property",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Property> create(@RequestBody Property property) {
        return ResponseEntity.ok(propertyService.create(property));
    }

    @PostMapping(value = "property/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Property> updateById(
            @PathVariable("id") Long id,
            @RequestBody Property property) {
        return ResponseEntity.ok(propertyService.updateById(id, property));
    }

    @DeleteMapping(value ="property/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
        propertyService.deleteById(id);
        propertyService.getById(id).get();
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value ="api/property/")
    public ResponseEntity deleteAllInBatch() {
        propertyService.deleteAllInBatch();
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

}
