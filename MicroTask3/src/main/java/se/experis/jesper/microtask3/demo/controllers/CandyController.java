package se.experis.jesper.microtask3.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.experis.jesper.microtask3.demo.models.Candy;
import se.experis.jesper.microtask3.demo.models.repositories.CandyRepository;
import java.util.ArrayList;

@RestController
public class CandyController {

    @Autowired
    private CandyRepository candyRepository;

    @RequestMapping(value = "/api/v1/candies", method = RequestMethod.GET)
    public ArrayList<Candy> getAllCandies() {
        var candies = candyRepository.findAll();
        return (ArrayList<Candy>) candies;
    }

    @RequestMapping(value = "/api/v1/candies", method = RequestMethod.POST)
    public ResponseEntity<Candy> createCandy(@RequestBody Candy candy) {
        candy = candyRepository.save(candy);
        return new ResponseEntity<>(candy, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/v1/candies", method = RequestMethod.PUT)
    public ResponseEntity<Candy> updateCandy(@RequestBody Candy candy) {
        var candyToUpdate = candyRepository.findById(candy.getId()).get();

        candyToUpdate.setId(candy.getId());
        candyToUpdate.setName(candy.getName());
        candyToUpdate.setType(candy.getType());
        candyToUpdate.setWeightPerUnit(candy.getWeightPerUnit());
        candyToUpdate.setCostPerUnit(candy.getCostPerUnit());

        candyRepository.save(candyToUpdate);

        return new ResponseEntity<>(candyToUpdate, HttpStatus.CREATED);

    }

   @RequestMapping(value = "/api/v1/candies/{id}", method = RequestMethod.DELETE)
    public String deleteCandy(@PathVariable String id) {
        candyRepository.deleteById(Integer.parseInt(id));
        return "Collection with id number " + id + " is now deleted";

    }

    // a try to get an endpoint which returns the total amount of candy records of each type

    /*
    @RequestMapping(value = "/api/v1/candies/candytypes", method = RequestMethod.GET)
    public ArrayList<Candy> getCandyTypes() {
        var candies = candyRepository.findAll();

        String candyData;
        int counter;

        ArrayList<> candy = candyData.split(" ");

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String candyTypes : array)
            if (hashMap.containsKey(candyTypes)) {
                counter = hashMap.get(candyTypes);
                hashMap.put(candyTypes, counter + 1);
            } else {
                hashMap.put(candyTypes, 1);
            }
            for (Map.Entry<String, Integer> entry : hashMap.entrySet())
                return (ArrayList<Candy>) candyTypes;
    }

     */
}




