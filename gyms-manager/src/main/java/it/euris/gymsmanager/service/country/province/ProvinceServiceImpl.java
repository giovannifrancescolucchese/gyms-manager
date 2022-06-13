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

}