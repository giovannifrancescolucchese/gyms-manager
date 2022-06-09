package it.euris.gymsmanager.controller.client;

import it.euris.gymsmanager.entity.client.Client;
import it.euris.gymsmanager.service.client.ClientServiceImpl;
import java.util.List;
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
public class ClientController {

    @Autowired
    ClientServiceImpl clientService;

    @GetMapping(value = "clients")
    public ResponseEntity<List<Client>> getAllGyms() {
        return ResponseEntity.ok(clientService.getAll());
    }

    @GetMapping(value = "client/{id}")
    public ResponseEntity<Client> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                clientService.getById(id).isPresent()?
                        clientService.getById(id).get():
                        null
        );
    }

    @PostMapping(value = "client",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> create(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.create(client));
    }

    @PostMapping(value = "client/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> updateById(
            @PathVariable("id") Long id,
            @RequestBody Client client) {
        return ResponseEntity.ok(clientService.updateById(id, client));
    }

    @DeleteMapping(value ="client/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
        clientService.deleteById(id);
        clientService.getById(id).get();
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value ="client/")
    public ResponseEntity deleteAllInBatch() {
        clientService.deleteAllInBatch();
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}