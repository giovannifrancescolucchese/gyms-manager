package it.euris.gymsmanager.service.subscription;

import it.euris.gymsmanager.entity.Subscription;

import java.util.List;
import java.util.Optional;

public interface SubscriptionService {

        List<Subscription> getAll();
        Optional<Subscription> getById(Long id);
        Subscription create(Subscription subscription);
        Subscription updateById(Long id, Subscription subscription);
        void deleteById(Long id);
        void deleteAllInBatch();
}
