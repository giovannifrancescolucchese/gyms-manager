package it.euris.gymsmanager.controller;

import it.euris.gymsmanager.entity.Gym;
import it.euris.gymsmanager.service.GymServiceImpl;
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
public class GymController {

  @Autowired
  GymServiceImpl gymService;

  /**
   * Metodo per il retrieve di tutte le palestre
   *
   * @return la lista delle palestre
   */
  @GetMapping(value = "gyms")
  public ResponseEntity<List<Gym>> getAllGyms() {
    return ResponseEntity.ok(gymService.getAll());
  }

  /**
   * Metdo per il retrieve di una particolare palestra
   *
   * @param id identificativo della palestra
   * @return l'entità Gym con quel particolare id
   */
  @GetMapping(value = "gym/{id}")
  public ResponseEntity<Gym> findById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(
        gymService.getById(id).isPresent()?
          gymService.getById(id).get():
        null
    );
  }

  /**
   * Metodo per la creazione della entità palestra
   *
   * @param gym l'oggetto palestra (conversione da json a oggetto Java automatico)
   * @return lo stesso oggetto creato
   */
  @PostMapping(value = "gym",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Gym> create(@RequestBody Gym gym) {
    return ResponseEntity.ok(gymService.create(gym));
  }

  /**
   * Metodo per l'aggiornamento di un'entità palestra
   *
   * @param id l'identificativo della palestra da aggiornare
   * @param gym il payload che verrà sovrascritto
   * @return l'oggetto aggiornato
   */
  @PostMapping(value = "gym/{id}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Gym> updateById(
      @PathVariable("id") Long id,
      @RequestBody Gym gym) {
    return ResponseEntity.ok(gymService.updateById(id, gym));
  }

  /**
   * Metodo per la cancellazione dell'entità
   *
   * @param id l'identificativo dell'entità da cancellare
   * @return http status ok senza contenuto
   */
  @DeleteMapping(value ="gym/{id}")
  public ResponseEntity deleteById(@PathVariable("id") Long id) {
    gymService.deleteById(id);
    return ResponseEntity.ok(HttpStatus.NO_CONTENT);
  }



}
