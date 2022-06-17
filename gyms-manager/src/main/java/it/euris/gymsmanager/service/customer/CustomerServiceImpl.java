package it.euris.gymsmanager.service.customer;

import it.euris.gymsmanager.entity.Customer;
import it.euris.gymsmanager.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateById(Long id, Customer customer) {
        customer.setId(id);
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> getById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    public void deleteAllInBatch(){
        customerRepository.deleteAllInBatch();
    }

}
