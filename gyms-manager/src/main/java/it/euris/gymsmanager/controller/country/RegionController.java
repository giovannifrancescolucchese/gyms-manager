package it.euris.gymsmanager.controller.country;

import java.util.List;
import it.euris.gymsmanager.entity.country.Region;
import it.euris.gymsmanager.service.country.region.RegionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/")
@RestController
public class RegionController {

    @Autowired
    RegionServiceImpl regionService;


    @GetMapping(value = "getAllRegions")
    public ResponseEntity<List<Region>> getAllManager() {
        return ResponseEntity.ok(regionService.getAll());
    }

}
