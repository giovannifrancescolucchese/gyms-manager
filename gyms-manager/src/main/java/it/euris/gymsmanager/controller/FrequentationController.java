package it.euris.gymsmanager.controller;

import it.euris.gymsmanager.entity.Customer;
import it.euris.gymsmanager.entity.Frequentation;
import it.euris.gymsmanager.service.customer.CustomerServiceImpl;
import it.euris.gymsmanager.service.frequentation.FrequentationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/")
@RestController
public class FrequentationController {

    @Autowired
    FrequentationServiceImpl frequentationService;

    @PostMapping(value = "createFrequentation",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Frequentation> create(@RequestBody Frequentation frequentation) {
        if(frequentation.getGym() != null){
            return ResponseEntity.ok(frequentationService.create(frequentation));
        }else{
            return null;
        }
    }

}
