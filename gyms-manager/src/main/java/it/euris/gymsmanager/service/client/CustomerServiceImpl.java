package it.euris.gymsmanager.service.client;

import it.euris.gymsmanager.entity.Customer;
import it.euris.gymsmanager.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository clientRepository;

    @Override
    public Customer create(Customer client) {
        return clientRepository.save(client);
    }

    @Override
    public Customer updateById(Long id, Customer client) {
        client.setId(id);
        return clientRepository.save(client);
    }

    @Override
    public Optional<Customer> getById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public List<Customer> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }

    public void deleteAllInBatch(){
        clientRepository.deleteAllInBatch();
    }

}
