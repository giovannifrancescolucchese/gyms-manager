package it.euris.gymsmanager.controller.country;

import java.util.ArrayList;
import java.util.List;
import it.euris.gymsmanager.entity.Gym;
import it.euris.gymsmanager.entity.country.Province;
import it.euris.gymsmanager.service.country.province.ProvinceServiceImpl;
import it.euris.gymsmanager.service.gym.GymServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/")
@RestController
public class ProvinceController {

    @Autowired
    ProvinceServiceImpl provinceService;
    @Autowired
    GymServiceImpl gymService;
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

    @GetMapping(value = "getProvinceById/{id}")
    public ResponseEntity<Province> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                provinceService.getById(id).isPresent()?
                        provinceService.getById(id).get():
                        null
        );
    }

    @GetMapping(value = "getAllGymsOfProvince/{id}")
    public ResponseEntity<List<Gym>> getAllGymsOfProvince(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                provinceService.getById(id).isPresent()?
                        getAllGymsOfProvince(id, gymService.getAll()):
                        null
        );
    }

    private List<Gym> getAllGymsOfProvince(Long id, List<Gym> gyms){

        List<Gym> gymsOfProvince = new ArrayList<>();

        for(int i = 0; i < gyms.size(); i++){
            if(gyms.get(i).getProvince().toUpperCase().contentEquals(provinceService.getById(id).get().getValue())){

                gymsOfProvince.add(gyms.get(i));
            }
        }

        return gymsOfProvince;
    }

    @GetMapping(value = "getAllProvinces")
    public ResponseEntity<List<Province>> getAllManager() {
        return ResponseEntity.ok(provinceService.getAll());
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

