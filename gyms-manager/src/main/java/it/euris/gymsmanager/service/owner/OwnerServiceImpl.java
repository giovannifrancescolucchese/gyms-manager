package it.euris.gymsmanager.service.owner;

import java.util.List;
import java.util.Optional;
import it.euris.gymsmanager.entity.Owner;
import it.euris.gymsmanager.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    OwnerRepository managerRepository;

    @Override
    public Owner create(Owner mng) {
        return managerRepository.save(mng);
    }

    @Override
    public Owner updateById(Long id, Owner mng) {
        mng.setId(id);
        return managerRepository.save(mng);
    }

    @Override
    public Optional<Owner> getById(Long id) {
        return managerRepository.findById(id);
    }

    @Override
    public List<Owner> getAll() {
        return managerRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        managerRepository.deleteById(id);
    }

    public void deleteAllInBatch(){
        managerRepository.deleteAllInBatch();
    }

}
