package it.euris.gymsmanager.service.customer;

import it.euris.gymsmanager.entity.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> getAll();
    Optional<Customer> getById(Long id);
    Customer create(Customer customer);
    Customer updateById(Long id, Customer customer);
    void deleteById(Long id);
    void deleteAllInBatch();

}
