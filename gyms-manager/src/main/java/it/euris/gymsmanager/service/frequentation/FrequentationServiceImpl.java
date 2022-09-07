package it.euris.gymsmanager.service.frequentation;

import it.euris.gymsmanager.entity.Customer;
import it.euris.gymsmanager.entity.Frequentation;
import it.euris.gymsmanager.repository.CustomerRepository;
import it.euris.gymsmanager.repository.FrequentationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FrequentationServiceImpl implements FrequentationService{
    @Autowired
    FrequentationRepository frequentationRepository;

    @Override
    public Frequentation create(Frequentation frequentation) {
        return frequentationRepository.save(frequentation);
    }

    @Override
    public Frequentation updateById(Long id, Frequentation frequentation) {
        frequentation.setId(id);
        return frequentationRepository.save(frequentation);
    }

    @Override
    public Optional<Frequentation> getById(Long id) {
        return frequentationRepository.findById(id);
    }

    @Override
    public List<Frequentation> getAll() {
        return frequentationRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        frequentationRepository.deleteById(id);
    }

    public void deleteAllInBatch(){
        frequentationRepository.deleteAllInBatch();
    }
}
