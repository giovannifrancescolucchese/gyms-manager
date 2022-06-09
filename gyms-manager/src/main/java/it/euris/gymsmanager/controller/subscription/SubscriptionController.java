package it.euris.gymsmanager.controller.subscription;

import java.util.List;
import it.euris.gymsmanager.entity.subscription.Subscription;
import it.euris.gymsmanager.service.subscription.SubscriptionServiceImpl;
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
public class SubscriptionController {

    @Autowired
    SubscriptionServiceImpl subscriptionService;

    @GetMapping(value = "subscription")
    public ResponseEntity<List<Subscription>> getAllManager() {
        return ResponseEntity.ok(subscriptionService.getAll());
    }

    @GetMapping(value = "subscription/{id}")
    public ResponseEntity<Subscription> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                subscriptionService.getById(id).isPresent() ?
                        subscriptionService.getById(id).get() :
                        null
        );
    }

    @PostMapping(value = "subscription",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Subscription> create(@RequestBody Subscription subscription) {
        return ResponseEntity.ok(subscriptionService.create(subscription));
    }

    @PostMapping(value = "subscription/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Subscription> updateById(
            @PathVariable("id") Long id,
            @RequestBody Subscription subscription) {
        return ResponseEntity.ok(subscriptionService.updateById(id, subscription));
    }

    @DeleteMapping(value = "subscription/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
        subscriptionService.deleteById(id);
        subscriptionService.getById(id).get();
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value ="api/subscription/")
    public ResponseEntity deleteAllInBatch() {
        subscriptionService.deleteAllInBatch();
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}