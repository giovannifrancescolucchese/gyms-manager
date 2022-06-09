package it.euris.gymsmanager.controller.manager;

import java.util.List;
import it.euris.gymsmanager.entity.manager.Manager;
import it.euris.gymsmanager.service.manager.ManagerServiceImpl;
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
public class ManagerController {

    @Autowired
    ManagerServiceImpl managerService;

    @GetMapping(value = "manager")
    public ResponseEntity<List<Manager>> getAllManager() {
        return ResponseEntity.ok(managerService.getAll());
    }

    @GetMapping(value = "manager/{id}")
    public ResponseEntity<Manager> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                managerService.getById(id).isPresent()?
                        managerService.getById(id).get():
                        null
        );
    }

    @PostMapping(value = "managers",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Manager> create(@RequestBody Manager mng) {
        return ResponseEntity.ok(managerService.create(mng));
    }

    @PostMapping(value = "manager/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Manager> updateById(
            @PathVariable("id") Long id,
            @RequestBody Manager mng) {
        return ResponseEntity.ok(managerService.updateById(id, mng));
    }

    @DeleteMapping(value ="manager/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
        managerService.deleteById(id);

        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value ="delmanager")
    public ResponseEntity deleteAllInBatch() {
        managerService.deleteAllInBatch();
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

}
