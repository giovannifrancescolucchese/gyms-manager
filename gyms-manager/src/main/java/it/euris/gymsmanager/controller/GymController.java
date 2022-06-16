package it.euris.gymsmanager.controller;

import it.euris.gymsmanager.entity.Customer;
import it.euris.gymsmanager.entity.Gym;
import it.euris.gymsmanager.entity.Owner;
import it.euris.gymsmanager.service.customer.CustomerServiceImpl;
import it.euris.gymsmanager.service.gym.GymServiceImpl;

import java.util.ArrayList;
import java.util.List;

import it.euris.gymsmanager.service.owner.OwnerServiceImpl;
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
public class GymController {

    @Autowired
    GymServiceImpl gymService;
    @Autowired
    OwnerServiceImpl ownerService;
    @Autowired

    CustomerServiceImpl customerService;
    @PostMapping(value = "createGym",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Gym> create(@RequestBody Gym gym) {
        if(ownerService.getById(gym.getOwner_id()).get().getRegion().toLowerCase().contentEquals(gym.getRegion().toLowerCase()) ){
            return ResponseEntity.ok(gymService.create(gym));
        }else {
            return null;
        }

    }

    @PostMapping(value = "updateGymById/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Gym> updateById(
            @PathVariable("id") Long id,
            @RequestBody Gym gym) {
        return ResponseEntity.ok(gymService.updateById(id, gym));
    }

    @GetMapping(value = "getGymById/{id}")
    public ResponseEntity<Gym> findById(@PathVariable("id") Long id) {
      return ResponseEntity.ok(
              gymService.getById(id).isPresent()?
              gymService.getById(id).get():
              null
      );
    }
    @GetMapping(value = "getCurrentOwner/{id}")
    public ResponseEntity<Owner> getById(@PathVariable("id") Long id) {

        if (gymService.getById(id).isPresent()){

            if(ownerService.getById(gymService.getById(id).get().getOwner_id()).isPresent()) {
                return ResponseEntity.ok(
                        ownerService.getById(gymService.getById(id).get().getOwner_id()).get()
                );

            } else{
                return ResponseEntity.ok(
                        null
                );
            }
        }else {
            return ResponseEntity.ok(
                    null
            );
        }
    }

    @GetMapping(value = "getAllCustomerOfGym/{id}")
    public ResponseEntity<List<Customer>> getAllCustomerOfGym(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                gymService.getById(id).isPresent()?
                        getAllCustomer(id, customerService.getAll()):
                        null
        );
    }

    private List<Customer> getAllCustomer(Long id, List<Customer> customers){

        List<Customer> customerOfGym = new ArrayList<>();

        for(int i = 0; i < customers.size(); i++){
            if(customers.get(i).getGym().getId() == id){
                customerOfGym.add(customers.get(i));
            }
        }

        return customerOfGym;
    }

    @GetMapping(value = "getAllOwnersOfGymByRegion/{id}")
    public ResponseEntity<List<Owner>> getAllOwnersOfGymByRegion(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                gymService.getById(id).isPresent()?
                        getAllOwnersOfGymByRegion(id, ownerService.getAll()):
                        null
        );
    }

    private List<Owner> getAllOwnersOfGymByRegion(Long id, List<Owner> owners){

        List<Owner> ownersOfGym = new ArrayList<>();

        for(int i = 0; i < owners.size(); i++){
            if(owners.get(i).getRegion().toLowerCase().contentEquals(gymService.getById(id).get().getRegion().toLowerCase())){
                ownersOfGym.add(owners.get(i));
            }
        }

        return ownersOfGym;
    }

    @GetMapping(value = "getAllGyms")
    public ResponseEntity<List<Gym>> getAllGyms() {

      return ResponseEntity.ok(gymService.getAll());
    }

    @DeleteMapping(value ="deleteGymById/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
      gymService.deleteById(id);
      return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value ="deleteAllGyms/")
    public ResponseEntity deleteAllInBatch() {
      gymService.deleteAllInBatch();
      return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

}