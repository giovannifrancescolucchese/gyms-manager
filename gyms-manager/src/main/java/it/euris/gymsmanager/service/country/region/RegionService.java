package it.euris.gymsmanager.service.country.region;

import it.euris.gymsmanager.entity.country.Province;
import it.euris.gymsmanager.entity.country.Region;
import java.util.List;
import java.util.Optional;

public interface RegionService {

    List<Region> getAll();
    List<Province> getAllProvincesOfRegion();
    Optional<Region> getById(Long id);
    Region create(Region region);
    Region updateById(Long id, Region region);
    void deleteById(Long id);
    void deleteAllInBatch();

}
