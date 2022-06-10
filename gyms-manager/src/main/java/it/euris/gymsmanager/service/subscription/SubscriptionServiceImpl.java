package it.euris.gymsmanager.service.subscription;


import it.euris.gymsmanager.entity.Subscription;
import it.euris.gymsmanager.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Override
    public Subscription create(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription updateById(Long id, Subscription subscription) {
        subscription.setId(id);
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Optional<Subscription> getById(Long id) {
        return subscriptionRepository.findById(id);
    }

    @Override
    public List<Subscription> getAll() {
        return subscriptionRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        subscriptionRepository.deleteById(id);
    }

    public void deleteAllInBatch(){
        subscriptionRepository.deleteAllInBatch();
    }

}
