package it.euris.gymsmanager.service.country.region;

import it.euris.gymsmanager.entity.country.Region;
import it.euris.gymsmanager.repository.country.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    RegionRepository regionRepository;

    @Override
    public List<Region> getAll() {
        return regionRepository.findAll();
    }

}