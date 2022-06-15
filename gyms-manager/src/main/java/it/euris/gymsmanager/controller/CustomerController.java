package it.euris.gymsmanager.controller;

import it.euris.gymsmanager.entity.Customer;
import it.euris.gymsmanager.service.customer.CustomerServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/")
@RestController
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerService;

    @PostMapping(value = "createCustomer",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.create(customer));
    }

    @PostMapping(value = "updateCustomerById/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> updateById(
            @PathVariable("id") Long id,
            @RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.updateById(id, customer));
    }

    @GetMapping(value = "getCustomerById/{id}")
    public ResponseEntity<Customer> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                customerService.getById(id).isPresent()?
                        customerService.getById(id).get():
                        null
        );
    }

    @GetMapping(value = "getAllCustomers")
    public ResponseEntity<List<Customer>> getAllGyms() {
        return ResponseEntity.ok(customerService.getAll());
    }

    @DeleteMapping(value ="deleteCustomerById/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
        customerService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value ="deleteAllCustomers/")
    public ResponseEntity deleteAllInBatch() {
        customerService.deleteAllInBatch();
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

}