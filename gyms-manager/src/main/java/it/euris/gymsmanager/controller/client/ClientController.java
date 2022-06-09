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

/**
 * Classe CONTROLLER dove verranno esposti tutti i metodi relativi all'entità GYM al Front End
 */
@RequestMapping("/api/")
@RestController
public class ClientController {

    @Autowired
    ClientServiceImpl clientService;

    /**
     * Metodo per il retrieve di tutte le palestre
     *
     * @return la lista delle palestre
     */
    @GetMapping(value = "clients")
    public ResponseEntity<List<Client>> getAllGyms() {
        return ResponseEntity.ok(clientService.getAll());
    }

    /**
     * Metdo per il retrieve di una particolare palestra
     *
     * @param id identificativo della palestra
     * @return l'entità Gym con quel particolare id
     */
    @GetMapping(value = "client/{id}")
    public ResponseEntity<Client> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                clientService.getById(id).isPresent()?
                        clientService.getById(id).get():
                        null
        );
    }

    /**
     * Metodo per la creazione della entità palestra
     *
     * @param client l'oggetto palestra (conversione da json a oggetto Java automatico)
     * @return lo stesso oggetto creato
     */
    @PostMapping(value = "client",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> create(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.create(client));
    }

    /**
     * Metodo per l'aggiornamento di un'entità palestra
     *
     * @param id l'identificativo della palestra da aggiornare
     * @param client il payload che verrà sovrascritto
     * @return l'oggetto aggiornato
     */
    @PostMapping(value = "client/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> updateById(
            @PathVariable("id") Long id,
            @RequestBody Client client) {
        return ResponseEntity.ok(clientService.updateById(id, client));
    }

    /**
     * Metodo per la cancellazione dell'entità
     *
     * @param id l'identificativo dell'entità da cancellare
     * @return http status ok senza contenuto
     */
    @DeleteMapping(value ="client/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
        clientService.deleteById(id);
        clientService.getById(id).get();
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}