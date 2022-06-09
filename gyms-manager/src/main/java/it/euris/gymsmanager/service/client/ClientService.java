package it.euris.gymsmanager.service.client;

import it.euris.gymsmanager.entity.client.Client;
import java.util.List;
import java.util.Optional;

/**
 * Interfaccia dove vengono definite le firme dei metodi del Service
 */
public interface ClientService {
    List<Client> getAll();
    Optional<Client> getById(Long id);
    Client create(Client client);
    Client updateById(Long id, Client client);
    void deleteById(Long id);
    void deleteAllInBatch();


}
