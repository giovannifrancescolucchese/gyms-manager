package it.euris.gymsmanager.service.gym;

import it.euris.gymsmanager.entity.Gym;
import it.euris.gymsmanager.entity.Owner;

import java.util.List;
import java.util.Optional;

public interface GymService {

  List<Gym> getAll();
  Optional<Gym> getById(Long id);
  Gym create(Gym gym);
  Gym updateById(Long id, Gym gym);
  Owner getCurrentOwner(Long id);
  void deleteById(Long id);
  void deleteAllInBatch();

}
