package it.euris.gymsmanager.service.country.province;

import it.euris.gymsmanager.entity.country.Province;
import java.util.List;
import java.util.Optional;

public interface ProvinceService {

    List<Province> getAll();
    Optional<Province> getById(Long id);
    Province create(Province province);
    Province updateById(Long id, Province province);
    void deleteById(Long id);
    void deleteAllInBatch();

}
