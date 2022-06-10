package it.euris.gymsmanager.service.subscription;


import it.euris.gymsmanager.entity.Subscription;
import it.euris.gymsmanager.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    SubscriptionRepository subscriptionRepository;

    /**
     * Ottiene la lista di tutti gi impianti sportivi
     *
     * @return lista di oggett Gym
     */
    @Override
    public List<Subscription> getAll() {
        return subscriptionRepository.findAll();
    }

    /**
     * Ottiene l'ggetto Gym con quel particolare Id
     *
     * @param id l'identificativo dell'ggetto che si vuole ottenere
     * @return l'oggetto Gym
     */
    @Override
    public Optional<Subscription> getById(Long id) {
        return subscriptionRepository.findById(id);
    }

    /**
     * Crea l'entità Gym
     *
     * @param subscription il payload che rappresenta la nuova struttura sportiva
     * @return la nuova struttura sportiva appena creata
     */
    @Override
    public Subscription create(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    /**
     * Aggiorna la palestra con quel particolare identificativo
     *
     * @param id l'identificativo della palestra da aggiornare
     * @param subscription il payload che andrà a sovrascrivere i dati di quella particolare entità
     * @return la palestra aggiornata
     */
    @Override
    public Subscription updateById(Long id, Subscription subscription) {
        subscription.setId(id);
        return subscriptionRepository.save(subscription);
    }

    /**
     * Cancella l'entità con quel particolare identificativo
     *
     * @param id l'identificativo che individua la palestra da cancellare
     */
    @Override
    public void deleteById(Long id) {
        subscriptionRepository.deleteById(id);
    }

    public void deleteAllInBatch(){
        subscriptionRepository.deleteAllInBatch();
    }

}
