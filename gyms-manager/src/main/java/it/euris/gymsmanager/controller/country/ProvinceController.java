package it.euris.gymsmanager.controller.country;

import java.util.List;
import it.euris.gymsmanager.entity.country.Province;
import it.euris.gymsmanager.service.country.province.ProvinceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping(value = "getProvinceById/{id}")
    public ResponseEntity<Province> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                provinceService.getById(id).isPresent()?
                        provinceService.getById(id).get():
                        null
        );
    }

    @PostMapping(value = "createProvince",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Province> create(@RequestBody Province province) {
        return ResponseEntity.ok(provinceService.create(province));
    }

    @PostMapping(value = "updateProvinceById/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Province> updateById(
            @PathVariable("id") Long id,
            @RequestBody Province province) {
        return ResponseEntity.ok(provinceService.updateById(id, province));
    }

    @DeleteMapping(value ="deleteProvinceById/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
        provinceService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value ="deleteAllProvinces/")
    public ResponseEntity deleteAllInBatch() {
        provinceService.deleteAllInBatch();
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

}

