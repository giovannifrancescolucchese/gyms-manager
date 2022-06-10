package it.euris.gymsmanager.service.country.region;

import it.euris.gymsmanager.entity.country.Region;
import it.euris.gymsmanager.repository.country.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    RegionRepository regionRepository;

    @Override
    public List<Region> getAll() {
        return regionRepository.findAll();
    }


    @Override
    public Optional<Region> getById(Long id) {
        return regionRepository.findById(id);
    }

    @Override
    public Region create(Region region) {
        return regionRepository.save(region);
    }

    @Override
    public Region updateById(Long id, Region region) {
        region.setId(id);
        return regionRepository.save(region);
    }

    @Override
    public void deleteById(Long id) {
        regionRepository.deleteById(id);
    }

    public void deleteAllInBatch(){
        regionRepository.deleteAllInBatch();
    }

}