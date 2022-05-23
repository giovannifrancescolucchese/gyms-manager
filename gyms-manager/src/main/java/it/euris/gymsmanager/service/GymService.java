package it.euris.gymsmanager.service;

import it.euris.gymsmanager.entity.Gym;
import java.util.List;
import java.util.Optional;

/**
 * Interfaccia dove vengono definite le firme dei metodi del Service
 */
public interface GymService {
  List<Gym> getAll();
  Optional<Gym> getById(Long id);
  Gym create(Gym gym);
  Gym updateById(Long id, Gym gym);
  void deleteById(Long id);
}
