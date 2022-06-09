package it.euris.gymsmanager.service.manager;


import java.util.List;
import java.util.Optional;
import it.euris.gymsmanager.entity.manager.Manager;
import it.euris.gymsmanager.service.repository.manager.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementazione della classe di servizio
 */

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    ManagerRepository mngRepository;

    /**
     * Ottiene la lista di tutti gi impianti sportivi
     *
     * @return lista di oggett Gym
     */
    @Override
    public List<Manager> getAll() {
        return mngRepository.findAll();
    }

    /**
     * Ottiene l'ggetto Gym con quel particolare Id
     *
     * @param id l'identificativo dell'ggetto che si vuole ottenere
     * @return l'oggetto Gym
     */
    @Override
    public Optional<Manager> getById(Long id) {
        return mngRepository.findById(id);
    }

    /**
     * Crea l'entità Gym
     *
     * @param mng il payload che rappresenta la nuova struttura sportiva
     * @return la nuova struttura sportiva appena creata
     */
    @Override
    public Manager create(Manager mng) {
        return mngRepository.save(mng);
    }

    /**
     * Aggiorna la palestra con quel particolare identificativo
     *
     * @param id l'identificativo della palestra da aggiornare
     * @param mng il payload che andrà a sovrascrivere i dati di quella particolare entità
     * @return la palestra aggiornata
     */
    @Override
    public Manager updateById(Long id, Manager mng) {
        mng.setId(id);
        return mngRepository.save(mng);
    }

    /**
     * Cancella l'entità con quel particolare identificativo
     *
     * @param id l'identificativo che individua la palestra da cancellare
     */
    @Override
    public void deleteById(Long id) {
        mngRepository.deleteById(id);
    }

}