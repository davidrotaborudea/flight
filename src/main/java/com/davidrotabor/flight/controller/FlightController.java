package com.davidrotabor.flight.controller;

import com.davidrotabor.flight.exception.InvalidRating;
import com.davidrotabor.flight.exception.ModelNotFoundException;
import com.davidrotabor.flight.model.Flight;
import com.davidrotabor.flight.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flight")
@CrossOrigin("*")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/save")
    public long save (@RequestBody Flight flight) throws InvalidRating {
        if (flight.getRating() > 5) {
            throw new InvalidRating ("Rating must be less than 5");
        }
        flightService.save(flight);
        return flight.getIdFlight();
    }

    @GetMapping("/listAll")
    public Iterable<Flight> listAllFlights(){
        return flightService.list();
    }

    @GetMapping("/list/{id}")
    public Flight getFlight(@PathVariable("id") long id){
        Optional<Flight> flight = flightService.listId(id);
        if(flight.isPresent()){
            return flight.get();
        }
        throw new ModelNotFoundException("Flight not found");
    }

    @GetMapping("/topFlights")
    public ResponseEntity<List<Flight>> viewBestFlights(){
        List<Flight> list = flightService.viewBestFlight();
        return new ResponseEntity<List<Flight>>(list, HttpStatus.ACCEPTED);
    }

    @PutMapping
    public Flight update (@RequestBody Flight flight){
       return  flightService.update(flight);
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable("id") long id){
        return flightService.delete(id);
    }


}
