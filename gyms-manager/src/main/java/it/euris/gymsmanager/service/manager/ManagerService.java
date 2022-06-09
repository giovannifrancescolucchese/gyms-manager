package it.euris.gymsmanager.service.manager;


import it.euris.gymsmanager.entity.manager.Manager;
import java.util.List;
import java.util.Optional;

/**
 * Interfaccia dove vengono definite le firme dei metodi del Service
 */
public interface ManagerService {

    List<Manager> getAll();
    Optional<Manager> getById(Long id);
    Manager create(Manager mng);
    Manager updateById(Long id, Manager mng);
    void deleteById(Long id);

}
