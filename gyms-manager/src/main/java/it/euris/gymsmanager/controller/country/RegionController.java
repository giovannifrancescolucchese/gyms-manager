package it.euris.gymsmanager.controller.country;

import java.util.List;
import it.euris.gymsmanager.entity.country.Region;
import it.euris.gymsmanager.service.country.region.RegionServiceImpl;
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
public class RegionController {

    @Autowired
    RegionServiceImpl regionService;

    @PostMapping(value = "createRegion",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Region> create(@RequestBody Region region) {
        return ResponseEntity.ok(regionService.create(region));
    }

    @PostMapping(value = "updateRegionById/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Region> updateById(
            @PathVariable("id") Long id,
            @RequestBody Region region) {
        return ResponseEntity.ok(regionService.updateById(id, region));
    }

    @GetMapping(value = "getRegionById/{id}")
    public ResponseEntity<Region> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                regionService.getById(id).isPresent()?
                        regionService.getById(id).get():
                        null
        );
    }

    @GetMapping(value = "getAllRegions")
    public ResponseEntity<List<Region>> getAllManager() {
        return ResponseEntity.ok(regionService.getAll());
    }



    @DeleteMapping(value ="deleteRegionById/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
        regionService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value ="deleteAllRegions/")
    public ResponseEntity deleteAllInBatch() {
        regionService.deleteAllInBatch();
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

}
