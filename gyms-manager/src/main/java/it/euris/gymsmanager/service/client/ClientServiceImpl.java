package it.euris.gymsmanager.service.client;

import it.euris.gymsmanager.entity.client.Client;
import it.euris.gymsmanager.service.repository.client.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementazione della classe di servizio
 */

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    /**
     * Ottiene la lista di tutti gi impianti sportivi
     *
     * @return lista di oggett Gym
     */
    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    /**
     * Ottiene l'ggetto Gym con quel particolare Id
     *
     * @param id l'identificativo dell'ggetto che si vuole ottenere
     * @return l'oggetto Gym
     */
    @Override
    public Optional<Client> getById(Long id) {
        return clientRepository.findById(id);
    }

    /**
     * Crea l'entità Gym
     *
     * @param client il payload che rappresenta la nuova struttura sportiva
     * @return la nuova struttura sportiva appena creata
     */
    @Override
    public Client create(Client client) {
        return clientRepository.save(client);
    }

    /**
     * Aggiorna la palestra con quel particolare identificativo
     *
     * @param id l'identificativo della palestra da aggiornare
     * @param client il payload che andrà a sovrascrivere i dati di quella particolare entità
     * @return la palestra aggiornata
     */
    @Override
    public Client updateById(Long id, Client client) {
        client.setId(id);
        return clientRepository.save(client);
    }

    /**
     * Cancella l'entità con quel particolare identificativo
     *
     * @param id l'identificativo che individua la palestra da cancellare
     */
    @Override
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }

    public void deleteAllInBatch(){
        clientRepository.deleteAllInBatch();
    }

}
