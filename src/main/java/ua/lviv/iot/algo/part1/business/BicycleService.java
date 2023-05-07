package ua.lviv.iot.algo.part1.business;

import org.springframework.stereotype.Service;
import ua.lviv.iot.algo.part1.ProjectorLab.model.Bicycle;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BicycleService {
    private Map<Integer, Bicycle> bicycles = new HashMap<>();
    private AtomicInteger idCounter = new AtomicInteger();

    public Bicycle createBicycle(Bicycle bicycle){
        bicycle.setID(idCounter.incrementAndGet());
        bicycles.put(bicycle.getID(), bicycle);
        return bicycle;
    }

    public Bicycle getBicycle(Integer bicycleID) {
        return bicycles.get(bicycleID);
    }

    public List<Bicycle> getAllBicycles() {
        return new LinkedList<Bicycle>(bicycles.values());
    }

    public boolean deleteBicycle(Integer bicycleID) {
        return bicycles.remove(bicycleID) != null;
    }

    public Bicycle updateBicycle(Integer bicycleID, Bicycle bicycle) {
        bicycle.setID(bicycleID);
        bicycles.put(bicycleID, bicycle);
        return bicycle;
    }
}