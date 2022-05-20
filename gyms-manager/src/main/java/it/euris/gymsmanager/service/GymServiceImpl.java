package it.euris.gymsmanager.service;

import it.euris.gymsmanager.entity.Gym;
import it.euris.gymsmanager.repository.GymRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GymServiceImpl implements GymService {

  @Autowired
  GymRepository gymRepository;

  @Override
  public List<Gym> getAll() {
    return gymRepository.findAll();
  }

  @Override
  public Optional<Gym> getById(Long id) {
    return gymRepository.findById(id);
  }

  @Override
  public Gym create(Gym gym) {
    return gymRepository.save(gym);
  }

  @Override
  public Gym updateById(Long id, Gym gym) {
    gym.setId(id);
    return gymRepository.save(gym);
  }

  @Override
  public void deleteById(Long id) {
    gymRepository.deleteById(id);
  }
}
