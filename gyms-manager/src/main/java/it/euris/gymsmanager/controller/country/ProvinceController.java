package it.euris.gymsmanager.controller.country;

import java.util.List;
import it.euris.gymsmanager.entity.country.Province;
import it.euris.gymsmanager.service.country.province.ProvinceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/")
@RestController
public class ProvinceController {

    @Autowired
    ProvinceServiceImpl provinceService;

    @GetMapping(value = "getAllProvinces")
    public ResponseEntity<List<Province>> getAllManager() {
        return ResponseEntity.ok(provinceService.getAll());
    }

}

