package ua.lviv.iot.algo.part1.ProjectorLab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.algo.part1.ProjectorLab.model.Bicycle;
import ua.lviv.iot.algo.part1.business.BicycleService;

import java.util.List;
@RestController
@RequestMapping("/bicycles")
public class BicycleController {
    @Autowired
    private BicycleService bicycleService;

    @GetMapping
    public List<Bicycle> getAllBicycles() {
        return bicycleService.getAllBicycles();
    }

    @GetMapping(path = "/{id}")
    public Bicycle getBicycle(@PathVariable("id") Integer bicycleID) {
        return bicycleService.getBicycle(bicycleID);
    }

    @PostMapping
    public Bicycle create(@RequestBody Bicycle bicycle) {
        return bicycleService.createBicycle(bicycle);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Bicycle> deleteBicycle(@PathVariable("id") Integer bicycleID) {
        if (bicycleService.deleteBicycle(bicycleID)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Bicycle> updateBicycle(@PathVariable("id") Integer bicycleID,
                                                 @RequestBody Bicycle bicycle) {
        Bicycle updatedBicycle = bicycleService.updateBicycle(bicycleID, bicycle);
        if (updatedBicycle != null) {
            return ResponseEntity.ok(updatedBicycle);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
/*@RequestMapping("/bicycles")
@RestController

public class BicycleController {


    @Autowired
    private BicycleService bicycleService;

    @GetMapping
    public List<Bicycle> getAllBicycles() {

        return new LinkedList<Bicycle>(bicycles.values());

    }

    @GetMapping(path = "/{id}")
    public Bicycle getBicycle(@PathVariable("id") Integer bicycleID) {
        return bicycles.get(bicycleID);
    }

    @PostMapping
    public Bicycle create(final @RequestBody Bicycle bicycle) {
        bicycleService.createBicycle(bicycle);
        bicycle.setID(idCounter.incrementAndGet());
        bicycles.put(bicycle.getID(), bicycle);
        return bicycle;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteBicycle(@PathVariable("id") Integer bicycleID) {
        if (bicycles.remove(bicycleID) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Bicycle> updateStudents(@PathVariable("id") Integer bicycleID,
                                                  @RequestBody Bicycle bicycle) {
        if (!bicycles.containsKey(bicycleID)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        bicycle.setID(bicycleID);
        bicycles.put(bicycleID, bicycle);
        return ResponseEntity.ok(bicycle);
    }
}*/
