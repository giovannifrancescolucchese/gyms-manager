package it.euris.gymsmanager.controller;

import java.util.List;
import it.euris.gymsmanager.entity.Owner;
import it.euris.gymsmanager.service.owner.OwnerServiceImpl;
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
public class OwnerController {

    @Autowired
    OwnerServiceImpl ownerService;

    @PostMapping(value = "createOwner",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Owner> create(@RequestBody Owner owner) {
        return ResponseEntity.ok(ownerService.create(owner));
    }

    @PostMapping(value = "updateOwnerById/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Owner> updateById(
            @PathVariable("id") Long id,
            @RequestBody Owner owner) {
        return ResponseEntity.ok(ownerService.updateById(id, owner));
    }

    @GetMapping(value = "getOwnerById/{id}")
    public ResponseEntity<Owner> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                ownerService.getById(id).isPresent()?
                        ownerService.getById(id).get():
                        null
        );
    }

    @GetMapping(value = "getAllOwners")
    public ResponseEntity<List<Owner>> getAllManager() {
        return ResponseEntity.ok(ownerService.getAll());
    }

    @DeleteMapping(value ="deleteOwnerById/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
        ownerService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value ="deleteAllOwners/")
    public ResponseEntity deleteAllInBatch() {
        ownerService.deleteAllInBatch();
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

}
