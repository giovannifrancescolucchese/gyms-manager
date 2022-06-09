package it.euris.gymsmanager.controller.manager;

import java.util.List;
import it.euris.gymsmanager.entity.manager.Manager;
import it.euris.gymsmanager.service.manager.ManagerServiceImpl;
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
public class ManagerController {

    @Autowired
    ManagerServiceImpl mngService;

    /**
     * Metodo per il retrieve di tutti i manager
     *
     * @return la lista dei manager
     */
    @GetMapping(value = "manager")
    public ResponseEntity<List<Manager>> getAllManager() {
        return ResponseEntity.ok(mngService.getAll());
    }

    /**
     * Metdo per il retrieve di un particolare manager
     *
     * @param id identificativo del manager
     * @return l'entità Mng con quel particolare id
     */
    @GetMapping(value = "manager/{id}")
    public ResponseEntity<Manager> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                mngService.getById(id).isPresent()?
                        mngService.getById(id).get():
                        null
        );
    }

    /**
     * Metodo per la creazione della entità manager
     *
     * @param mng l'oggetto manager (conversione da json a oggetto Java automatico)
     * @return lo stesso oggetto creato
     */
    @PostMapping(value = "manager",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Manager> create(@RequestBody Manager mng) {
        return ResponseEntity.ok(mngService.create(mng));
    }

    /**
     * Metodo per l'aggiornamento di un'entità manager
     *
     * @param id l'identificativo del manager da aggiornare
     * @param mng il payload che verrà sovrascritto
     * @return l'oggetto aggiornato
     */
    @PostMapping(value = "manager/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Manager> updateById(
            @PathVariable("id") Long id,
            @RequestBody Manager mng) {
        return ResponseEntity.ok(mngService.updateById(id, mng));
    }

    /**
     * Metodo per la cancellazione dell'entità
     *
     * @param id l'identificativo dell'entità da cancellare
     * @return http status ok senza contenuto
     */
    @DeleteMapping(value ="manager/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
        mngService.deleteById(id);
        mngService.getById(id).get();
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

}
