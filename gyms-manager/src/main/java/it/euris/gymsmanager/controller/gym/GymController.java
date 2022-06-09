package it.euris.gymsmanager.controller.gym;

import it.euris.gymsmanager.entity.gym.Gym;
import it.euris.gymsmanager.service.gym.GymServiceImpl;
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
public class GymController {

  @Autowired
  GymServiceImpl gymService;

  @GetMapping(value = "gym")
  public ResponseEntity<List<Gym>> getAllGyms() {
    return ResponseEntity.ok(gymService.getAll());
  }

  @GetMapping(value = "gym/{id}")
  public ResponseEntity<Gym> findById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(
            gymService.getById(id).isPresent()?
                    gymService.getById(id).get():
        null
    );
  }

  @PostMapping(value = "gyms",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Gym> create(@RequestBody Gym gym) {
    return ResponseEntity.ok(gymService.create(gym));
  }

  @PostMapping(value = "gym/{id}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Gym> updateById(
      @PathVariable("id") Long id,
      @RequestBody Gym gym) {
    return ResponseEntity.ok(gymService.updateById(id, gym));
  }

  @DeleteMapping(value ="gym/{id}")
  public ResponseEntity deleteById(@PathVariable("id") Long id) {
    gymService.deleteById(id);

    return ResponseEntity.ok(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping(value ="delgym")
  public ResponseEntity deleteAllInBatch() {
    gymService.deleteAllInBatch();
    return ResponseEntity.ok(HttpStatus.NO_CONTENT);
  }

}
