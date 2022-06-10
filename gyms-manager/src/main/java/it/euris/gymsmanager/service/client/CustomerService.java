package it.euris.gymsmanager.service.client;

import it.euris.gymsmanager.entity.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> getAll();
    Optional<Customer> getById(Long id);
    Customer create(Customer client);
    Customer updateById(Long id, Customer client);
    void deleteById(Long id);
    void deleteAllInBatch();

}
