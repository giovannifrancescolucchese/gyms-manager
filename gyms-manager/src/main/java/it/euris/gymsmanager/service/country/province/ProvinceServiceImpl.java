package it.euris.gymsmanager.service.country.province;

import it.euris.gymsmanager.entity.country.Province;
import it.euris.gymsmanager.repository.country.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    ProvinceRepository provinceRepository;

    @Override
    public List<Province> getAll() {
        return provinceRepository.findAll();
    }


    @Override
    public Optional<Province> getById(Long id) {
        return provinceRepository.findById(id);
    }

    @Override
    public Province create(Province province) {
        return provinceRepository.save(province);
    }

    @Override
    public Province updateById(Long id, Province province) {
        province.setId(id);
        return provinceRepository.save(province);
    }

    @Override
    public void deleteById(Long id) {
        provinceRepository.deleteById(id);
    }

    public void deleteAllInBatch(){
        provinceRepository.deleteAllInBatch();
    }

}