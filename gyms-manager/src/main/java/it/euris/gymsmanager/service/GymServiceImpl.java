package it.euris.gymsmanager.service;

import it.euris.gymsmanager.entity.Gym;
import it.euris.gymsmanager.repository.GymRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementazione della classe di servizio
 */

@Service
public class GymServiceImpl implements GymService {

  @Autowired
  GymRepository gymRepository;

  /**
   * Ottiene la lista di tutti gi impianti sportivi
   *
   * @return lista di oggett Gym
   */
  @Override
  public List<Gym> getAll() {
    return gymRepository.findAll();
  }

  /**
   * Ottiene l'ggetto Gym con quel particolare Id
   *
   * @param id l'identificativo dell'ggetto che si vuole ottenere
   * @return l'oggetto Gym
   */
  @Override
  public Optional<Gym> getById(Long id) {
    return gymRepository.findById(id);
  }

  /**
   * Crea l'entità Gym
   *
   * @param gym il payload che rappresenta la nuova struttura sportiva
   * @return la nuova struttura sportiva appena creata
   */
  @Override
  public Gym create(Gym gym) {
    return gymRepository.save(gym);
  }

  /**
   * Aggiorna la palestra con quel particolare identificativo
   *
   * @param id l'identificativo della palestra da aggiornare
   * @param gym il payload che andrà a sovrascrivere i dati di quella particolare entità
   * @return la palestra aggiornata
   */
  @Override
  public Gym updateById(Long id, Gym gym) {
    gym.setId(id);
    return gymRepository.save(gym);
  }

  /**
   * Cancella l'entità con quel particolare identificativo
   *
   * @param id l'identificativo che individua la palestra da cancellare
   */
  @Override
  public void deleteById(Long id) {
    gymRepository.deleteById(id);
  }
}
